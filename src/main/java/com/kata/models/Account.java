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
        return BigDecimal.ZERO;
    }

    public BigDecimal totalDebitransactions(){
        return BigDecimal.ZERO;
    }

    public Optional numberCreditOperation(){
        return Optional.ofNullable(0);
    }
    public Optional numberDebitOperation(){
        return Optional.ofNullable(0);
    }

}
