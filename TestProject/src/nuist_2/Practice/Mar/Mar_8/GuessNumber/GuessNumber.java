package nuist_2.Practice.Mar.Mar_8.GuessNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void guess(){
        Scanner sc=new Scanner(System.in);
        int index;
        Random r=new Random();
        int ans=r.nextInt(100);
        while((index=sc.nextInt())!=ans){
            if(index>ans){
                System.out.println("大了");
            }else{
                System.out.println("小了");
            }
        }
        System.out.println("恭喜您答对了");

    }
}
