package nuist_2.Practice.Aug.Aug_31.ProxyTest;

/**
 * @author Administrator
 */
public interface UserService {
    String login(String loginName,String password);
    void deleteUser();
    String searchUser(String name);
}
