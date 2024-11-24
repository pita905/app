package com.example.myapplication;

public class UserDetails {
    private String USERS_NAME;
    private String USERS_PWD;
    private String USERS_EMAIL;
    private String USER_PHONE;
//creating user object
    public UserDetails() {
        this.USERS_NAME = USERS_NAME;
        this.USERS_PWD = USERS_PWD;
        this.USERS_EMAIL = USERS_EMAIL;
        this.USER_PHONE = USER_PHONE;
    }

    public UserDetails(String USERS_NAME, String USERS_PWD, String USERS_EMAIL, String USER_PHONE) {
        this.USERS_NAME = USERS_NAME;
        this.USERS_PWD = USERS_PWD;
        this.USERS_EMAIL = USERS_EMAIL;
        this.USER_PHONE = USER_PHONE;
    }
//getters and setters
    public String getUSERS_NAME() {
        return USERS_NAME;
    }

    public void setUSERS_NAME(String USERS_NAME) {
        this.USERS_NAME = USERS_NAME;
    }

    public String getUSERS_PWD() {
        return USERS_PWD;
    }

    public void setUSERS_PWD(String USERS_PWD) {
        this.USERS_PWD = USERS_PWD;
    }

    public String getUSERS_EMAIL() {
        return USERS_EMAIL;
    }

    public void setUSERS_EMAIL(String USERS_EMAIL) {
        USERS_EMAIL = USERS_EMAIL;
    }

    public String getUSER_PHONE() {
        return USER_PHONE;
    }

    public void setUSER_PHONE(String USER_PHONE) {
        this.USER_PHONE = USER_PHONE;
    }
}
