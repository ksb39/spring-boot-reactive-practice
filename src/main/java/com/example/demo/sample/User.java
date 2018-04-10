package com.example.demo.sample;

public class User {
    public static final User SKYLER = new User();
    public static final User JESSE = new User();
    public static final User SAUL = new User();

    private String username;
    private String firstname;
    private String lastname;

    public User() {}
    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return this.username;
    }
    public String getFirstname() {
        return this.firstname;
    }
    public String getLastname() {
        return this.lastname;
    }

}
