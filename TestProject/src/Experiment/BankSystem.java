package Experiment;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        String[] account = new String[5];
        String[] password = new String[5];
        int[] money = new int[5];
        account[0]="w001";password[0]="001";
        account[1]="w002";password[1]="002";
        account[2]="w003";password[2]="003";
        account[3]="w004";password[3]="004";
        account[4]="w005";password[4]="005";
        Scanner sc=new Scanner(System.in);
        System.out.println("欢迎使用银行管理系统，请输入账号：");
        int i=0;
        boolean flag=false;
        while(!flag){
            String acc = sc.nextLine();
            for(i=0;i<account.length;i++){
                if(account[i].equals(acc)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println("账号不存在,请重新输入：");
            }
        }
        if(flag){
            System.out.println("您好" + account[i] + ",请输入您的密码：");
            int count=1;
            while(true){
                String pas=sc.nextLine();
                if(password[i].equals(pas)){
                    System.out.println("欢迎进入系统");
                    while(true){
                        System.out.println("请选择您的操作，1-存款，2-取款，3-查询余额，其他-退出系统");
                        int index=sc.nextInt();
                        switch (index){
                            case 1:
                                System.out.println("请输入您需要存入的金额：");
                                int save=sc.nextInt();
                                money[i]+=save;
                                System.out.println("成功存入"+save+"元");
                                break;
                            case 2:
                                System.out.println("请输入您需要取出的金额：");
                                int take =sc.nextInt();
                                if(take >money[i]){
                                    System.out.println("余额不足");
                                }else{
                                    money[i]-= take;
                                    System.out.println("成功取出"+take+"元");
                                }
                                break;
                            case 3:
                                System.out.println("您的余额为："+money[i]);
                                break;
                            default:
                                System.out.println("欢迎下次光临！");
                                System.exit(-1);
                        }
                    }
                }else{
                    if(count==3){
                        System.out.println("账户锁定");
                        System.exit(-1);
                    }
                    System.out.println("密码错误，请重新输入：");
                    System.out.println("你还有"+(3-count)+"次机会");
                    count++;
                }
            }
        }
    }
}
