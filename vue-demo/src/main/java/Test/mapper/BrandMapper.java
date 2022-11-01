package Test.mapper;

import Test.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface BrandMapper {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

    void deleteById(int id);

    int update(Brand brand);

    List<Brand> selectCondition(@Param("brand") Brand brand);
}
