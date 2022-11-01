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
    private SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll(){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand){
        SqlSession sqlSession= factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteByIds(int[] ids){
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(int id){
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public int update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }

    public List<Brand> selectCondition(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        String brandName=brand.getBrandName();
        if(brandName!=null && brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName=brand.getCompanyName();
        if(companyName!=null && companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }

        List<Brand> brands = mapper.selectCondition(brand);
        sqlSession.close();
        return brands;
    }
}
