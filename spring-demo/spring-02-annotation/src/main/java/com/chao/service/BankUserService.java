package com.chao.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */
public interface BankUserService {

    void saveMoney(String name,int money);

    void takeMoney(String name,int money);

    @Transactional
    void transfer(String fromName,String toName,int money);

}
