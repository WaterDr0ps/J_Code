package nuist_2.Practice.Sep.Sep_5;

//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Administrator
 */
public class MysqlTest {
    public static void main(String[] args) throws Exception {
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false","root","123456");
//        Statement stat=conn.createStatement();
//
//        String sql="select * from stu";
//        ResultSet rs = stat.executeQuery(sql);
//
//        while(rs.next()){
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            String sex = rs.getString("sex");
//            System.out.println(id+" "+name+" "+sex);
//        }

//        Connection conn=DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false", "root","123456");
//        Statement stat=conn.createStatement();
//
//        String sql="select * from tb_user_desc";
//        ResultSet rs=stat.executeQuery(sql);
//
//        List<Account> list=new ArrayList<>();
//        while(rs.next()){
//            list.add(new Account(rs.getInt("id"),rs.getString("city"),
//                    rs.getString("edu"),rs.getInt("income")));
//        }
//
//        for (Account account : list) {
//            System.out.println(account);
//        }

//        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false&&useServerPrepStmt=true","root","123456");
//
//        String sql="select * from users where username=? and password=?";
//        String name="root";
//        String code="1213";
//
//        PreparedStatement stat=conn.prepareStatement(sql);
//        stat.setString(1,name);
//        stat.setString(2,code);
//        ResultSet rs = stat.executeQuery();
//
//        if(rs.next()){
//            System.out.println("成功");
//        }else {
//            System.out.println("失败");
//        }
//
//        rs.close();
//        stat.close();
//        conn.close();

        //druid 德鲁伊
//        Properties prop=new Properties();
//        prop.load(new FileInputStream("C:\\Users\\Administrator\\Documents\\GitHub\\J_Code\\TestProject\\src\\druid.properties"));
//
//        DataSource ds=DruidDataSourceFactory.createDataSource(prop);
//        Connection c = ds.getConnection();
//        System.out.println(c);



//        Connection conn= DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false&&useServerPropStmts=true","root","123456");
//        String sql="select * from tb_brand";
//        PreparedStatement stmt=conn.prepareStatement(sql);
//        ResultSet rs = stmt.executeQuery();
//        List<Brand> list=new ArrayList<>();
//        while(rs.next()){
//            list.add(new Brand(rs.getInt(1),rs.getString(2),rs.getString(3)
//                    ,rs.getInt(4),rs.getString(5),rs.getInt(6)));
//        }
//        for (Brand brand : list) {
//            System.out.println(brand);
//        }


        /**
         * Druid 查询所有
         */
//        Properties prop=new Properties();
//        prop.load(new FileInputStream("TestProject\\src\\druid.properties"));
//        DataSource ds=DruidDataSourceFactory.createDataSource( prop);
//        Connection conn = ds.getConnection();
//        String sql="select * from tb_brand";
//        PreparedStatement stmt=conn.prepareStatement(sql);
//        ResultSet rs=stmt.executeQuery();
//        List<Brand> list=new ArrayList<>();
//        while(rs.next()){
//            list.add(new Brand(rs.getInt(1),rs.getString(2),rs.getString(3)
//                    ,rs.getInt(4),rs.getString(5),rs.getInt(6)));
//        }
//        for (Brand brand : list) {
//            System.out.println(brand);
//        }




    }
//    @Test
//    public  void insertData () throws Exception{
//        Properties prop=new Properties();
//        prop.load(new FileInputStream("TestProject\\src\\druid.properties"));
//        DataSource ds=DruidDataSourceFactory.createDataSource(prop);
//        Connection conn = ds.getConnection();
//        String sql="insert into tb_brand (brand_name,company_name,ordered,description,status) values (?,?,?,?,?)";
//        PreparedStatement stmt=conn.prepareStatement(sql);
//        stmt.setString(1,"苹果");
//        stmt.setString(2,"苹果科技有限公司");
//        stmt.setInt(3,30);
//        stmt.setString(4,"苹果666");
//        stmt.setInt(5,1);
//        int count=stmt.executeUpdate();
//        System.out.println(count>0);
//    }
}











