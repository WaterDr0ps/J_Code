package Test.mapper;

import Test.pojo.Brand;

import java.util.List;

/**
 * @author Administrator
 */
public interface BrandMapper {

    List<Brand> selectAll();

    void addBrand(Brand brand);

    Brand selectById(int id);

    void updateBrand(Brand brand);

    void deleteById(int id);
}
