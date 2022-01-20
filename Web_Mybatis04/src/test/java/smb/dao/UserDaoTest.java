package smb.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import smb.pojo.User;
import smb.utils.SqlSessionFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    @Test
    public  void findAll(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession ();
        UserDao mapper = sqlSession.getMapper (UserDao.class);
        System.out.println (mapper.findAllUserInfo ());
        SqlSessionFactoryUtil.commit (sqlSession);
    }
    @Test
    public  void selectByAddress(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession ();
        UserDao mapper = sqlSession.getMapper (UserDao.class);
        System.out.println (mapper.findUserListByAddress ("苏州"));
        SqlSessionFactoryUtil.commit (sqlSession);
    }
    @Test
    public  void selectByAddressAndSex(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession ();
        UserDao mapper = sqlSession.getMapper (UserDao.class);
        System.out.println (mapper.findUserListByAddressAndSex (new User (1,"网五","男",new Date (),"南京")));
        SqlSessionFactoryUtil.commit (sqlSession);
    }
    @Test
    public  void deleteById(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession ();
        UserDao mapper = sqlSession.getMapper (UserDao.class);
        List list =new ArrayList();
        list.add (11);
        list.add (14);
        list.add (13);
        mapper.deleteById (list);
        SqlSessionFactoryUtil.commit (sqlSession);
    }
}
