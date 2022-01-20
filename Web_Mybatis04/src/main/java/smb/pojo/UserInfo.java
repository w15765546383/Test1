package smb.pojo;

import java.io.Serializable;


public class UserInfo implements Serializable {
    private Integer userId;
    private String username;
    private String userSex;
    private String userBirthday;
    private String userAddress;

    public UserInfo () {
    }

    @Override
    public String toString () {
        return "UserInfo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getUserSex () {
        return userSex;
    }

    public void setUserSex (String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday () {
        return userBirthday;
    }

    public void setUserBirthday (String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress () {
        return userAddress;
    }

    public void setUserAddress (String userAddress) {
        this.userAddress = userAddress;
    }

    public UserInfo (Integer userId , String username , String userSex , String userBirthday , String userAddress) {
        this.userId = userId;
        this.username = username;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userAddress = userAddress;
    }
}
