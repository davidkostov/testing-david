package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Message {

    private String title, receiver, message;
    private Integer messageLength;
    private MessageValidator validator = new MessageValidator();

    public Message(String title, String receiver, String message) {
        this.message = message;
        this.title = title;
        this.receiver = receiver;
    }

    public boolean messageLengthIsValid() {
        return message.length() < 121 && message.length() > 0;
    }

    public boolean receiverIsValid(){
        return receiver.matches("^[a-zA-Z0-9]*[@][a-z]*[.][a-z]*$");
    }

    public boolean titleIsValid(){
        return title.length() > 0;
    }
}
