package nuist_2.Practice.May.May_11;

/**
 * @author Administrator
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Account acc=new Account("1001",1000);
        new MyThread(acc, "张三").start();
        new MyThread(acc, "李四").start();



    }
}
