package Test.Web;

import Test.Service.BrandService;
import Test.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/servletByIdServlet")
public class ServletByIdServlet extends HttpServlet {

    private BrandService service=new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Brand brand = service.selectById(Integer.parseInt(id));

        request.setAttribute("brand",brand);
        //response.sendRedirect("/brand-demo/updateServlet");
        request.getRequestDispatcher("/updateBrand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
