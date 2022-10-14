package Test.Service;

import Test.Utils.SqlSessionFactoryUtils;
import Test.mapper.BrandMapper;
import Test.pojo.Brand;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Administrator
 */
public class BrandService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> brandSelectAll(){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void brandAdd(Brand brand){
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public Brand selectById(int id){
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void updateBrand(Brand brand){
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.updateBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(int id){
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
