package com.app.accounts.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "account_name")
    String accountName;

    @Column(name = "cust_id")
    String customerId;

    @Column(name = "type")
    String type;

    @Column(name = "balance_date")
    Date balanceDate;

    @Column(name = "currency")
    String currency;

    @Column(name = "balance")
    Double balance;

    @OneToMany(targetEntity = AcctTransaction.class)
    List<AcctTransaction> transactions;

    public void setId(long id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<AcctTransaction> transactions) {
        this.transactions = transactions;
    }

    public List<AcctTransaction> getTransactions() {
        if(transactions == null){
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getBalance() {
        return balance;
    }

    public Account(long id, String accountNumber, String accountName, String customerId,
                   String type, Date balanceDate, String currency, Double balance,
                   List<AcctTransaction> transactions) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.customerId = customerId;
        this.type = type;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Account() {
    }
}
