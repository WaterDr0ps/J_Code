package com.chao.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author Eliot
 */
@Repository
public interface BankLogDao {

    @Insert("insert into bank_log(info,createDate) values (#{info},now())")
    void recordLog(String info);
}
