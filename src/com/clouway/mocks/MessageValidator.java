package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class MessageValidator implements Validator{

    public boolean isValid(Message message){
        if(!message.messageLengthIsValid()) {
            throw new InvalidMessagePropertiesException("The message must be within 1-120 characters interval.");
        }
        if(!message.receiverIsValid()) {
            throw new InvalidMessagePropertiesException("The receiver is empty or not a correct e-mail.");
        }
        if(!message.titleIsValid()) {
            throw new InvalidMessagePropertiesException("The title must not be empty.");
        }
        return true;
    }

}
