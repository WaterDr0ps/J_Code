package Test.Web;

import Test.Utils.CheckCodeUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author Administrator
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckCodeUtils checkCode=new CheckCodeUtils(140,50);
        ServletOutputStream os = response.getOutputStream();
        checkCode.write(os);
        String code = checkCode.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("code",code);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
