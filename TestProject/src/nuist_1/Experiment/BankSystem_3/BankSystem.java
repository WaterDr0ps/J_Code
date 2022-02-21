package nuist_1.Experiment.BankSystem_3;

import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Account[] accounts = new Account[100];
        int[] index=new int[1];
        int length = 0;
        accounts[index[0]] = new Account("a001", "001", "管理员");
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用银行系统2.0！请选择您的操作：1-登陆，其他-退出系统");
        if (sc.nextInt() == 1) {
            System.out.println("请输入您的账号：");
            while (true) {
                if (judgeAccount(accounts,sc.next(),index,length)) {
                    System.out.println("账号正确！请输入您的密码：");
                    while (true) {
                        if (accounts[index[0]].judgePassword(sc.next())) {
                            System.out.println("您好" + accounts[index[0]].getAccountId() + ",您已登陆成功！");
                            if (index[0] == 0) {
                                while (true) {
                                    System.out.println("请选择您的操作，1-注册新账号，2-注销新账号，3-查询所有账户信息，其他-重新登陆");
                                    int x = sc.nextInt();
                                    switch (x) {
                                        case 1:
                                            System.out.println("请输入新账户名：");
                                            ++length;
                                            index[0]++;
                                            while(true){
                                                String acc = sc.next();
                                                if(repeatAccount(accounts,acc,index[0])){
                                                    System.out.println("账户名重复！请重新输入：");
                                                    continue;
                                                }
                                                System.out.println("请输入密码：");
                                                String pas = sc.next();
                                                accounts[index[0]] = new Account(acc, pas, "普通账户");
                                                System.out.println("创建成功！");
                                                break;
                                            }
                                            break;
                                        case 2:
                                            boolean flag=false;
                                            int i;
                                            System.out.println("请输入要注销的账户名：(0退出)");
                                            while(!flag){
                                                String acc=sc.next();
                                                if(acc.equals("0")){break;}
                                                if(accounts[0].judgeAccount(acc)){
                                                    System.out.println("管理员账户不允许注销！");
                                                }
                                                for(i=1;i<=length;i++){
                                                    if(accounts[i].judgeAccount(acc)){
                                                        flag=true;
                                                        break;
                                                    }
                                                }
                                                if(!flag&&!accounts[0].judgeAccount(acc)){
                                                    System.out.println("账户名不存在！");
                                                }
                                                if(flag){
                                                    accounts[i]=null;
                                                    for(int j=i;j<length;j++){
                                                        accounts[j]=accounts[j+1];
                                                    }
                                                    length--;
                                                    System.out.println("注销成功！");
                                                }else{
                                                    System.out.println("请重新输入要注销的账户名：(0退出)");
                                                }
                                            }
                                            break;
                                        case 3:
                                            for (i = 0; i <= length; i++) {
                                                accounts[i].queryAccount();
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    if (x != 1 && x != 2 && x != 3) {
                                        System.out.println("请输入您的账号：");
                                        break;
                                    }
                                }
                            } else {
                                while (true) {
                                    System.out.println("请选择您的操作，1-存款，2-取款，3-查询余额，4-转账，,5-重新登陆,其他-退出系统");
                                    int x = sc.nextInt();
                                    switch (x) {
                                        case 1:
                                            System.out.println("请输入您要存的金额：");
                                            accounts[index[0]].saveMoney(sc.nextDouble());
                                            System.out.println("存款成功！");
                                            break;
                                        case 2:
                                            System.out.println("请输入您要取得金额：");
                                            if (accounts[index[0]].takeMoney(sc.nextDouble())) {
                                                System.out.println("取款成功！");
                                            } else {
                                                System.out.println("钱不够！");
                                            }
                                            break;
                                        case 3:
                                            accounts[index[0]].lookMoney();
                                            break;
                                        case 4:
                                            int[] new_index = new int[1];
                                            System.out.println("请输入账号：");
                                            if (judgeAccount(accounts, sc.next(), new_index,length)) {
                                                System.out.println("请输入转账金额：");
                                                double input = sc.nextDouble();
                                                if (input > accounts[index[0]].getBalance()) {
                                                    System.out.println("钱不够！");
                                                } else {
                                                    accounts[index[0]].takeMoney(input);
                                                    accounts[new_index[0]].saveMoney(input);
                                                    System.out.println("转账成功！");
                                                }
                                            } else {
                                                System.out.println("账户不存在！");
                                            }
                                            break;
                                        case 5:
                                            break;
                                        default:
                                            System.out.println("感谢您的使用！");
                                            System.exit(1);
                                            break;
                                    }
                                    if (x != 1 && x != 2 && x != 3 && x != 4) {
                                        System.out.println("请输入您的账号：");
                                        break;
                                    }
                                }
                            }
                            break;
                        } else {
                            System.out.println("密码错误！请重新输入密码：");
                        }
                    }
                } else {
                    System.out.println("账号不存在！请重新输入！");
                }
            }
        } else {
            System.out.println("感谢使用！");
        }
    }
    public static boolean repeatAccount(Account[] accounts,String account,int length) {
        for (int i = 0; i <length; i++) {
            if (accounts[i].getAccountId().equals(account)) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeAccount(Account[] accounts, String input, int[] index,int length) {
        for (int i = 0; i <= length; i++) {
            if (accounts[i].getAccountId().equals(input)) {
                index[0] = i;
                return true;
            }
        }
        return false;
    }

}
