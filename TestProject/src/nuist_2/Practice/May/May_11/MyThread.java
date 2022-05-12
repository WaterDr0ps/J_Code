package nuist_2.Practice.May.May_11;

/**
 * @author Administrator
 */
public class MyThread extends Thread{
    private Account acc=new Account();
    private String name;
    public MyThread(Account acc,String name){
        super(name);
        this.acc=acc;
    }

    @Override
    public void run() {
        acc.drawMoney(1000);
    }
}
