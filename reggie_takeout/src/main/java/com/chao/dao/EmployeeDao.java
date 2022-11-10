package com.chao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chao.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eliot
 */

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
}
