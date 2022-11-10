package com.chao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.UserDao;
import com.chao.entity.User;
import com.chao.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
