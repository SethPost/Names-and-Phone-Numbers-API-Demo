package org.example.model;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phoneNumber;

    public User() {}

    public User(int userId, String firstName, String lastName, String phoneNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
    }
}
