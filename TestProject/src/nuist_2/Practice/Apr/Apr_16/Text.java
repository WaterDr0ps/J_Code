package nuist_2.Practice.Apr.Apr_16;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {

        //case 1
        /*Scanner sc=new Scanner(System.in);
        System.out.print("请输入机票原价、月份、头等舱/经济舱：");
        int price=sc.nextInt();
        int month=sc.nextInt();
        String type=sc.next();
        switch (month){
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                if(type.equals("头等舱")){
                    System.out.println("旺季头等舱8折，折后："+price*0.8+"元");
                }else{
                    System.out.println("旺季经济舱8.5折，折后："+price*0.85+"元");
                }
                break;
            case 11:
            case 12:
            case 1:
            case 2:
            case 3:
            case 4:
                if(type.equals("头等舱")){
                    System.out.println("旺季头等舱7折，折后："+price*0.7+"元");
                }else{
                    System.out.println("旺季经济舱6.5折，折后："+price*0.65+"元");
                }
                break;
            default:
                System.out.println("月份输入有误");
        }*/

        //case 2
        /*boolean flag;
        for(int i=101;i<=200;i++){
            flag=true;
            for(int j=2;j<i/2;j++){
                if(i%j==0){
                    flag=false;
                }
            }
            if(flag){
                System.out.print(i+" ");
            }
        }*/

        //case 3
        /*String vCode=vCode();
        System.out.println("验证码是："+vCode);
        System.out.print("请输入验证码：");
        if(new Scanner(System.in).next().equals(vCode)){
            System.out.println("验证码正确");
        }else{
            System.out.println("验证码错误");
        }*/

        //case 6
        /*Scanner sc=new Scanner(System.in);
        System.out.print("请输入密码:");
        int code=sc.nextInt();
        System.out.println("加密后："+encryption(code));*/

        //case 7
        /*int[] luckNumber=createLuckNumber();
        print(luckNumber);
        int[] customNumber=customInputNumber();
        judge(luckNumber,customNumber);*/
    }
    //case 7
    /*public static int[] createLuckNumber(){
        int[] arr=new int[7];
        Random r=new Random();
        for(int i=0;i<arr.length-1;i++){
            arr[i]=r.nextInt(33)+1;
        }
        arr[6]=r.nextInt(16)+1;
        return arr;
    }
    public static int[] customInputNumber(){
        int[] arr=new int[7];
        System.out.println("请输入6红球：");
        for(int i=0;i<arr.length-1;i++){
            arr[i]=new Scanner(System.in).nextInt();
        }
        System.out.println("请输入一个蓝球：");
        arr[6]=new Scanner(System.in).nextInt();
        return  arr;
    }
    public static void judge(int[] luckNumber,int[] customNumber){
        boolean blueFlag=false;
        int redFlag=0;
        for(int i=0;i<customNumber.length-1;i++){
            for(int j=0;j<luckNumber.length-1;j++){
                if(customNumber[i]==luckNumber[j]){
                    redFlag++;
                    luckNumber[j]=0;
                }
            }
        }
        if(luckNumber[luckNumber.length-1]==customNumber[luckNumber.length-1]){
            blueFlag=true;
        }
        if(blueFlag){
            if(redFlag==0){
                System.out.println("恭喜中奖5元！");
            }else if(redFlag==1){
                System.out.println("恭喜中奖5元！");
            }else if(redFlag==2){
                System.out.println("恭喜中奖10元！！");
            }else if(redFlag==3){
                System.out.println("恭喜中奖10元！！");
            }else if(redFlag==4){
                System.out.println("恭喜中奖200元！！！");
            }else if(redFlag==5){
                System.out.println("恭喜中奖3000元！！！！");
            }else if(redFlag==6){
                System.out.println("恭喜中奖1000万！！！！！");
            }
        }else{
            if(redFlag==4){
                System.out.println("恭喜中奖10元！！");
            }else if(redFlag==5){
                System.out.println("恭喜中奖200元！！！");
            }else if(redFlag==6){
                System.out.println("恭喜中奖500万！！！！");
            }else{
                System.out.println("毛也没有");
            }
        }
    }
    public static void print(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }*/

    //case 6
    /*public static String encryption(int code){
        String password=String.valueOf(code);
        StringBuilder newCode= new StringBuilder();
        for(int i=password.length()-1;i>=0;i--){
            newCode.append(String.valueOf((Integer.parseInt(String.valueOf(password.charAt(i))) + 5) % 10));
        }
        return newCode.toString();
    }*/

    //case 3
    /*public static String vCode(){
        String code="";
        Random r=new Random();
        int flag=0;
        while(flag<5){
            int index=r.nextInt(3)+1;
            switch (index){
                default:
                    break;
                case 1:
                    int[] num={0,1,2,3,4,5,6,7,8,9};
                    code+=String.valueOf(num[r.nextInt(10)]);
                    break;
                case 2:
                    char[] lower={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                    code+=String.valueOf(lower[r.nextInt(26)]);
                    break;
                case 3:
                    char[] upper={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                    code+=String.valueOf(upper[r.nextInt(26)]);
                    break;
            }
            flag++;
        }
        return code;

    }*/
}
