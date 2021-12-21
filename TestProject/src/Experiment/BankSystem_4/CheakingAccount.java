package Experiment.BankSystem_4;

public class CheakingAccount extends Account{

    @Override
    public void takeMeans() {
        System.out.println("支票账户");

    }

    private final double fee=10;
    public CheakingAccount() {
    }

    public CheakingAccount(String accountId, String password, double money, String idType) {
        super(accountId, password, money, "支票账户");
        super.setMoney(money-fee);
    }

    public double getFee() {
        return fee;
    }
}
