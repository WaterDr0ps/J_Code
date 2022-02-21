package nuist_1.Experiment.BankSystem_4;

public class LoanAccount extends Account implements Loanable{
    private double loanLimit=10000;

    @Override
    public void takeMeans() {
        System.out.println("贷款账户");
    }

    @Override
    public void requestLoan(double money) {
        loanLimit-=money;
    }

    @Override
    public void payLoad(double money) {
        loanLimit+=money;
    }

    public LoanAccount() {
    }

    public LoanAccount(String accountId, String password, double money, String idType,double loanLimit) {
        super(accountId, password, money, idType);
        setLoanLimit(loanLimit);
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }
}
