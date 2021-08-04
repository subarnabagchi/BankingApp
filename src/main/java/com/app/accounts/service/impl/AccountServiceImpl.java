package com.app.accounts.service.impl;

import com.app.accounts.model.Account;
import com.app.accounts.model.AcctTransaction;
import com.app.accounts.repo.AccountRepo;
import com.app.accounts.repo.TransactionRepo;
import com.app.accounts.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Override
    @Cacheable(value="accounts")
    public List<Account> viewAccounts(String customerId, String pageNo, String pageSize)
            throws Exception {
        logger.info("Page No: "+pageNo+", Page Size: "+pageSize);
        Pageable pageable = PageRequest.of(Integer.parseInt(pageNo),
                Integer.parseInt(pageSize));
        logger.info("Getting accounts for Customer Id: "+customerId);
        return accountRepo.findByCustomerId(customerId, pageable);
    }

    @Override
    @Cacheable(value="transactions")
    public List<AcctTransaction> viewTransactions(String acctNum, String pageNo, String pageSize)
            throws Exception {
        logger.info("Page No: "+pageNo+", Page Size: "+pageSize);
        Pageable page = PageRequest.of(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        logger.info("Getting transactions for account number: "+ acctNum);
        return transactionRepo.findByAccountNumber(acctNum, page);
    }

}
