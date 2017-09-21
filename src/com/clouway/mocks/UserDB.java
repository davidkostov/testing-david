package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public interface UserDB {
    void register(User user);
    boolean isAdult(Integer userId);
    Integer getUserAge(Integer userId);
}