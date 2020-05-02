package com.example.ramdantraining.shared.Model;

public class UserModel {

    int userID;
    String userName;
    String userPoint;
    int UserPhoto;

    public int getUserID() {
        return userID;
    }

    public UserModel(int userID, String userName, String userPoint, int userPhoto) {
        this.userID = userID;
        this.userName = userName;
        this.userPoint = userPoint;
        UserPhoto = userPhoto;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(String userPoint) {
        this.userPoint = userPoint;
    }

    public int getUserPhoto() {
        return UserPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        UserPhoto = userPhoto;
    }
}
