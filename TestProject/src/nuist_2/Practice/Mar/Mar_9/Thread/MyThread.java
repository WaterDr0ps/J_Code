package nuist_2.Practice.Mar.Mar_9.Thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=30;i++){
            System.out.println(getName()+":"+i);

        }
    }
}
