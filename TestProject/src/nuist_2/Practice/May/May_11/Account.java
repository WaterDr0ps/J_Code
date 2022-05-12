package nuist_2.Practice.May.May_11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 */
public class Account {
    private String id;
    private double money;
    Lock lock=new ReentrantLock();

    public Account() {
    }

    public Account(String id, double money) {
        this.id = id;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void drawMoney(double money){
        String name=Thread.currentThread().getName();
        if(money>this.money){
            System.out.println(name+"没这么多钱");
        }else{
            lock.lock();
            try {
                this.money-=money;
                System.out.println(name+"成功取："+money);
                System.out.println("当前剩余："+this.money);
            }  finally {
                lock.unlock();
            }

        }
    }
}
