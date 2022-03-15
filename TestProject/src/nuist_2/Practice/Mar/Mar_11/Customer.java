package nuist_2.Practice.Mar.Mar_11;

public class Customer implements Runnable{
    private Box b;

    public Customer(Box b){
        this.b=b;
    }

    @Override
    public void run() {
        while(true){
            b.get() ;
        }
    }
}
