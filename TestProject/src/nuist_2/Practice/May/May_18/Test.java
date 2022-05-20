package nuist_2.Practice.May.May_18;

import java.io.File;

/**
 * @author Eliot
 */
public class Test {

    public static int totalNumber;
    public static int lastBottleNumber;
    public static int lastCapNumber;

    public static void main(String[] args) {
//        File file=new File("D:\\南信大作业");
//        searchFile(file,"面向对象程序设计实验1");
        buyBear(10);
        System.out.println(totalNumber+" "+lastBottleNumber+" "+lastCapNumber);

    }

    public static void buyBear(int money){
        int buyNumber=money/2;
        totalNumber+=buyNumber;

        int capNumber=lastCapNumber+buyNumber;
        int bottleNumber=lastBottleNumber+buyNumber;

        int allMoney=0;
        if(capNumber>=4){
            allMoney+=(capNumber/4)*2;
        }
        lastCapNumber=capNumber%4;

        if(bottleNumber>=2){
            allMoney+=(bottleNumber/2)*2;
        }
        lastBottleNumber=bottleNumber%2;

        if(allMoney>=2){
            buyBear(allMoney);
        }

    }

    public static void searchFile(File dir,String fileName){
        if(dir!=null&&dir.isDirectory()){
            File[] files=dir.listFiles();
            if (files!=null&&files.length>0) {
                for (File file : files) {
                    if(file.isFile()){
                       if(file.getName().contains(fileName)){
                           System.out.println("找到了："+file.getAbsolutePath());
                       }
                    }else{
                        searchFile(file,fileName);
                    }
                }
            }
        }else{
            System.out.println("搜索位置不是文件夹");
        }
    }
}
