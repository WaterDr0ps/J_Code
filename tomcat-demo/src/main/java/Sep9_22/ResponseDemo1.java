package Sep9_22;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");

        //获取动态虚拟目录
        String contextPath = request.getContextPath();
        /*
            重定向 源码是
            response.setStatus(302);
            response.setHeader("Location","/tomcat-demo/resp2");
         */
        //response.sendRedirect("/tomcat-demo/resp2");
        response.sendRedirect(contextPath+"/resp2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
