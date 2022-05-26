package nuist_2.Practice.May.May_26;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Properties;

/**
 * @author Eliot
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Student s=new Student("张三",20);
//        OutputStream os=new FileOutputStream("TestProject/src/data.txt");
//        ObjectOutputStream oos=new ObjectOutputStream(os);
//        oos.writeObject(s);
//        oos.close();
//
//        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("TestProject/src/data.txt"));
//        Student s1 = (Student) ois.readObject();
//        System.out.println(s1);


//        Properties properties=new Properties();
//        properties.setProperty("张三","11088");
//        String s = properties.getProperty("张三");
//        System.out.println(s);


        FileUtils.copyFile(new File("TestProject/src/data.txt"),new File("TestProject/src/data2.txt"));
    }
}
