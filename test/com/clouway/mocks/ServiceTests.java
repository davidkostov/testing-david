package com.clouway.mocks;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class ServiceTests {

    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    UserDB userDB = mockery.mock(UserDB.class);
    UserValidator validator = mockery.mock(UserValidator.class);
    UserRepository repository = new UserRepository(userDB,validator);

    @Test
    public void successfulRegistration(){
        User user = new User("Alen Walker",19,0001);

        mockery.checking(new Expectations() {{
            oneOf(userDB).register(user);
            oneOf(validator).isValidForRegister(user.getAgeString()); will(returnValue(true));
        }});

        assertTrue(repository.isAdult(user.getAgeString()));
        repository.registerUser(user);
    }

    @Test
    public void unsuccessfulRegistrationDueToUnderageUser(){
        User user = new User("Alen Walker", 9,0001);

        mockery.checking(new Expectations() {{
            oneOf(validator).isValidForRegister(user.getAgeString()); will(returnValue(false));
        }});

        assertFalse(repository.isAdult(user.getAgeString()));
    }

    @Test
    public void unsuccessfulRegistrationDueToOverageUser(){
        User user = new User("Alen Walker", 101,0001);

        mockery.checking(new Expectations() {{
            oneOf(validator).isValidForRegister(user.getAgeString()); will(returnValue(false));
        }});

        assertFalse(repository.isAdult(user.getAgeString()));
    }

    @Test
    public void extractUserAgeFromDBSuccessful(){
        mockery.checking(new Expectations() {{
            oneOf(userDB).isAdult(0001); will(returnValue(true));
            oneOf(userDB).getUserAge(0001); will(returnValue(20));
        }});

        assertThat(repository.extractAge(0001), equalTo(20));
    }

    @Test(expected = InvalidUserException.class)
    public void extractUnderageUserAgeFromDBUnsuccessful(){
        mockery.checking(new Expectations() {{
            oneOf(userDB).isAdult(0001); will(returnValue(false));
        }});

        repository.extractAge(0001);
    }

}
