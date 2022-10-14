package Test.mapper;

import Test.pojo.Brand;

import java.util.List;

/**
 * @author Administrator
 */
public interface BrandMapper {
    List<Brand> selectAll();

    void add(Brand brand);
}
