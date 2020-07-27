package com.kata;

import com.kata.exception.AccountTransactionException;
import com.kata.models.Account;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountOperationTest {
    private AccountOperation accountOperation;

    @Test
    public void deposit_maney(){
        Account account = new Account();
        accountOperation = new AccountOperation(account);
        accountOperation.makeDeposit(BigDecimal.valueOf(100));
        assertEquals(account.getBalance(), BigDecimal.valueOf(100));
    }

    @Test()
    public void withdrawal_maney() throws AccountTransactionException {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(300));
        accountOperation = new AccountOperation(account);
        accountOperation.makeWithdrawal(BigDecimal.valueOf(100));
        assertEquals(account.getBalance(), BigDecimal.valueOf(200));
    }

    @Test(expected = AccountTransactionException.class)
    public void withdraw_money_more_than_balance_should_not_pass() throws AccountTransactionException{
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(200));
        accountOperation = new AccountOperation(account);
        accountOperation.makeWithdrawal(BigDecimal.valueOf(300));
    }
}
