package smb;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import smb.dao.UserDao;
import smb.pojo.User;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "sqlmapconfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(is);
    }
    @Test
    public void T1() throws IOException {
        SqlSessionFactory openSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = openSessionFactory.openSession();
        try {
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> userList = mapper.findAll();
            for (User users: userList) {
                System.out.println(users);
            }
        } finally {
            sqlSession.close();
        }
    }
}
