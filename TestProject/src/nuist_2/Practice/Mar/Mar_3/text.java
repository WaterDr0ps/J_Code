package nuist_2.Practice.Mar.Mar_3;

import java.io.*;
import java.util.*;

public class text {
    public static void main(String[] args) throws IOException {
        //集合到文件
//        Student s1=new Student("张三",80,95,60);
//        Student s2=new Student("张四",65,99,75);
//        Student s3=new Student("张五",86,56,77);
//        Student s4=new Student("张六",92,88,63);
//        Student s5=new Student("张七",92,88,63);
//        Set<Student> set=new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                int num= s2.Sum()-s1.Sum();
//                int num2=num==0?s2.getChinese()-s1.getChinese():num;
//                int num3=num2==0?s2.getMath()-s1.getMath():num2;
//                int num4=num3==0?s1.getName().compareTo(s2.getName()):num3;
//                return num4;
//            }
//        });
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        set.add(s5);
//        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\name.txt"));
//        for(Student s:set){
//            StringBuilder sb=new StringBuilder();
//            sb.append("姓名：").append(s.getName()).append("，语文：").append(s.getChinese()).append("，数学：")
//                    .append(s.getMath()).append("，英语：").append(s.getEnglish()).append("，总分是：").append(s.Sum());
//            bw.write(sb.toString());
//            bw.newLine();
//            bw.flush();
//        }
//        bw.close();


        //文件到集合
//        List<Student> list=new ArrayList<>();
//        BufferedReader br=new BufferedReader(new FileReader("D:\\name.txt"));
//        char[] ch=new char[1024];
//        String line;
//        while((line=br.readLine())!=null){
//            Student s=new Student();
//            String[] temp=line.split("，");
//            s.setName(temp[0]);
//            s.setChinese(Integer.parseInt(temp[1]));
//            s.setMath(Integer.parseInt(temp[2]));
//            s.setEnglish(Integer.parseInt(temp[3]));
//            list.add(s);
//        }
//        br.close();
//        for(Student s:list){
//            System.out.println(s.getName()+","+s.getChinese()+","+s.getMath()+","+s.getEnglish()+","+s.Sum());
//        }

        //复制单级文件夹1
//        File srcFolder=new File("D:\\南信大作业\\Java\\9.17_HelloWorld");
//        File deskFolder=new File("D:\\",srcFolder.getName());
//        if(!deskFolder.exists()){
//            deskFolder.mkdir();
//        }
//        File[] listFiles=srcFolder.listFiles();
//        for(File srcFiles:listFiles){
//            File deskFiles=new File(deskFolder,srcFiles.getName());
//            copyFiles(srcFiles,deskFiles);
//        }
//    }
//
//    private static void copyFiles(File srcFiles, File deskFiles) throws IOException {
//        BufferedReader br=new BufferedReader(new FileReader(srcFiles));
//        BufferedWriter bw=new BufferedWriter(new FileWriter(deskFiles));
//        char[] ch=new char[1024];
//        String line;
//        while((line=br.readLine())!=null){
//            bw.write(line);
//        }
//        br.close();
//        bw.close();

        //复制单级文件夹2
//        File srcFolder = new File("D:\\南信大作业\\Java\\作业和实验报告");
//        File deskFolder=new File("D:\\",srcFolder.getName());
//        if(!deskFolder.exists()){
//            deskFolder.mkdir();
//        }
//        File[] listFiles=srcFolder.listFiles();
//        for(File srcFiles:listFiles){
//            File deskFiles=new File(deskFolder,srcFiles.getName());
//            copyFiles(srcFiles,deskFiles);
//        }
//
//    }
//
//    private static void copyFiles(File srcFiles, File deskFiles) throws IOException {
//        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFiles));
//        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(deskFiles));
//        byte[] bys=new byte[1024];
//        int len;
//        while((len=bis.read(bys))!=-1){
//            bos.write(bys,0,len);
//        }
//        bis.close();
//        bos.close();


        //赋值多级文件夹
        File srcFile=new File("D:\\南信大作业\\Java\\9.17_HelloWorld");
        File destFile=new File("D:\\");
        copyFolder(srcFile,destFile);
    }

    private static void copyFolder(File srcFile, File destFile) throws IOException {
        if(srcFile.isDirectory()){
            File newFolder=new File(destFile,srcFile.getName());
            if(!newFolder.exists()){
                newFolder.mkdir();
            }
            File[] listFiles=srcFile.listFiles();
            for(File srcFiles:listFiles){
                copyFolder(srcFiles, newFolder);
            }
        }else{
            File newFile=new File(destFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }

    }

    private static void copyFile(File srcFile, File destFile) throws IOException{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] bys=new byte[1024];
        int len;
        while((len=bis.read(bys))!=-1){
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();


    }
}
