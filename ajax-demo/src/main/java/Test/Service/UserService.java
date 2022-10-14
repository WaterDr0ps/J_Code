package Test.Service;

import Test.Utils.SqlSessionFactoryUtils;
import Test.mapper.UserMapper;
import Test.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Administrator
 */
public class UserService {
    private SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();

    public User select(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public void add(String username,String password){
        SqlSession sqlSession= sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add(username,password);
        sqlSession.commit();
        sqlSession.close();
    }

    public User selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }
}
