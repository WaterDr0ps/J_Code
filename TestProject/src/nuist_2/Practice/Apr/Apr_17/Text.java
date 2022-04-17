package nuist_2.Practice.Apr.Apr_17;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        List<Account> accounts=new ArrayList<>();
        System.out.println("==================欢迎登陆ATM系统==================");
        while(true){
            System.out.println("1、登陆账户");
            System.out.println("2、注册账户");
            System.out.print("请选择操作：");
            Scanner sc=new Scanner(System.in);
            int command=sc.nextInt();
            switch (command){
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
                case 1:
                    login(accounts,sc);
                    break;
                case 2:
                    register(accounts,sc);
                    break;
            }
        }
    }

    private static void register(List<Account> accounts, Scanner sc) {
        while(true){
            System.out.print("请输入账户名：");
            String name=sc.next();
            if(nameRepeat(accounts,name)){
                System.out.println("账户名已经存在");
                break;
            }else{
                while(true){
                    System.out.print("请输入密码：");
                    String password = sc.next();
                    System.out.print("请确认密码：");
                    if(password.equals(sc.next())){
                        System.out.print("请设置本次取现额度：");
                        int limit=sc.nextInt();
                        Account newAccount=new Account(name,password,limit);
                        accounts.add(newAccount);
                        System.out.println("恭喜您，"+name+"先生/女士，"+"您开户完成，"+"您的卡号是："+newAccount.getCard());
                        return;
                    }else{
                        System.out.println("两次密码不一样，请重新输入");
                    }
                }

            }
        }
    }

    private static void login(List<Account> accounts, Scanner sc) {
        while(true){
            System.out.print("请输入卡号：");
            int card=sc.nextInt();
            if(!cardExist(accounts,card)){
                System.out.println("卡号不存在，请确认");
            }else{
                while(true){
                    System.out.print("请输入密码：");
                    String password=sc.next();
                    int index=cardIndex(accounts,card);
                    if(password.equals(accounts.get(index).getPassword())){
                        System.out.println("欢迎你："+accounts.get(index).getName()+"进入系统，您可以开始业务了");
                    }
                }
            }
        }
    }

    private static boolean nameRepeat(List<Account> accounts,String name){
        for(Account a:accounts){
            if(name.equals(a.getName())){
                return true;
            }
        }
        return false;
    }

    private static boolean cardExist(List<Account> accounts,int card){
        for(Account a:accounts){
            if(card==a.getCard()){
                return true;
            }
        }
        return false;
    }

    private static int cardIndex(List<Account> accounts,int card){
        for(int i=0;i< accounts.size();i++){
            if(card==accounts.get(i).getCard()){
                return i;
            }
        }
        return -1;
    }
}
