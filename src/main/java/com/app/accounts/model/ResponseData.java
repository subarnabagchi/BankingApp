package com.app.accounts.model;

import java.io.Serializable;
import java.util.List;

public class ResponseData implements Serializable {

    private List<Account> accounts;

    private List<AcctTransaction> transactions;

    private String error;

    public ResponseData() {
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setTransactions(List<AcctTransaction> transactions) {
        this.transactions = transactions;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<AcctTransaction> getTransactions() {
        return transactions;
    }

    public String getError() {
        return error;
    }
}
