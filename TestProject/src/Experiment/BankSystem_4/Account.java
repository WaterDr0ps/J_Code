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


