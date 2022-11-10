package com.chao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.dao.AddressBookDao;
import com.chao.entity.AddressBook;
import com.chao.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookDao, AddressBook> implements AddressBookService {
}
