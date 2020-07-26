package com.kata.models;

import com.kata.constants.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Date dateTransaction;
    private TypeTransaction typeTransaction;
    private BigDecimal amount;
}
