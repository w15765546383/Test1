package smb.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //配置文件转换为字节输入流
            InputStream is = Resources.getResourceAsStream("sqlmapconfig.xml");
            //创建对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //加载字节输入流
            sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建SqlSession对象
     *
     * @return
     */
    public static SqlSession openSqlSession() {
        return sqlSessionFactory.openSession();
    }

    /**
     * 事务提交
     *
     * @param sqlSession
     */
    public static void commit(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 事务回滚
     *
     * @param sqlSession
     */
    public static void rollBack(SqlSession sqlSession){
        sqlSession.rollback();
        sqlSession.close();
    }


}
