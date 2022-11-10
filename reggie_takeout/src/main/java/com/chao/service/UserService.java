package com.chao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chao.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */
@Transactional(rollbackFor = Exception.class)
public interface UserService extends IService<User> {
}
