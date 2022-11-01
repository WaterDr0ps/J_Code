package com.chao.service.impl;

import com.chao.dao.BankLogDao;
import com.chao.dao.BankUserDao;
import com.chao.service.BankLogService;
import com.chao.service.BankUserService;
import com.chao.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */
@Service
public class BankUserServiceImpl implements BankUserService {
    @Autowired
    private BankUserDao bankUserDao;

    @Autowired
    private BankLogService bankLogService;

    @Override
    public void saveMoney(String name,int money) {
        bankUserDao.saveMoney(name,money);
    }

    @Override
    public void takeMoney(String name,int money) {
        bankUserDao.takeMoney(name,money);
    }

    @Override
    public void transfer(String fromName, String toName, int money) {
        try {
            takeMoney(fromName,money);
            saveMoney(toName,money);
        } finally {
            bankLogService.recordLog(fromName, toName, money);
        }
    }

}
