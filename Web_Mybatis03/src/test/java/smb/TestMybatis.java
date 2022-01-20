package smb;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import smb.dao.UserDao;
import smb.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    private UserDao mapper;
    private SqlSession sqlSession;
    private InputStream is;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "sqlmapconfig.xml";
        is = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(is);
    }

    /**
     * Dao --> Dao.xml
     * SQLSession代表和数据库的一次会话，用完关闭
     * SQLSession和connection都是线程非安全的，每一次都应该获取新的对象
     * getMapper():mapper没有实现类，mybatis会为接口生成动态代理对象
     * <p>
     * 根据xml配置文件获取factory对象，
     * sql映射文件：配置每一个sql，以及封装规则等
     * 使用sql
     *
     * @throws IOException
     */
    @Before
    public void test1() throws IOException {
        //获取对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取session对象
        sqlSession = sqlSessionFactory.openSession();
        //获取接口实现类代理对象

        //会为接口生成一个代理对象执行CRUD
        mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test
    public void addUser() {
        User user = new User(null, "李四", "男", new Date(), "召唤师峡谷");
        int i = mapper.addUser(user);
        System.out.println(user.getUid());
    }

    @Test
    public void searchById(){
        System.out.println(mapper.searchById(1));
    }

    @Test
    public void updateUser(){
        Map <String,Object> map = new HashMap <> ();
        map.put("uid",1);
        map.put("username","王五");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","上海");
        mapper.updateUser(map);
    }

    @Test
    public void deleteById(){
        mapper.deleteById(12);
    }

    @Test
    public void searchByUsername(){
        System.out.println(mapper.searchByUsername("l"));
    }

    @After
    public void destroy() {
        sqlSession.commit();
        sqlSession.close();

    }
}
