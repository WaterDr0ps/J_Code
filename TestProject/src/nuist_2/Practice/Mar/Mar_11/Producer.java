package nuist_2.Practice.Mar.Mar_11;

public class Producer implements Runnable{
    private Box b;
    public Producer(Box b){
        this.b=b;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            b.put(i);
        }
    }
}
