package nuist_2.Practice.May.May_4;

/**
 * @author Eliot
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Account acc=new Account(1000);

        Thread t1=new DrawThread(acc,"张三");
        Thread t2=new DrawThread(acc,"李四");

        t1.start();
        t2.start();
    }
}
