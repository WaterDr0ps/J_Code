package nuist_2.Practice.Mar.Mar_9.SellTicket;

public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket st=new SellTicket();

        Thread t1=new Thread(st,"1窗口");
        Thread t2=new Thread(st,"2窗口");
        Thread t3=new Thread(st,"3窗口");

        t1.start();
        t2.start();
        t3.start();


    }
}
