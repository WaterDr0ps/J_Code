package nuist_2.Practice.Mar.Mar_16.UDPtext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine())!=null){
            if(!line.equals("886")){
                byte[] bys=line.getBytes();
                DatagramPacket dp=new DatagramPacket(bys,bys.length, InetAddress.getByName("10.33.4.195"),10000);
                ds.send(dp);
            }else{
                break;
            }
        }
        ds.close();
    }
}
