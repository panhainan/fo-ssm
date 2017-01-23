package com.panhainan.vo;

/**
 * Created by FirePan on 2017/1/23.
 */
public class UserSignInForm {
    private String userName;
    private String userPass;

    public UserSignInForm() {
    }

    public UserSignInForm(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "UserSignForm{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

}
