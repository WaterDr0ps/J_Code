package nuist_2.Practice.May.May_4.Experiment;

/**
 * @author Eliot
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("thread is running "+i);
        }
    }
}
