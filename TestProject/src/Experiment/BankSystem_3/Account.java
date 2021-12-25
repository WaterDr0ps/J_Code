package Experiment.BankSystem_3;

public class Account {
    private String accountId;
    private String password;
    private double balance;
    private String idType;

    public Account(){}

    public Account(String accountId, String password, double balance, String idType) {
        this.accountId = accountId;
        this.password = password;
        this.balance = balance;
        this.idType = idType;
    }

    public Account(String accountId, String password, String idType) {
        this.accountId = accountId;
        this.password = password;
        this.idType = idType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public boolean judgeAccount(String account) {
        if(accountId.equals(account)){
            return true;
        }
        return false;
    }

    public boolean judgePassword(String password) {
        if(this.password.equals(password)){
            return true;
        }
        return false;
    }

    public void saveMoney(double input) {
        if (input > 0) {
            double money=getBalance()+input;
            setBalance(money);
        }
    }

    public boolean takeMoney(double input) {
        if (input > getBalance()) {
            return false;
        } else {
            double money=getBalance()-input;
            setBalance(money);
            return true;
        }
    }

    public void lookMoney() {
        System.out.println("您的余额为：" + getBalance());
    }

    public void queryAccount() {
        System.out.println("账户名："+getAccountId()+",密码："+getPassword()+",余额："+getBalance()+",类型："+getIdType());
    }
}
