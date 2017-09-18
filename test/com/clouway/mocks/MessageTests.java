package com.clouway.mocks;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class MessageTests {

    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();
    Messenger messenger = mockery.mock(Messenger.class);
    Validator validator = mockery.mock(Validator.class);
    Gateway gateway = new Gateway(validator,messenger);
    Message message = new Message("Congratulations!",
            "randomperson@yahoo.com","You have won 1000$!!!");

    @Test
    public void messageSent(){
        mockery.checking(new Expectations(){{
            oneOf(validator).isValid(message); will(returnValue(true));
            oneOf(messenger).sendMessage(message); will(returnValue(true));
        }});

        assertTrue(gateway.passMessage(message));
    }

    @Test
    public void messageValidationNotPassed(){
        mockery.checking(new Expectations(){{
            oneOf(validator).isValid(message); will(returnValue(false));
        }});

        assertFalse(gateway.passMessage(message));
    }

    @Test
    public void messengerFailsToSendMessage(){
        mockery.checking(new Expectations(){{
            oneOf(validator).isValid(message); will(returnValue(true));
            oneOf(messenger).sendMessage(message); will(returnValue(false));
        }});

        assertFalse(gateway.passMessage(message));
    }

}
