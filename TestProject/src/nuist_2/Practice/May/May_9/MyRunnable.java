package nuist_2.Practice.May.May_9;

/**
 * @author Eliot
 */
public class MyRunnable implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"->"+i);
        }
    }
}
