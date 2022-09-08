package nuist_2.Practice.Sep.Sep_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Administrator
 */
public class MysqlTest {
    public static void main(String[] args) throws Exception {
        //驱动加载到内存,可以省略
        Class.forName("com.mysql.jdbc.Driver");

        //建立连接对象,localhost:3306可以省略
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1?useSSL=false", "root", "123456");
        Statement stat = conn.createStatement();

        try {
            //开始事务 Connection接口
            conn.setAutoCommit(false);

            String sql="update stu set math=math+5 where id=1";
            int count = stat.executeUpdate(sql);
            System.out.println(count);

            String sql2="update stu set math=math+5 where id=1";
            int count2=stat.executeUpdate(sql2);
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        }



        stat.close();
        conn.close();
    }
}
