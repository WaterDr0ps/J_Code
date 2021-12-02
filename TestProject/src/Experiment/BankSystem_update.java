package Experiment;

import java.util.Scanner;

public class BankSystem_update {
    public static void main(String[] args) {
        String[] account={"w001","w002","w003","w004","w005"};
        String[] password={"001","002","003","004","005"};
        double[] money=new double[5];
        int[] index=new int[1];
        Scanner sc=new Scanner(System.in);
        System.out.println("欢迎使用系统！请输入账号：");
        while(true){
            if(judgeAccount(account,sc.nextLine(),index)){
                System.out.println("账号正确！请输入密码：");
                while(true){
                    if(judgePassword(password,sc.nextLine(),index)){
                        System.out.println("欢迎登陆银行管理系统！");
                        while(true){
                            System.out.println("请选择您的操作，1-存款，2-取款，3-查询余额，4-转账，其他-退出系统");
                            int x=sc.nextInt();
                            switch (x){
                                case 1:
                                    System.out.println("请输入您要存的金额：");
                                    saveMoney(money,index,sc.nextDouble());
                                    System.out.println("存款成功！");
                                    break;
                                case 2:
                                    System.out.println("请输入您要取得金额：");
                                    if(takeMoney(money,index,sc.nextDouble())){
                                        System.out.println("取款成功！");
                                    }else{
                                        System.out.println("钱不够！");
                                    }
                                    break;
                                case 3:
                                    lookMoney(money,index);
                                    break;
                                case 4:
                                    int[] new_index=new int[1];
                                    System.out.println("请输入账号：");
                                    if(judgeAccount(account,sc.nextLine(),new_index)){
                                        System.out.println("请输入转账金额：");
                                        double input = sc.nextDouble();
                                        takeMoney(money,index,input);
                                        saveMoney(money,new_index,input);
                                        System.out.println("转账成功！");
                                    }else{
                                        System.out.println("账户不存在！");
                                    }
                                    break;
                                default:
                                    System.out.println("感谢您的使用！");
                                    System.exit(1);
                            }
                        }
                    }else{
                        System.out.println("密码错误！请重新输入：");
                    }
                }
            }else{
                System.out.println("账号不存在！请重新输入：");
            }
        }

    }

    public static boolean judgeAccount(String[] account,String input,int[] index){
        for(int i=0;i<account.length;i++){
            if(account[i].equals(input)){
                index[0]=i;
                return true;
            }
        }
        return false;
    }

    public static boolean judgePassword(String[] password,String input,int[] index){
        if(password[index[0]].equals(input)){
            return true;
        }else{
            return false;
        }
    }

    public static void saveMoney(double[] money,int[] index,double input){
        if(input>0){
            money[index[0]]+=input;
        }
    }

    public static boolean takeMoney(double[] money,int[] index,double input){
        if(input>money[index[0]]){
            return false;
        }else{
            money[index[0]]-=input;
            return true;
        }
    }

    public static boolean giveMoney(double[] money,String[] account,int[] index,String member,double input){
        boolean flag=false;
        int[] k=new int[1];
        for(int i=0;i<account.length;i++){
            if(account[index[0]].equals(member)){
                k[0]=i;
                flag=true;
                break;
            }
        }
        if(flag){
            takeMoney(money,index,input);
            saveMoney(money,k,input);
        }
        return flag;
    }

    public static void lookMoney(double[] money,int[] index){
        System.out.println("您的余额为："+money[index[0]]);
    }
}
