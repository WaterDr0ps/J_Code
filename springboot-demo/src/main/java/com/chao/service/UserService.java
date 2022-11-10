package com.chao.service;

import com.chao.pojo.PageBean;
import com.chao.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Eliot
 */
public interface UserService {
    /**
     * 查询所有
     * @return
     */
    @Transactional
    List<User> selectAll();

    /**
     * 新增记录
     * @param user
     * @return
     */
    @Transactional
    boolean add(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Transactional
    boolean deleteById(int id);

    /**
     * 更新记录
     * @param user
     * @return
     */
    @Transactional
    boolean update(User user);

    @Transactional
    PageBean<User> selectByPage(int currentPage,int pageSize);
}
