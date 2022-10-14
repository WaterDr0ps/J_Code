package Test.Web;

import Test.Service.BrandService;
import Test.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private BrandService service=new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        int ordered = Integer.parseInt(request.getParameter("ordered"));
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));
        Brand brand = new Brand(brandName, companyName, ordered, description, status);
        service.brandAdd(brand);
        //请求转发,虽然转了,但还是原来url
        //request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        //重定向,跳转url
        response.sendRedirect("/brand-demo/selectAllServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
