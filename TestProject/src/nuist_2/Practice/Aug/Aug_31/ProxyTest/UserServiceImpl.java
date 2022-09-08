package nuist_2.Practice.Aug.Aug_31.ProxyTest;

/**
 * @author Administrator
 */
public class UserServiceImpl implements UserService {

    @Override
    public String login(String loginName, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s="用户名或密码错误";
        if("admin".equals(loginName) && "123456".equals(password)){
            s="登陆成功";
        }
        return s;
    }

    @Override
    public void deleteUser() {
        System.out.println("正在删除当前用户\n..............");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("删除成功");
    }

    @Override
    public String searchUser(String name) {
        System.out.println("正在查找\n................");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s="用户名不存在";
        if("admin".equals(name)){
            s="查找成功";
        }
        return s;
    }
}
