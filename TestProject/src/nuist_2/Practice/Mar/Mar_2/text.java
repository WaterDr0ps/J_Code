package nuist_2.Practice.Mar.Mar_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class text {
    public static void main(String[] args) throws IOException {
        //字节流读数据
//        FileInputStream fis=new FileInputStream("D:\\bit.txt");
//        byte[] b=new byte[1024];
//        int len;
//        while((len=fis.read(b))!=-1){
//            System.out.println(new String(b,0,len));
//        }
//        fis.close();

        //复制视频：
        // 1.单字节        共耗时：69322毫秒
        // 2.多字节        共耗时：132毫秒
        // 3.缓冲单字节     共耗时：293毫秒
        // 4.缓冲多字节     共耗时：38毫秒
//        long stareTime = System.currentTimeMillis();
//        method1();
//        method2();
//        method3();
//        method4();
//        long endTime = System.currentTimeMillis();
//        System.out.println("共耗时："+(endTime-stareTime)+"毫秒");

        //字符缓冲流读数据
//        BufferedReader br=new BufferedReader(new FileReader("D:\\bit.txt"));
//        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\bit.txt"));
//        bw.write("hello\r\nworld");
//        bw.flush();
//        char[] bys=new char[1024];
//        int len;
//        while((len=br.read(bys))!=-1){
//            System.out.print(new String(bys,0,len));
//        }
//        br.close();

        //集合到文件
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\bit.txt"));
//        for(String s:list){
//            bw.write(s);
//            bw.newLine();
//            bw.flush();
//        }
//        bw.close();

        //文件到集合
//        List<String> list=new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader("D:\\bit.txt"));
//        char[] ch=new char[1024];
//        String line;//直接取一行的字符
//        while((line=br.readLine())!=null){
//            list.add(line);
//        }
//        br.close();
//        for(String s:list){
//            System.out.println(s);
//        }

        //点名器
//        List<String> list=new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader("D:\\name.txt"));
//        char[] ch=new char[1024];
//        String line;
//        while((line=br.readLine())!=null){
//            list.add(line);
//        }
//        br.close();
//        Random random = new Random();
//        int i = random.nextInt(list.size());
//        System.out.println(list.get(i)+" 同学回答问题");



    }
    public static void method1() throws IOException {
        FileInputStream fis=new FileInputStream("D:\\Adobe\\PR\\2.6\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4");
        FileOutputStream fos= new FileOutputStream("D:\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4");
        int len;
        while((len=fis.read())!=-1){
            fos.write((char)len);
        }
        fis.close();
        fos.close();
    }

    public static void method2() throws IOException{
        FileInputStream fis=new FileInputStream("D:\\Adobe\\PR\\2.6\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4");
        FileOutputStream fos = new FileOutputStream("D:\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4");
        byte[] bys=new byte[1024];
        int len;
        while((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }

    public static void method3() throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Adobe\\PR\\2.6\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4"));
        int len;
        while((len=bis.read())!=-1){
            bos.write((char)len);
        }
        bis.close();
        bos.close();
    }

    public static void method4() throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Adobe\\PR\\2.6\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\《消逝的光芒2》「人与仁之战」CG动画预告 - 1.CG动画(Av464873307,P1).mp4"));
        byte[] bys=new byte[1024];
        int len;
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bis.close();
        bos.close();
    }
}
