package com.kata;

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
}
