package Test.mapper;

import Test.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface UserMapper {
    User select(@Param("username") String username, @Param("password") String password);

    void add(@Param("username") String username, @Param("password") String password);

    User selectByUsername(String username);
}
