package com.kata.models;

import com.kata.constants.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long idCompte;
    private String owner;
    private Date dateCreation;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<Transaction> transactions = new ArrayList<>();

    public BigDecimal totalCreditTransactions(){
        Double sum = transactions.stream().filter(t->t.getTypeTransaction().equals(TypeTransaction.Credit)).mapToDouble(t->t.getAmount().doubleValue()).sum();
        return BigDecimal.valueOf(sum).setScale(2);
    }

    public BigDecimal totalDebitransactions(){
        Double sum = transactions.stream().filter(t->t.getTypeTransaction().equals(TypeTransaction.Debit)).mapToDouble(t->t.getAmount().doubleValue()).sum();
        return BigDecimal.valueOf(sum).setScale(2);
    }

    public Optional numberCreditOperation(){
        long count = transactions.stream().filter(t->t.getTypeTransaction().equals(TypeTransaction.Credit)).count();
        return Optional.ofNullable(count);
    }
    public Optional numberDebitOperation(){
        long count = transactions.stream().filter(t->t.getTypeTransaction().equals(TypeTransaction.Debit)).count();
        return Optional.ofNullable(count);
    }

}
