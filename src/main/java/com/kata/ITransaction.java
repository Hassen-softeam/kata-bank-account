package com.kata;

import com.kata.exception.AccountTransactionException;
import com.kata.models.Account;
import com.kata.models.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public interface ITransaction {
    void makeTransaction(BigDecimal amount, Account account) throws AccountTransactionException;
    static Transaction createBasicTransaction(){
        Transaction transaction = new Transaction();
        transaction.setDateTransaction(new Date());
        return transaction;
    }
}
