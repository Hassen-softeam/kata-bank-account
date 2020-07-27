package com.kata;

import com.kata.constants.TypeTransaction;
import com.kata.exception.AccountTransactionException;
import com.kata.models.Account;
import com.kata.models.Transaction;

import java.math.BigDecimal;
import java.util.Objects;

public class WithdrawalTransaction implements ITransaction {
    @Override
    public void makeTransaction(BigDecimal amount, Account account) throws AccountTransactionException {
        if(Objects.isNull(amount) || Objects.isNull(account)){
            throw new IllegalArgumentException("arguments should not be null.");
        }
        if(amount.compareTo(account.getBalance()) >0){
            throw new AccountTransactionException("insufficient balance.");
        }
        Transaction transaction = ITransaction.createBasicTransaction();
        transaction.setAmount(amount);
        transaction.setTypeTransaction(TypeTransaction.Debit);
        account.getTransactions().add(transaction);
        account.setBalance(account.getBalance().subtract(amount));
    }
}
