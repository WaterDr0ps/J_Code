package nuist_1.Experiment.BankSystem_4;

public class CreditAccount extends Account{

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
