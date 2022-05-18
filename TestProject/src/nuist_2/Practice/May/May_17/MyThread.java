package nuist_2.Practice.May.May_17;

/**
 * @author Administrator
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                String name=Thread.currentThread().getName();
                System.out.println(name+"打印："+i);
            }
        }
    }
}
