package Sep9_22;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Administrator
 */
@WebServlet(urlPatterns = "/req922")
public class ServletDemoRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<String, String[]> map = req.getParameterMap();
//        for(String key:map.keySet()){
//            System.out.print(key+":");
//            String[] values=map.get(key);
//            for (String value : values) {
//                System.out.println(value);
//            }
//        }

        /*
            post解决中文乱码:req.setCharacterEncoding("UTF-8")
         */
//        req.setCharacterEncoding("UTF-8");
//        String username = req.getParameter("username");
//        System.out.println(username);

        /*
            get/post通用解决中文乱码:new String(username.getBytes("ISO-8859-1"),"UTF-8")
         */
//        String username = req.getParameter("username");
//        System.out.println(username);
//        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//        System.out.println(username);

        /*
            请求转发
         */
        System.out.println("req922");
        req.setAttribute("msg","hello");
        req.getRequestDispatcher("/req922_2").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
