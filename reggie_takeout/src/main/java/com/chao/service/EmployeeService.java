package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */

@Transactional(rollbackFor = Exception.class)
public interface EmployeeService extends IService<Employee> {
}
