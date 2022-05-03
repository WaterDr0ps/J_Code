package nuist_2.Practice.May.May_4;

/**
 * @author Eliot
 */
public class Account {
    private double money;

    public Account(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public synchronized void drawMoney(double money) {
        String name=Thread.currentThread().getName();
            if(this.money<money){
                System.out.println(name+"没有这么多钱");
            }else{
                System.out.println(name+"取钱成功："+money);
                this.money-=money;
                System.out.println("剩余："+this.money);
        }
    }
}
