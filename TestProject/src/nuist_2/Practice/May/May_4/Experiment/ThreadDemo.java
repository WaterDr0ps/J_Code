package nuist_2.Practice.May.May_4.Experiment;

import javax.xml.crypto.Data;

/**
 * @author Eliot
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable r=new MyThread();
        Thread t=new Thread(r);
        t.start();
        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            if(i==20){
                Thread.currentThread().stop() ;
            }
        }
    }
}
