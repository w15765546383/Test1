package smb.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private  int uid;
    private  String username;
    private  String sex;
    private Date birthday;
    private  String address;


    public User() {
    }

    public User(int uid, String username, String sex, Date birthday, String address) {
        this.uid = uid;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
