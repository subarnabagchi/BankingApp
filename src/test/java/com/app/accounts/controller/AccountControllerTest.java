package com.app.accounts.controller;

import com.app.accounts.model.Account;
import com.app.accounts.model.AcctTransaction;
import com.app.accounts.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testViewAccounts() throws Exception {
        String uri = "/bank/viewAccounts";
        List<Account> accounts = new ArrayList<>();
        Account acct = new Account();
        acct.setAccountNumber("10101");
        acct.setCustomerId("test");
        accounts.add(acct);
        when(accountService.viewAccounts(anyString(),anyString(),anyString())).thenReturn(accounts);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("customerId","test")
                .param("pageNo","0")
                .param("pageSize","10")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("10101"));
    }

    @Test
    public void testViewAccountsReturnsEmptyList() throws Exception {
        String uri = "/bank/viewAccounts";
        when(accountService.viewAccounts(anyString(),anyString(),anyString())).thenReturn(new ArrayList<>());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("customerId","test")
                .param("pageNo","0")
                .param("pageSize","10")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("No data returned matching your criteria."));
    }

    @Test
    public void testViewAccountsThrowsException() throws Exception {
        String uri = "/bank/viewAccounts";
        when(accountService.viewAccounts(anyString(),anyString(),anyString())).thenThrow(new Exception("Error parsing data"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("customerId","test")
                .param("pageNo","abc")
                .param("pageSize","10")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("Error parsing data"));
    }

    @Test
    public void testViewTransactionsReturningEmptyList() throws Exception {
        String uri = "/bank/viewTransactions";
        when(accountService.viewTransactions(anyString(),anyString(),anyString())).thenReturn(new ArrayList<>());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("accountNumber","999999")
                .param("pageNo","0")
                .param("pageSize","10")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("No data returned matching your criteria."));

    }

    @Test
    public void testViewTransactions() throws Exception {
        String uri = "/bank/viewTransactions";
        List<AcctTransaction> trans = new ArrayList<>();
        AcctTransaction tran = new AcctTransaction();
        tran.setAccountNumber("999999");
        tran.setAmount("1000.00");
        trans.add(tran);
        when(accountService.viewTransactions(anyString(),anyString(),anyString())).thenReturn(trans);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("accountNumber","999999")
                .param("pageNo","0")
                .param("pageSize","10")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("1000.00"));
    }

    @Test
    public void testViewTransactionsThrowsException() throws Exception {
        String uri = "/bank/viewTransactions";
        when(accountService.viewTransactions(anyString(),anyString(),anyString())).thenThrow(new Exception("Some exception"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("accountNumber","999999")
                .param("pageNo","0")
                .param("pageSize","10")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("Some exception"));
    }


}
