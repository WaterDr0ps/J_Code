package nuist_2.Practice.May.May_9;

import java.util.concurrent.Callable;

/**
 * @author Eliot
 */
public class MyCallable implements Callable<String> {
    private int number;

    public MyCallable() {
    }

    public MyCallable(int number) {
        this.number = number;
    }

    @Override
    public String call() throws Exception {
        int sum=0;
        for (int i = 0; i <number; i++) {
            sum+=i;
        }
        return Thread.currentThread().getName()+"___________1-"+number+"的和是："+sum;
    }
}
