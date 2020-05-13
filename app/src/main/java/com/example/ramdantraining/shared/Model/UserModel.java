package com.example.ramdantraining.shared.Model;

public class UserModel {

    int userID;
    String userName;
    String userPoint;
    int UserPhoto;
    String userTitle;
    String userBody;


    public int getUserID() {
        return userID;
    }

    public UserModel(int userID, String userName, String userPoint, int userPhoto) {
        this.userID = userID;
        this.userName = userName;
        this.userPoint = userPoint;
        UserPhoto = userPhoto;
    }

    public UserModel(String userName, int userPhoto, String userTitle, String userBody) {
        this.userName = userName;
        UserPhoto = userPhoto;
        this.userTitle = userTitle;
        this.userBody = userBody;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getUserBody() {
        return userBody;
    }

    public void setUserBody(String userBody) {
        this.userBody = userBody;
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
