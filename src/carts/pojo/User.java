package carts.pojo;

import carts.pojo.enums.UserType;

public class User {

    private String userID;
    private String userName;
    private UserType userType;

    public User(String userID, String userName, UserType userType) {
        this.userID = userID;
        this.userName = userName;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
