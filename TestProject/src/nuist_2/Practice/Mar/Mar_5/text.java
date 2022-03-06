package nuist_2.Practice.Mar.Mar_5;

import java.io.*;

public class text {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //标准输入流
        //InputStream  is=System.in;
        //InputStreamReader isr=new InputStreamReader(is);
        //BufferedReader br=new BufferedReader(isr);
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(br.readLine());

        //标准输出流(本质上是字节输出流)
//        PrintStream ps=System.out;
//        ps.println("hello");

        //对象序列化
        //write();

        //对象反序列化
        read();

    }
    public static void write() throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\name.txt"));
        Student s=new Student("张三",20);
        oos.writeObject(s);
        oos.close();
    }

    public static void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\name.txt"));
        Object obj = ois.readObject();
        Student stu=(Student) obj;
        System.out.println(stu.getName()+","+stu.getAge());
    }
}
