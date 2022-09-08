package nuist_2.Practice.Aug.Aug_8;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Eliot
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("192.168.2.2",100);
            OutputStream os=socket.getOutputStream();
            PrintStream ps=new PrintStream(os);
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("请说：");
                String s=sc.nextLine();
                ps.println(s);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
