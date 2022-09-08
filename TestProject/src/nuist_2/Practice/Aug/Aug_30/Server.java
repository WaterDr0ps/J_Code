package nuist_2.Practice.Aug.Aug_30;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class Server {

    private static ExecutorService pools=new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static List<Socket> allOnlineThread=new ArrayList<>();

    public static void main(String[] args) {
        try {
            System.out.println("============客户端启动============");
            ServerSocket serverSocket = new ServerSocket(100);
            while (true) {
                Socket socket =serverSocket.accept();
                pools.execute(new MyServerThread(socket));
                allOnlineThread.add(socket);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
