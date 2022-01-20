package smb;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import smb.dao.UserDao;
import smb.pojo.QueryVo;
import smb.pojo.User;
import smb.utils.SqlSessionFactoryUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
  /*  @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("uid",1);
        map.put("username","李四");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","上海");
        mapper.updateUser(map);
        SqlSessionFactoryUtil.commit(sqlSession);
    }*/

    @Test
    public void test03() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setSex("男");
        user.setAddress("上海");
        QueryVo queryVo = new QueryVo(1l, 5, user);
        List<User> userList = mapper.searchByCondition(queryVo);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commit(sqlSession);
    }
}
