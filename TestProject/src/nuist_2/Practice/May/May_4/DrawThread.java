package nuist_2.Practice.May.May_4;

/**
 * @author Eliot
 */
public class DrawThread extends Thread{
    private Account acc;
    public DrawThread(Account acc,String name){
        super(name);
        this.acc=acc;
    }

    @Override
    public void run() {
            acc.drawMoney(1000);
    }
}
