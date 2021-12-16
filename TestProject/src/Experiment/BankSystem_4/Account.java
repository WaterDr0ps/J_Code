package Experiment.BankSystem_4;

public abstract class Account {
    private String accountId;
    private String password;
    private double money;
    private String idType;

    public Account(){}

    public Account(String accountId, String password, double money,String idType) {
        this.accountId = accountId;
        this.password = password;
        this.money=money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public abstract void takeMeans();

}

interface Loanable{
    void requestLoan(double money);//贷款额
    void payLoad(double money);//还款额
}

class SavingAccount extends Account{

    @Override
    public void takeMeans() {
        System.out.printf("储蓄账户");
    }
    private double interest;

    public SavingAccount() {
    }

    public SavingAccount(String accountId, String password, double money,String idType) {
        super(accountId, password,money, "储蓄账户");
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    void countInterest(){
        System.out.println("年利息是："+getMoney()*0.04);
    }
}

class CreditAccount extends Account{

    @Override
    public void takeMeans() {
        System.out.println("信用账户");
    }

    private double limit=10000;//额度
    private double credit;//金额

    public CreditAccount() {
    }

    public CreditAccount(String accountId, String password, double money, String idType,double credit) {
        super(accountId, password, money, "信用账户");
        setCredit(credit);
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        if(credit<-10000){
            System.out.println("超额了");
        }else{
            this.credit=credit;
        }
    }
}

class CheckingAccount extends Account{
    @Override
    public void takeMeans() {
        System.out.println("支票账户");

    }

    private final double fee=10;
    public CheckingAccount() {
    }

    public CheckingAccount(String accountId, String password, double money, String idType) {
        super(accountId, password, money, "支票账户");
        super.setMoney(money-fee);
    }

    public double getFee() {
        return fee;
    }
}

class LoanAccount extends Account implements Loanable{

    @Override
    public void takeMeans() {
        System.out.println("贷款账户");
    }

    @Override
    public void requestLoan(double money) {

    }

    @Override
    public void payLoad(double money) {

    }
}


