package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class User {

    private String name;
    private Integer age;
    private Integer userId;

    public User(String name, Integer age, Integer userId){
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    public String getAgeString() {
        return age.toString();
    }
}
