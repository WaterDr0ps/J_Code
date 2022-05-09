package nuist_2.Practice.May.May_9;

import java.util.concurrent.*;

/**
 * @author Eliot
 */
public class ScheduleExecutorServiceDemo {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService pool= new ScheduledThreadPoolExecutor(3,
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        pool.scheduleAtFixedRate(new MyRunnable(),0,50 , TimeUnit.MILLISECONDS);
    }
}
