package com.kata;

import com.kata.exception.AccountTransactionException;
import com.kata.models.Account;

import java.math.BigDecimal;

public class AccountOperation {
    private Account account;
    public AccountOperation(Account account){
        this.account = account;
    }
    public void makeDeposit(BigDecimal amount){
        DepositTransaction transaction = new DepositTransaction();
        transaction.makeTransaction(amount, account);
    }

    public void makeWithdrawal(BigDecimal amount) throws AccountTransactionException {
        WithdrawalTransaction transaction = new WithdrawalTransaction();
        transaction.makeTransaction(amount, account);
    }
}
