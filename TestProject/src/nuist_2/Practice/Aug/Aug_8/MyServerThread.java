package nuist_2.Practice.Aug.Aug_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 */
public class MyServerThread implements Runnable {
    private Socket socket;
    public MyServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String s;
            while((s=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"："+s);
            }
        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
        }
    }
}
