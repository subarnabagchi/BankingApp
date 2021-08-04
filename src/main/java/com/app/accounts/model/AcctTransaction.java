package com.app.accounts.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class AcctTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    long id;

    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "amount")
    String amount;

    @Column(name = "debit_credit")
    String debitOrCredit;

    @Column(name = "currency")
    String currency;

    @Column(name = "message")
    String message;

    @Column(name = "value_date")
    Date valueDate;

    public AcctTransaction() {
    }

    public AcctTransaction(long id, String accountNumber, String amount, String debitOrCredit,
                           String currency, String message, Date valueDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.debitOrCredit = debitOrCredit;
        this.currency = currency;
        this.message = message;
        this.valueDate = valueDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMessage() {
        return message;
    }

    public Date getValueDate() {
        return valueDate;
    }
}
