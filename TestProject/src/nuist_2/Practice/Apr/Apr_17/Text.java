package nuist_2.Practice.Apr.Apr_17;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Eliot
 */
public class Text {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        System.out.println("==================欢迎登陆ATM系统==================");
        while (true) {
            System.out.println("1、登陆账户");
            System.out.println("2、注册账户");
            System.out.println("3、查看所有账户");
            System.out.println("-------------------------------------------------");
            System.out.print("请选择操作：");
            Scanner sc = new Scanner(System.in);
            int command = sc.nextInt();
            switch (command) {
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
                case 1:
                    login(accounts, sc);
                    break;
                case 2:
                    register(accounts, sc);
                    break;
                case 3:
                    queryAll(accounts);
                    break;
            }
        }
    }

    private static void queryAll(List<Account> accounts) {
        for(Account a:accounts){
            System.out.println(a.toString());
        }
    }

    private static void register(List<Account> accounts, Scanner sc) {
        while (true) {
            System.out.print("请输入账户名：");
            String name = sc.next();
            if (nameRepeat(accounts, name)) {
                System.out.println("账户名已经存在");
                break;
            } else {
                while (true) {
                    System.out.print("请输入密码：");
                    String password = sc.next();
                    System.out.print("请确认密码：");
                    if (password.equals(sc.next())) {
                        System.out.print("请设置当次取现额度：");
                        int limit = sc.nextInt();
                        Account newAccount = new Account(name, password, limit);
                        accounts.add(newAccount);
                        System.out.println("恭喜您，" + name + "先生/女士，" + "您开户完成，" + "您的卡号是：" + newAccount.getCard());
                        return;
                    } else {
                        System.out.println("两次密码不一样，请重新输入");
                    }
                }

            }
        }
    }

    private static void login(List<Account> accounts, Scanner sc) {
        if (accounts.size() == 0) {
            System.out.println("没有账户，请先注册");
        } else {
            while (true) {
                System.out.print("请输入卡号：");
                int card;
                try {
                    card = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("卡号输入有误，请重新登陆");
                    return;
                }

                if (!cardExist(accounts, card)) {
                    System.out.println("卡号不存在，请确认");
                } else {
                    while (true) {
                        System.out.print("请输入密码：");
                        String password = sc.next();
                        int index = cardIndex(accounts, card);
                        if (password.equals(accounts.get(index).getPassword())) {
                            System.out.println("欢迎你：" + accounts.get(index).getName() + "进入系统，您可以开始业务了");
                            operation(accounts, sc, index);
                            return;
                        } else {
                            System.out.println("密码错误，请重新输入");
                        }
                    }
                }
            }
        }
    }

    private static void operation(List<Account> accounts, Scanner sc, int index) {
        while (true) {
            System.out.println("==================欢迎进入操作页面==================");
            System.out.println("1、查询");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销账户");
            System.out.println("-------------------------------------------------");
            System.out.print("请选择操作：");
            int command = sc.nextInt();
            switch (command) {
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
                case 1:
                    query(accounts, index);
                    break;
                case 2:
                    deposit(accounts, sc, index);
                    break;
                case 3:
                    drawMoney(accounts, sc, index);
                    break;
                case 4:
                    transfer(accounts, sc, index);
                    break;
                case 5:
                    newPassword(accounts, sc, index);
                    break;
                case 6:
                    return;
                case 7:
                    closeAccounts(accounts, sc, index);
                    break;
            }
        }
    }

    /**
     * 注销账户
     *
     * @param accounts 所有账户
     * @param sc       Scanner
     * @param index    账户索引
     */
    private static void closeAccounts(List<Account> accounts, Scanner sc, int index) {

    }

    /**
     * 修改密码
     *
     * @param accounts 所有账户
     * @param sc       Scanner
     * @param index    账户索引
     */
    private static void newPassword(List<Account> accounts, Scanner sc, int index) {

    }

    /**
     * 转账
     *
     * @param accounts 所有账户
     * @param sc       Scanner
     * @param index    账户索引
     */
    private static void transfer(List<Account> accounts, Scanner sc, int index) {
        Account account = accounts.get(index);
        while(true){
            System.out.print("请输入对方卡号：");
            int card=sc.nextInt();
            if(!cardExist(accounts,card)){
                System.out.println("卡号不存在");
            }else{
                int newIndex=cardIndex(accounts,card);
                Account newAccount=accounts.get(newIndex);
                String name=account.getName();
                char namePassword=name.charAt(0);
                System.out.println("请确认["+name.replace(namePassword,'*')+name+"]的姓氏");
                if(namePassword!=sc.nextByte()){
                    System.out.println("姓氏输入有误");
                }else{
                    if(account.getBalance()==0){
                        System.out.println("先去存点钱吧（余额："+account.getBalance()+"元）");
                        return;
                    }else{
                        while(true){
                            System.out.println("请输入转账的金额：（您最多可以转"+account.getBalance()+"元）");
                            double money=sc.nextDouble();
                            if(money>account.getBalance()){
                                System.out.println("你没这么多钱转");
                            }else if(money>account.getLimit()){
                                System.out.println("超出额度（"+account.getLimit()+"元）");
                            }else{
                                account.setBalance(account.getBalance()-money);
                                newAccount.setBalance(newAccount.getBalance()+money);
                                System.out.println("转账完成，当前余额："+account.getBalance()+"元");
                                return;
                            }
                        }

                    }

                }
            }
        }
    }

    /**
     * 取款
     *
     * @param accounts 所有账户
     * @param sc       Scanner
     * @param index    账户索引
     */
    private static void drawMoney(List<Account> accounts, Scanner sc, int index) {
        Account account = accounts.get(index);
        System.out.print("请输入取款金额：");
        double money=sc.nextDouble();
        if(money>account.getLimit()){
            System.out.println("取款失败（取款大于限额）");
        }else if(money>account.getBalance()){
            System.out.println("取款失败（取款大于余额）");
        }else{
            account.setBalance(account.getBalance() - money);
            System.out.println("取款成功");
            query(accounts,index);
        }
    }

    /**
     * 存款
     *
     * @param accounts 所有账户
     * @param sc       Scanner
     * @param index    账户索引
     */
    private static void deposit(List<Account> accounts, Scanner sc, int index) {
        Account account = accounts.get(index);
        System.out.print("请输入存款金额：");
        double money=sc.nextDouble();
        if(money<=0){
            System.out.println("存款失败（金额不能小于等于0）");
        }else{
            money+=account.getBalance();
            account.setBalance(money);
            System.out.println("存款成功！");
            query(accounts,index);
        }
    }

    /**
     * 查询
     *
     * @param accounts 所有账户
     * @param index    账户索引
     */
    private static void query(List<Account> accounts, int index) {
        Account account = accounts.get(index);
        System.out.println("==================您当前账户信息如下==================");
        System.out.println("卡号：" + account.getCard());
        System.out.println("户主：" + account.getName());
        System.out.println("余额：" + account.getBalance());
        System.out.println("当次提现额度：" + account.getLimit());
    }

    //判断户主是否重复
    private static boolean nameRepeat(List<Account> accounts, String name) {
        for (Account a : accounts) {
            if (name.equals(a.getName())) {
                return true;
            }
        }
        return false;
    }

    //判断卡号是否存在
    private static boolean cardExist(List<Account> accounts, int card) {
        for (Account a : accounts) {
            if (card == a.getCard()) {
                return true;
            }
        }
        return false;
    }

    //获取卡号当前索引
    private static int cardIndex(List<Account> accounts, int card) {
        for (int i = 0; i < accounts.size(); i++) {
            if (card == accounts.get(i).getCard()) {
                return i;
            }
        }
        return -1;
    }
}
