package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class UserRepository {
    private UserDB userDB;
    private UserValidator validator;

    public UserRepository(UserDB userDB, UserValidator validator) {
        this.userDB = userDB;
        this.validator = validator;
    }

    public void registerUser(User user) {
        userDB.register(user);
    }

    public boolean isAdult(String age) {
        return validator.isValidForRegister(age);
    }

    Integer extractAge(int userId){
        if(!userDB.isAdult(userId)){
            throw new InvalidUserException("User provided is not an adult!");
        }
        return userDB.getUserAge(userId);
    }
}