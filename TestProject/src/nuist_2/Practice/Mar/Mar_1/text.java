package nuist_2.Practice.Mar.Mar_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class text {
    public static void main(String[] args) throws IOException {
//        //ArrayList存储HashMap集合
//        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//
//        Map<String,String> map1=new HashMap<String,String>();
//        map1.put("张飞", "刘备");
//        list.add(map1);
//
//        Map<String,String> map2=new HashMap<String,String>();
//        map2.put("宋江", "晁盖");
//        list.add(map2);
//
//        for(Map<String,String> map:list){
//            Set<String> set=map.keySet();
//            for(String key:set){
//                String value=map.get(key);
//                System.out.println(key+","+value);
//            }
//        } `

//        //HashMap集合存储ArrayList
//        Map<String,ArrayList<String>> map=new HashMap<>();
//        ArrayList<String> list1=new ArrayList<>();
//        list1.add("张飞");
//        list1.add("关羽");
//        map.put("三国", list1);
//        ArrayList<String> list2=new ArrayList<>();
//        list2.add("宋江");
//        list2.add("晁盖");
//        map.put("水浒", list2);
//
//        Set<String> set=map.keySet();
//        for(String key:set){
//            ArrayList<String> value=map.get(key);
//            System.out.println(key);
//            for(String s:value){
//                System.out.println(s);
//            }
//        }

//        //键盘录入统计字符串每个字符出现的次数：aababcabcdabcde 输出a(5)b(4)c(3)d(2)e(1)
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入字符：");
//        String line = sc.nextLine();
//        Map<Character,Integer> map=new HashMap<>();
//        for(int i=0;i<line.length();i++){
//            char key=line.charAt(i);
//            Integer value=map.get(key);
//            if(value==null){
//                map.put(key, 1);
//            }else{
//                value++;
//                map.put(key, value);
//            }
//        }
//        Set<Character> set=map.keySet();
//        for(Character key:set){
//            Integer value=map.get(key);
//            System.out.print(key+"("+value+")");
//        }

//        //递归求5!
//        System.out.println(factorial(5));

//        //递归遍历目录
//        File file=new File("D:\\南信大作业");
//        lookAllFiles(file);

//        //字节流写数据
//        FileOutputStream fos=new FileOutputStream("D:\\text.txt");
//        fos.write(90);
//        fos.close();

    }

    public static void lookAllFiles(File file){
        File[] allFile=file.listFiles();
        if(allFile!=null){
            for(File f:allFile){
                if(f.isDirectory()){
                    lookAllFiles(f);
                }else{
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }

    public static int factorial(int x){
        if(x==0){
            return 1;
        }else{
            return x*factorial(x-1);
        }
    }

}
