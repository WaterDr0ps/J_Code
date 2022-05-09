package nuist_2.Practice.May.May_9;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Eliot
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello:"+Thread.currentThread().getName());
            }
        },2000,1000);
    }
}
