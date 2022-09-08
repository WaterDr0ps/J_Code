package nuist_2.Practice.Aug.Aug_31.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class UserServiceProxy {
    /**
     * 创建代理的必要步骤
     * @param userService 实现类对象
     * @return 返回method.invoke后的对象
     */
    public static UserService getProxy(UserServiceImpl userService){
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTime=System.currentTimeMillis();
                        Object obj = method.invoke(userService, args);
                        long endTime=System.currentTimeMillis();
                        System.out.println(method.getName()+"的运行时间："+(endTime-startTime)/1000.0+"s");
                        return obj;
                    }
                });
    }
}
