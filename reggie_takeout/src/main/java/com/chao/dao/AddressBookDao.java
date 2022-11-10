package com.chao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chao.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eliot
 */
@Mapper
public interface AddressBookDao extends BaseMapper<AddressBook> {
}
