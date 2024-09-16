package com.example.myapplication;

public class UserDetails {
    private String userName;
    private String userPwd;
    private String UserEmail;
    private String userPhone;

    public UserDetails(String userName, String userPwd, String userEmail, String userPhone) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.UserEmail = userEmail;
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
