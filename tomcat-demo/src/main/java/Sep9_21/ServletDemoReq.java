package Sep9_21;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet(urlPatterns = "/req921")
public class ServletDemoReq extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //获取虚拟路径(项目访问路径,动态)
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取URL
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        //获取URI
        String uri = req.getRequestURI();
        System.out.println(uri);
        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据请求头名称,获取值
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }
}
