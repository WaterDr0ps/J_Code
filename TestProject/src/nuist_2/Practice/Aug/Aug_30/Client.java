package nuist_2.Practice.Aug.Aug_30;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("10.33.4.132",100);

            new Thread(new ClientReaderThread(socket)).start();

            OutputStream os=socket.getOutputStream();
            PrintStream ps=new PrintStream(os);
            Scanner sc=new Scanner(System.in);
            while (true){
                //System.out.print("请说：");
                String s = sc.nextLine();
                ps.println(s);
                ps.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ClientReaderThread implements Runnable{
    private Socket socket;

    public ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+":"+s);
            }
        } catch (IOException e) {
            System.out.println("被服务端踢出");
            Server.allOnlineThread.remove(socket);
        }
    }


}
