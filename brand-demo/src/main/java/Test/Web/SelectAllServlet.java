package Test.Web;

import Test.Service.BrandService;
import Test.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    protected static BrandService service=new BrandService();

    public static  List<Brand> brands;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<Brand> brands = service.brandSelectAll();
        brands = service.brandSelectAll();

        request.setAttribute("brands",brands);

        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
