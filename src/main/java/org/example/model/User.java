package org.example.model;


// need to include annotation here--data? component?
public class User {

    private int userId;
    private String name;
    private String phoneNumber;

    public User() {}

    public User(int userId, String name, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
