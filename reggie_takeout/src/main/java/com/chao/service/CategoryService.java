package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.entity.Category;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */

@Transactional(rollbackFor = Exception.class)
public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
