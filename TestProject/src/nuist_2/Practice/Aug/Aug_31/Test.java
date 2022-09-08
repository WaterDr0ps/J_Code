package nuist_2.Practice.Aug.Aug_31;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class Test {


    @MyTest
    public void method1(){
        System.out.println("method1");
    }

    public void method2(){
        System.out.println("method2");
    }

    @MyTest
    public void method3(){
        System.out.println("method3");
    }


}

class AnnotationDemo{
    public static void main(String[] args) throws Exception {
        Test t=new Test();
        Class<Test> c=Test.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                //对象调方法---->方法调对象
                method.invoke(t);
            }
        }
    }
}