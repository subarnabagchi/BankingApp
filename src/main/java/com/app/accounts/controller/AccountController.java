package com.app.accounts.controller;

import com.app.accounts.exception.AccountException;
import com.app.accounts.model.Account;
import com.app.accounts.model.ResponseData;
import com.app.accounts.model.AcctTransaction;
import com.app.accounts.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/bank")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @GetMapping("/viewAccounts")
    public ResponseData viewAccounts(@RequestParam(required = true) String customerId,
                                     @RequestParam(required = false, defaultValue = "0") String pageNo,
                                     @RequestParam(required = false, defaultValue = "10") String pageSize) {
        logger.info("In viewAccounts ....");
        ResponseData responseData = new ResponseData();
        try {
            List<Account> accounts = accountService.viewAccounts(customerId, pageNo, pageSize);
            if (accounts.isEmpty()) {
                logger.info("No Data found in viewAccounts ....");
                responseData.setError("No data returned matching your criteria.");
            } else {
                responseData.setAccounts(accounts);
            }
        } catch(Exception e) {
            logger.error("Error in viewAccounts .... " + e.getMessage());
            //TODO - Exception table to be created into DB and detailed stack trace needs to be saved
            AccountException exception = new AccountException(e.getCause());
            responseData.setError(e.getMessage());
        }
        logger.info("Returning from viewAccounts ....");
        return responseData;
    }

    @GetMapping("/viewTransactions")
    public ResponseData viewTransactions(@RequestParam("accountNumber") String acctNum,
                                         @RequestParam(defaultValue = "0", name = "pageNo") String pageNo,
                                         @RequestParam(defaultValue = "10", name = "pageSize") String pageSize) {
        logger.info("In viewTransactions ....");
        ResponseData responseData = new ResponseData();
        try {
            List<AcctTransaction> trans = accountService.viewTransactions(acctNum, pageNo, pageSize);
            if (trans.isEmpty()) {
                logger.info("No Data found in viewTransactions ....");
                responseData.setError("No data returned matching your criteria.");
            } else {
                responseData.setTransactions(trans);
            }
        } catch(Exception e) {
            logger.error("Error in viewTransactions .... " + e.getMessage());
            //TODO - Exception table to be created into DB and detailed stack trace needs to be saved
            AccountException exception = new AccountException(e.getCause());
            responseData.setError(e.getMessage());
        }
        logger.info("Returning from viewTransactions ....");
        return responseData;
    }
}
