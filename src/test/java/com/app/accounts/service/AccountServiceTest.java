package com.app.accounts.service;

import com.app.accounts.model.Account;
import com.app.accounts.model.AcctTransaction;
import com.app.accounts.repo.AccountRepo;
import com.app.accounts.repo.TransactionRepo;
import com.app.accounts.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Autowired
    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    AccountRepo accountRepo;

    @Mock
    TransactionRepo transactionRepo;

    @Test
    public void testViewAccounts() throws Exception {
        List<Account> accounts = new ArrayList<>();
        Account acct = new Account();
        acct.setAccountNumber("10101");
        acct.setCustomerId("test");
        accounts.add(acct);

        when(accountRepo.findByCustomerId(anyString(), any())).thenReturn(accounts);
        List<Account> result = accountService.viewAccounts("test", "0", "10");
        assertTrue(result.contains(acct));
    }

    @Test
    public void testViewAccountsThrowsException() throws Exception {
        try {
            when(accountRepo.findByCustomerId(anyString(), any())).thenThrow(new Exception("test error"));
            List<Account> result = accountService.viewAccounts("test7777", "0", "10");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("test error"));
        }
    }

    @Test
    public void testViewTransactions() throws Exception {
        List<AcctTransaction> trans = new ArrayList<>();
        AcctTransaction tran = new AcctTransaction();
        tran.setAccountNumber("10101");
        tran.setAmount("21312.90");
        trans.add(tran);

        when(transactionRepo.findByAccountNumber(anyString(), any())).thenReturn(trans);
        List<AcctTransaction> result = accountService.viewTransactions("10101", "0", "10");
        assertTrue(result.contains(tran));
    }

    @Test
    public void testViewTransactionsThrowsException() throws Exception {
        try {
            when(transactionRepo.findByAccountNumber(anyString(), any())).thenThrow(new Exception("test error"));
            List<AcctTransaction> result = accountService.viewTransactions("10101999", "0", "10");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("test error"));
        }

    }
}
