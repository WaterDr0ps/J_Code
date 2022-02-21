package nuist_1.Experiment.BankSystem_4;

public class SavingAccount extends Account{

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
