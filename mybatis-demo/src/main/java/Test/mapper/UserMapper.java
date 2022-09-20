package Test.mapper;

import Test.pojo.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {
    List<User> selectAll();
}
