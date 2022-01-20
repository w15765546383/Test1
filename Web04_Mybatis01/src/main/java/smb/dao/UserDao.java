package smb.dao;

import smb.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
