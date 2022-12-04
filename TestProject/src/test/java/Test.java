import javax.swing.text.DefaultFormatterFactory;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eliot
 */
public class Test {
    public void test(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5
        ,5, TimeUnit.MINUTES,new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        AtomicInteger i = new AtomicInteger(1);
    }
}
