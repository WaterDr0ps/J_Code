package Experiment.BankSystem_4;

public class LoanAccount extends Account implements Loanable{

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
