package nuist_2;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class text {
    public static void main(String[] args) {

        //有一个字符串"91 27 46 38 50",写程序实现最终输出结果是"27 38 46 50 91"
        /*
        String s="91 27 46 38 50;
        String[] str=s.split(" ");
        int[] arr=new int[str.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());*/

        /*Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s=sdf.format(d);
        System.out.println(s);*/

        /*Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1;
        int day=c.get(Calendar.DATE);
        System.out.println(year+"年"+month+"月"+day+"日");*/

        //二月天：输入任意年份，显示其二月份天数
        /*Scanner sc=new Scanner(System.in);
        System.out.println("请输入任意年份：");
        int year=sc.nextInt();
        Calendar c=Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        System.out.println(year+"年的二月有："+c.get(Calendar.DATE)+"天");*/
    }
}
