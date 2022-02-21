package nuist_2;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class text {
    public static void main(String[] args) {
        /*String s="55 53 12 98 13 6";
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

        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s=sdf.format(d);
        System.out.println(s);
    }
}
