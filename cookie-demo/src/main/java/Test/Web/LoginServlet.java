package Test.Web;

import Test.Service.UserService;
import Test.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = service.select(username, password);
        if(user!=null){
            if("1".equals(remember)){
                Cookie c_username=new Cookie("username",username);
                Cookie c_password=new Cookie("password",password);

                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        }else {
            request.setAttribute("msg_err_user", "账号或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
