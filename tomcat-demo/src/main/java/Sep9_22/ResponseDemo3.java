package Sep9_22;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\1.jpg");

        ServletOutputStream os = response.getOutputStream();

        /*byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }*/

        //使用IOUtils工具类
        IOUtils.copy(fis,os);

        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
