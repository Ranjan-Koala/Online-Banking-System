package com.pj.banking_system.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_record")
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountFrom;
    private Long accountTo;
    private BigDecimal amount;
    private String type;

    public TransactionRecord() {}

    public TransactionRecord(Long from, Long to, BigDecimal amount, String type) {
        this.accountFrom = from;
        this.accountTo = to;
        this.amount = amount;
        this.type = type;
    }
}
