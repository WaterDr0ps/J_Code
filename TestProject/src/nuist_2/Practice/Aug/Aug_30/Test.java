package nuist_2.Practice.Aug.Aug_30;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;

        //反射构造函数
        Constructor<?>[] allCons = reflectDemoClass.getDeclaredConstructors();
        for (Constructor<?> allCon : allCons) {
            System.out.println(Arrays.toString(allCon.getParameterTypes()) + ",参数个数:" + allCon.getParameterCount());
        }


        //反射字段
        ReflectDemo reflectDemo = new ReflectDemo();
        reflectDemo.setName("张三");
        reflectDemo.setAge(10);
        reflectDemo.setSex('男');
        try (
                PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\Administrator\\Documents\\GitHub\\J_Code\\DATE.txt", true));
        ) {
            ps.println("=================" + reflectDemoClass.getSimpleName() + "=================");
            Field[] fields = reflectDemoClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(reflectDemo);
                System.out.println(fieldName + "=" + value);
                ps.println(fieldName + "=" + value);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //反射方法
        Method[] methods = reflectDemoClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ",参数个数:" + method.getParameterCount()
                    + ",参数类型:" + Arrays.toString(method.getParameterTypes()));
        }
    }
}
