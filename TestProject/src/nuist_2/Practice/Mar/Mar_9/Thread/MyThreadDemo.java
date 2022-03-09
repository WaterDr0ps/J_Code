package nuist_2.Practice.Mar.Mar_9.Thread;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread m1=new MyThread();
        MyThread m2=new MyThread();

        //设置线程名称
        m1.setName("线程1");
        m2.setName("线程2");
        //主线程设置方法
        Thread.currentThread().setName("主线程");

        //守护线程，主线程死亡随同死亡
        m1.setDaemon(true);
        m2.setDaemon(true);
        //主线程遍历
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        m1.start();
        m2.start();
    }
}
