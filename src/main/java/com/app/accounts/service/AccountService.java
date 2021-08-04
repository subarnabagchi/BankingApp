package com.app.accounts.service;

import com.app.accounts.model.Account;
import com.app.accounts.model.AcctTransaction;

import java.util.List;


public interface AccountService {

    List<AcctTransaction> viewTransactions(String acctNum, String pageNo, String pageSize)
            throws Exception;

    List<Account> viewAccounts(String customerId, String pageNo, String pageSize) throws Exception;
}
