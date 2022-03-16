package nuist_2.Practice.Mar.Mar_16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class text {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress net=InetAddress.getByName("10.33.4.127");
        String hostName = net.getHostName();
        String hostAddress = net.getHostAddress();
        System.out.println(hostName);
        System.out.println(hostAddress);
    }
}
