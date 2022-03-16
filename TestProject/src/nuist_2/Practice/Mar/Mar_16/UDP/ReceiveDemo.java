package nuist_2.Practice.Mar.Mar_16.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(10000);

        byte[] bys=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bys,bys.length);

        ds.receive(dp);
        byte[] data=dp.getData();
        System.out.println("接收的数据是："+new String(data,0,dp.getLength()));
    }
}
