package TestProject.src.nuist_2.Practice.Aug.Aug_30;



import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Administrator
 */
public class UserServiceTest {
    @Test
    public void sendMsgToAll() throws IOException {
        Socket socket=new Socket("10.33.4.132",100);
        nuist_2.Practice.Aug.Aug_30.MyServerThread myServerThread=new nuist_2.Practice.Aug.Aug_30.MyServerThread(socket);
        myServerThread.sendMsgToAll("123");
    }

}
