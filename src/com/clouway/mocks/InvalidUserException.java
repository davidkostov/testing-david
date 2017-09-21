package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String message){
        super(message);
    }

}
