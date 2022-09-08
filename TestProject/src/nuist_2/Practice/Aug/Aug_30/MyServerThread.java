package nuist_2.Practice.Aug.Aug_30;

import java.io.*;
import java.net.Socket;

/**
 * @author Administrator
 */
public class MyServerThread implements Runnable{
    public Socket socket;

    public MyServerThread(Socket socket) {
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
                sendMsgToAll(s);
            }
        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
        }
    }
    public void sendMsgToAll(String s) {
        try {
            for (Socket socket1 : Server.allOnlineThread) {
                if (socket1!=socket) {
                    OutputStream os=socket1.getOutputStream();
                    PrintStream ps=new PrintStream(os);
                    ps.println(s);
                    ps.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
