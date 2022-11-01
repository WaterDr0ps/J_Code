package Test.web;

import Test.Service.BrandService;
import Test.mapper.BrandMapper;
import Test.pojo.Brand;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService service=new BrandService();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = service.selectAll();

        //将数据转换为json数据  序列化
        String s = JSON.toJSONString(brands);

        //响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //通过reader读数据
        BufferedReader br = request.getReader();
        String s = br.readLine();

        //json转对象
        Brand brand = JSON.parseObject(s, Brand.class);

        service.add(brand);

        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //通过reader读数据
        BufferedReader br = request.getReader();
        String s = br.readLine();

        //json转数组
        int[] ids = JSON.parseObject(s, int[].class);

        service.deleteByIds(ids);

        response.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //通过reader读数据
        BufferedReader br = request.getReader();
        String s = br.readLine();

        //json转id
        int id = JSON.parseObject(s, int.class);

        service.deleteById(id);

        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //通过reader读数据
        BufferedReader br = request.getReader();
        String s = br.readLine();

        //json转对象
        Brand brand = JSON.parseObject(s, Brand.class);

        int count = service.update(brand);

        response.getWriter().write(""+count);
    }

    public void selectCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        BufferedReader br = request.getReader();
        String s = br.readLine();

        Brand brand = JSON.parseObject(s, Brand.class);

        List<Brand> brands = service.selectCondition(brand);

        String s1 = JSON.toJSONString(brands);

        //响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s1);
    }
}
