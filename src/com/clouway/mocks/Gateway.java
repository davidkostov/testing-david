package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Gateway {

    private Validator validator;
    private Messenger messenger;

    public Gateway(Validator validator, Messenger messenger){
        this.validator = validator;
        this.messenger = messenger;
    }

    public boolean passMessage(Message message){
        return validator.isValid(message) && messenger.sendMessage(message);
    }

}
