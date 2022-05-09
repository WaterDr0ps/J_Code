package nuist_2.Practice.May.May_9;

import java.util.concurrent.*;

/**
 * @author Eliot
 */
public class ExecutorPoolDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = new ThreadPoolExecutor(3,5,
                2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

//        Runnable target=new MyRunnable();
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);
//        pool.execute(target);


        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));
        Future<String> f5 = pool.submit(new MyCallable(500));

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());
    }
}
