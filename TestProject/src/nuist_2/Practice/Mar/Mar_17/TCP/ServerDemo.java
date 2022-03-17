package nuist_2.Practice.Mar.Mar_17.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10001);
        Socket s = ss.accept();
        InputStream is=s.getInputStream();
        byte[] bys=new byte[1024];
        System.out.println("数据是："+new String(bys,0,is.read(bys)));

    }
}
