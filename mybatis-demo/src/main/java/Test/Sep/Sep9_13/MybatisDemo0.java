package Test.Sep.Sep9_13;

import Test.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.security.sasl.SaslServerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 */
public class MybatisDemo0 {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件，获取SqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);

        //获取SqlSession对象，用来执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //执行sql
        List<User> user = sqlSession.selectList("test.selectAll");

        System.out.println(user);

        sqlSession.close();
    }
}
