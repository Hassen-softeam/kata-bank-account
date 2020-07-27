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

    @Test
    public void check_operation_statistics() throws AccountTransactionException{
        Account account = new Account();
        accountOperation = new AccountOperation(account);
        accountOperation.makeDeposit(BigDecimal.valueOf(100));
        accountOperation.makeDeposit(BigDecimal.valueOf(150));
        accountOperation.makeWithdrawal(BigDecimal.valueOf(200));
        accountOperation.makeWithdrawal(BigDecimal.valueOf(50));
        accountOperation.makeDeposit(BigDecimal.valueOf(300));
        assertEquals("Total number transactions is : ",account.getTransactions().size(), 5);
        assertEquals("Number of credit operation is :", account.numberCreditOperation().get(), 3l);
        assertEquals("Total of credit operation is ", account.totalCreditTransactions(), BigDecimal.valueOf(550).setScale(2));
        assertEquals("Number of debit operation is :", account.numberDebitOperation().get(), 2l);
        assertEquals("Total of debit operation is ", account.totalDebitransactions(), BigDecimal.valueOf(250).setScale(2));
        assertEquals("Actual account balance :", account.getBalance().setScale(2), BigDecimal.valueOf(300).setScale(2));
    }
}
