package nuist_2.Practice.Mar.Mar_16.UDP;

import java.io.IOException;
import java.net.*;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        byte[] bys="hello,is a message".getBytes();
        DatagramPacket dp=new DatagramPacket(bys,bys.length, InetAddress.getByName("10.33.4.127"),10000);

        ds.send(dp);
        ds.close();
    }
}
