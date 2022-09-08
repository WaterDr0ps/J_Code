package nuist_2.Practice.Aug.Aug_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class Server {

    private static ExecutorService pools=new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        System.out.println("=====服务端启动=====");
        try {
            ServerSocket serverSocket=new ServerSocket(100);
            while(true){
                Socket socket=serverSocket.accept();
                pools.execute(new MyServerThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
