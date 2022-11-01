package com.chao.service.impl;

import com.chao.dao.BankLogDao;
import com.chao.service.BankLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eliot
 */
@Service
public class BankLogServiceImpl implements BankLogService {
    @Autowired
    private BankLogDao bankLogDao;

    @Override
    public void recordLog(String fromName,String toName,int money) {
        bankLogDao.recordLog(fromName+"向"+toName+"转账了"+money);
    }
}
