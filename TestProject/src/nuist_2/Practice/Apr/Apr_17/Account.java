package nuist_2.Practice.Apr.Apr_17;

/**
 * @author Eliot
 */
public class Account {
    private int card;
    private static int idCounter=10000;
    private String name;
    private String password;
    private double balance=0.0;
    private int limit;

    public Account() {
    }

    public Account(String name,String password,int limit) {
        this.card=++idCounter;
        this.name = name;
        this.password=password;
        this.limit=limit;
    }

    public int getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "card=" + card +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", limit=" + limit +
                '}';
    }
}
