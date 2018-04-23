package com.example.demo.sample;

public class Sir {
    public static final Sir SKYLER = new Sir();
    public static final Sir JESSE = new Sir();
    public static final Sir SAUL = new Sir();

    private String username;
    private String firstname;
    private String lastname;

    public Sir() {}
    public Sir(String username, String firstname, String lastname) {
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
