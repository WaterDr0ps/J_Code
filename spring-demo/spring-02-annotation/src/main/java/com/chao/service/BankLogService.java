package com.chao.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eliot
 */
public interface BankLogService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void recordLog(String fromName,String toName,int money);
}
