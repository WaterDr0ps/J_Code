package Experiment;

import java.util.Arrays;
import java.util.Scanner;

public class BankSystem_2 {
    public static void main(String[] args) {
        String[] account = {"a001"};
        String[] password = {"001"};
        double[] money = new double[1];
        int[] index = new int[1];
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用银行系统2.0！请选择您的操作：1-登陆，其他-退出系统");
        if (sc.nextInt() == 1) {
            System.out.println("请输入您的账号：");
            while (true) {
                if (judgeAccount(account, sc.next(), index)) {
                    System.out.println("账号正确！请输入密码：");
                    while (true) {
                        if (judgePassword(password, sc.next(), index)) {
                            System.out.println("您好" + account[index[0]] + ",您已登陆成功！");
                            if (index[0] == 0) {
                                while (true) {
                                    System.out.println("请选择您的操作，1-注册新账号，2-注销新账号，3-查询所有账户信息，其他-重新登陆");
                                    int x = sc.nextInt();
                                    switch (x) {
                                        case 1:
                                            System.out.println("请输入新账号名：");
                                            while (true) {
                                                String input = sc.next();
                                                if (repeatAccount(account, input)) {
                                                    System.out.println("用户名重复，请重新输入：");
                                                    continue;
                                                }
                                                account=expandStringArray(account);
                                                password = expandStringArray(password);
                                                money = expandDoubleArray(money);
                                                account[account.length - 1] = input;
                                                System.out.println("请输入该账号密码：");
                                                password[password.length - 1] = sc.next();
                                                System.out.println("注册成功！");
                                                break;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("请输入要注销的账号名：");
                                            if (judgeAccount(account, sc.next(), index)) {
                                                if (index[0] == 0) {
                                                    System.out.println("管理员账户不允许删除！");
                                                } else {
                                                    account=closeAccount(account,index);
                                                    System.out.println("账户注销成功！");
                                                    break;
                                                }
                                            } else {
                                                System.out.println("账户不存在！");
                                            }
                                            break;
                                        case 3:
                                            queryAllAccount(account, password, money);
                                            break;
                                        default:
                                            break;
                                    }

                                    if (x != 1 && x != 2 && x != 3) {
                                        System.out.println("请输入您的账号：");
                                        break;
                                    }
                                }
                                break;
                            } else {
                                while (true) {
                                    System.out.println("请选择您的操作，1-存款，2-取款，3-查询余额，4-转账，其他-退出系统");
                                    int x = sc.nextInt();
                                    systemOperation(money, account, index, x);
                                }
                            }
                        } else {
                            System.out.println("密码错误！请重新输入：");
                        }
                    }
                } else {
                    System.out.println("账号不存在！请重新输入：");
                }
            }
        } else {
            System.out.println("谢谢使用！");
            System.exit(1);
        }

    }

    public static boolean judgeAccount(String[] account, String input, int[] index) {
        for (int i = 0; i < account.length; i++) {
            if (account[i].equals(input)) {
                index[0] = i;
                return true;
            }
        }
        return false;
    }

    public static boolean repeatAccount(String[] account, String input) {
        for (int i = 0; i < account.length; i++) {
            if (account[i].equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgePassword(String[] password, String input, int[] index) {
        if (password[index[0]].equals(input)) {
            return true;
        } else {
            return false;
        }
    }

    public static void saveMoney(double[] money, int[] index, double input) {
        if (input > 0) {
            money[index[0]] += input;
        }
    }

    public static boolean takeMoney(double[] money, int[] index, double input) {
        if (input > money[index[0]]) {
            return false;
        } else {
            money[index[0]] -= input;
            return true;
        }
    }

    public static void lookMoney(double[] money, int[] index) {
        System.out.println("您的余额为：" + money[index[0]]);
    }

    public static void queryAllAccount(String[] account, String[] password, double[] money) {
        for (int i = 0; i < account.length; i++) {
            if (i == 0) {
                System.out.println(i + 1 + ".账户名：" + account[i] + ",密码：" + password[i] + ",余额" + money[i] + ",身份：管理员");
            } else {
                System.out.println(i + 1 + ".账户名：" + account[i] + ",密码：" + password[i] + ",余额" + money[i] + ",身份：普通用户");
            }
        }
    }

    public static void systemOperation(double[] money, String[] account, int[] index, int x) {
        Scanner sc = new Scanner(System.in);
        switch (x) {
            case 1:
                System.out.println("请输入您要存的金额：");
                saveMoney(money, index, sc.nextDouble());
                System.out.println("存款成功！");
                break;
            case 2:
                System.out.println("请输入您要取得金额：");
                if (takeMoney(money, index, sc.nextDouble())) {
                    System.out.println("取款成功！");
                } else {
                    System.out.println("钱不够！");
                }
                break;
            case 3:
                lookMoney(money, index);
                break;
            case 4:
                int[] new_index = new int[1];
                System.out.println("请输入账号：");
                if (judgeAccount(account, sc.next(), new_index)) {
                    System.out.println("请输入转账金额：");
                    double input = sc.nextDouble();
                    if (input > money[index[0]]) {
                        System.out.println("钱不够！");
                    } else {
                        takeMoney(money, index, input);
                        saveMoney(money, new_index, input);
                        System.out.println("转账成功！");
                    }
                } else {
                    System.out.println("账户不存在！");
                }
                break;
            default:
                System.out.println("感谢您的使用！");
                System.exit(1);
        }

    }

    public static void adminOperation(String[] account, String[] password, double[] money, int[] index, int x) {
        Scanner sc = new Scanner(System.in);

    }

    public static void expandArray(String[] account, String[] password, double[] money) {
        account = Arrays.copyOf(account, account.length + 1);
        password = Arrays.copyOf(password, password.length + 1);
        money = Arrays.copyOf(money, money.length + 1);
    }

    public static String[] closeAccount(String[] account,int[] index){
        String[] arr=new String[account.length-1];
        int j=0;
        for(int i=0;i< account.length;i++){
            if(i!=index[0]){
                arr[j] = account[i];
                j++;
            }
        }
        return arr;
    }

    public static String[] expandStringArray(String[] arr){
        arr=Arrays.copyOf(arr,arr.length+1);
        return arr;
    }

    public static double[] expandDoubleArray(double[] arr){
        arr=Arrays.copyOf(arr,arr.length+1);
        return arr;
    }

}
