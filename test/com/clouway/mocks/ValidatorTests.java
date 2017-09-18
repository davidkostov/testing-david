package com.clouway.mocks;

import org.junit.Rule;
import org.junit.Test;

import java.security.InvalidParameterException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class ValidatorTests {

    Validator validator = new MessageValidator();

    @Test
    public void validationPasses(){
        Message message = new Message("O.o",
                "randomperson@gmail.com","Hey, wassup?!");

        assertTrue(validator.isValid(message));
    }

    @Test(expected = InvalidMessagePropertiesException.class)
    public void notValidDueToMissingTitle(){
        Message message = new Message("",
                "randomperson@gmail.com","Hey, wassup?!");

        validator.isValid(message);
    }

    @Test(expected = InvalidMessagePropertiesException.class)
    public void notValidDueToMissingReceiver(){
        Message message = new Message("O.o",
                "","Hey, wassup?!");

        validator.isValid(message);
    }

    @Test(expected = InvalidMessagePropertiesException.class)
    public void notValidDueToAnIncorrectReceiver(){
        Message message = new Message("O.o",
                "r@ndomperson@gmailcom","Hey, wassup?!");

        validator.isValid(message);
    }

    @Test(expected = InvalidMessagePropertiesException.class)
    public void notValidDueToEmptyMessage(){
        Message message = new Message("O.o",
                "randomperson@gmail.com","");

        validator.isValid(message);
    }

    @Test(expected = InvalidMessagePropertiesException.class)
    public void notValidDueToLongMessage(){
        Message message = new Message("O.o", "randomperson@gmail.com",
                "This message is looooooooooooooooooooooooooooooooooooooo" +
                        "oooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                        "oooooooooooooooooooooooooooooooooooooooooooooooooooooong");

        validator.isValid(message);
    }

}
