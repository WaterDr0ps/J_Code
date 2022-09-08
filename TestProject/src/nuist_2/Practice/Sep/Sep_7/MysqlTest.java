package nuist_2.Practice.Sep.Sep_7;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author Administrator
 */
public class MysqlTest {
    public static void main(String[] args) {

    }
    @Test
    public void testUpdate() throws Exception{
        Properties prop=new Properties();
        prop.load(new FileInputStream("TestProject\\src\\druid.properties"));
        DataSource ds= DruidDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        String sql="update tb_brand set description=? where id=3";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setString(1,"小米666");
        int count = stmt.executeUpdate();
        System.out.println(count>0);
    }
    @Test
    public void testDelete() throws Exception{
        Properties prop=new Properties();
        prop.load(new FileInputStream("TestProject\\src\\druid.properties"));
        DataSource ds=DruidDataSourceFactory.createDataSource(prop);
        Connection conn=ds.getConnection();
        String sql="delete from tb_brand where id=4";
        PreparedStatement stmt=conn.prepareStatement(sql);
        //stmt.setInt(1,4);
        int count = stmt.executeUpdate();
        System.out.println(count>0);
    }
}
