package nuist_2.Practice.Aug.Aug_31;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class CatAgentProxy {


    public static CatSkills getProxy(Cat c){
        return (CatSkills) Proxy.newProxyInstance(c.getClass().getClassLoader(), c.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("撸猫收费");
                        Object obj = method.invoke(c, args);
                        System.out.println("结束");
                        return obj;
                    }
                });
    }
}
