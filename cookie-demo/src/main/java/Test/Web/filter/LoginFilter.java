package Test.Web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest) request;

        String[] urls={"/index.jsp","/register.jsp","/checkCodeServlet","/registerServlet","/loginServlet"};
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if(url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            chain.doFilter(request, response);
        }else {
            req.setAttribute("msg_err_filter", "用户未登陆");
            req.getRequestDispatcher("/index.jsp").forward(req,response);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
