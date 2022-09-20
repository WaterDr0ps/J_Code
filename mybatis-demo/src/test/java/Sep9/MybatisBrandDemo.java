package Sep9;

import Test.mapper.BrandMapper;
import Test.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisBrandDemo {
    public static void main(String[] args)  {

    }

    @Test
    public void testSelectAll() throws IOException{
        //加载mybatis核心配置文件,获取SqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行SQL
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行SQL
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException{
        int id=2;
        //加载mybatis核心配置文件,获取SqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行SQL
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //执行SQL
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
    }

    @Test
    public void testSelectByCondition() throws IOException{
        int status=1;
        String companyName="华为";
        String brandName="华为";
        Map map=new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //加载mybatis核心配置文件,获取SqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //执行sql
        List<Brand> brands = mapper.selectAllByCondition(map);
        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException{
        //构建Brand对象
        Brand brand=new Brand();
        brand.setCompanyName("华为");
        //加载mybatis核心配置文件,获取SqlSessionFactory对象
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //获取Mapper接口代理对象(BrandMapper)
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //执行sql
        List<Brand> brands = mapper.selectAllByConditionSingle(brand);
        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void testAddRecord() throws IOException{
        Brand brand=new Brand("苹果","苹果科技有限公司",
                50, "苹果666",1);
        //加载mybatis核心配置文件,获取SqlSessionFactory对象
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取Mapper代理接口对象(BrandMapper)
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //执行sql
        try {
            mapper.addRecord(brand);
            System.out.println(brand.getId());
            //Setting autocommit to false  事务默认不自动提交
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateRecord() throws IOException{
        Brand brand=new Brand(6,"s苹果b","s苹果科技有限公司b",
                60, "苹果776",1);
        //加载mybatis核心配置文件,获取SqlSessionFactory对象
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取Mapper代理接口对象(BrandMapper)
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //执行sql
        try {
            mapper.updateById(brand);
            //Setting autocommit to false  事务默认不自动提交
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateDynamic() throws IOException{
        Brand brand=new Brand();
        brand.setCompanyName("xbpg");
        brand.setId(6);
        //加载mybatis核心配置文件,获取SqlSessionFactory对象
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql
        //openSession参数true是自动开启提交事务
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        //获取Mapper代理接口对象(BrandMapper)
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //执行sql
        try {
            mapper.updateDynamic(brand);
            //Setting autocommit to false  事务默认不自动提交
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            //错误回滚事务
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteSingle() throws IOException{
        //加载mybatis核心配置文件,获取SqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql,设置自动提交事务
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        //获取Mapper接口代理对象(BrandMapper)
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //执行sql
        int count = mapper.deleteById(4);
        System.out.println(count);
    }

    @Test
    public void testDeleteIds() throws IOException{
        int[] ids={5,6};
        //加载mybatis核心配置文件,获取SqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream is=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象,用于执行sql,设置自动提交事务
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        //获取Mapper接口代理对象(BrandMapper)
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //执行sql
        mapper.deleteByIds(ids);
    }





}












