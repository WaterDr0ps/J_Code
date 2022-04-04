package nuist_2.Practice.Apr.Apr_4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class text {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        Class<?> s = Class.forName("nuist_2.Practice.Apr.Apr_4.Student");
//        Constructor<?> c = s.getConstructor(String.class, int.class);
//        Object obj = c.newInstance("张三", 40);
//        System.out.println(obj);

//        Class<?> c = Class.forName("nuist_2.Practice.Apr.Apr_4.Student");
//        Constructor<?> con= c.getDeclaredConstructor(String.class);
//        con.setAccessible(true);
//        Object obj = con.newInstance("张三");
//        System.out.println(obj);

//         Class<?> c=Class.forName("nuist_2.Practice.Apr.Apr_4.Student");
//         Field[] f=c.getDeclaredFields();
//         for(Field field:f){
//             System.out.println(field);
//         }
//         System.out.println("--------");
//         Field field=c.getDeclaredField("name");
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        field.setAccessible(true);
//        field.set(obj, "张三");
//        System.out.println(obj);

        Class<?> c = Class.forName("nuist_2.Practice.Apr.Apr_4.Student");
        Field[] fields=c.getDeclaredFields();
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        fields[0].setAccessible(true);
        fields[0].set(obj,"张三");
        fields[1].setAccessible(true);
        fields[1].set(obj,20);
        System.out.println(obj);
    }
}
