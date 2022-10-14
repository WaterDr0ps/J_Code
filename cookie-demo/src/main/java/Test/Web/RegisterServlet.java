package Test.Web;

import Test.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");

        if(!code.equalsIgnoreCase(checkCode)) {
            request.setAttribute("msg_err_verify", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if(service.selectByUsername(username)!=null){
            request.setAttribute("msg_err_user","账户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else{
            service.add(username,password);
            response.sendRedirect("/cookie-demo/index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
