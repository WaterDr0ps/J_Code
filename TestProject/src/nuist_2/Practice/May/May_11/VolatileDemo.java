package nuist_2.Practice.May.May_11;

public class VolatileDemo {
    public static void main(String[] args) throws Exception {
        new MyVolatile().start();
        Thread.sleep(2000);
        MyVolatile.flag=true;
    }
}
