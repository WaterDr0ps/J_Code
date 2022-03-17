package nuist_2.Practice.Mar.Mar_17.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("10.33.4.195",10001);

        OutputStream os=s.getOutputStream();
        os.write("hello".getBytes());

        s.close();
    }
}
