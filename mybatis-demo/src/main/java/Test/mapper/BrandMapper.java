package Test.mapper;

import Test.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface BrandMapper {
    /**
     * 查询所有信息
     *
     * @return 多个对象用List接收
     */
    List<Brand> selectAll();

    /**
     * 通过ID查询信息
     *
     * @param id id
     * @return 返回Brand对象
     */
    Brand selectById(int id);

    /*    *//**
     * 条件查询(静态)
     * @param status 占位符,对应status
     * @param companyName 占位符,对应company_name
     * @param brandName 占位符,对应brand_name
     * @return
     *//*
    List<Brand> selectAllByCondition(@Param("status") int status,
                                     @Param("companyName") String companyName,
                                     @Param("brandName") String brandName);*/

    /**
     * 多条件动态查询
     *
     * @param map map集合存储
     * @return 1
     */
    List<Brand> selectAllByCondition(Map map);


    /**
     * 单条件动态查询
     *
     * @param brand
     * @return 1
     */
    List<Brand> selectAllByConditionSingle(Brand brand);

    /**
     * 新增数据
     *
     * @param brand
     */
    void addRecord(Brand brand);

    /**
     * 更新数据
     *
     * @param brand
     */
    void updateById(Brand brand);

    /**
     * 动态更新
     *
     * @param brand
     */
    void updateDynamic(Brand brand);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);


}
