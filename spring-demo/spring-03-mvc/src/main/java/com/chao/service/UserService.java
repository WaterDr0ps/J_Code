package com.chao.service;

import com.chao.pojo.User;

import java.util.List;

/**
 * @author Eliot
 */
public interface UserService {
    List<User> selectAll();

    void add(User user);

    void deleteById(int id);

    void update(User user);
}
