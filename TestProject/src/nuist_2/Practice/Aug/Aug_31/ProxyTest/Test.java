package nuist_2.Practice.Aug.Aug_31.ProxyTest;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        UserService userService=UserServiceProxy.getProxy(new UserServiceImpl());
        System.out.println(userService.login("admin", "123456"));
        System.out.println(userService.searchUser("admin"));
        userService.deleteUser();
    }
}
