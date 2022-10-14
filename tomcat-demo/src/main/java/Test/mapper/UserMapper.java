package Test.mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

/**
 * @author Administrator
 */
public interface UserMapper {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 查询用户名
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    int register(@Param("username") String username,@Param("password") String password);
}
