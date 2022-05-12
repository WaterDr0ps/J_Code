package nuist_2.Practice.May.May_11;

public class MyVolatile extends Thread{
    public static  boolean flag = false;

    @Override
    public void run() {
        while(!flag){} ;
    }

}
