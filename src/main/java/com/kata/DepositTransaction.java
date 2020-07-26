package com.kata;

import com.kata.constants.TypeTransaction;
import com.kata.models.Account;
import com.kata.models.Transaction;

import java.math.BigDecimal;
import java.util.Objects;

public class DepositTransaction implements ITransaction {

    public void makeTransaction(BigDecimal amount, Account account) {
        if(Objects.isNull(amount) || Objects.isNull(account)){
            throw new IllegalArgumentException("arguments should not be null.");
        }
        Transaction transaction = ITransaction.createBasicTransaction();
        transaction.setAmount(amount);
        transaction.setTypeTransaction(TypeTransaction.Credit);
        account.getTransactions().add(transaction);
        account.setBalance(account.getBalance().add(amount));
    }
}
