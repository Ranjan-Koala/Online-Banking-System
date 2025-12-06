package com.pj.banking_system.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private BigDecimal balance;

    public Account() {}

    public Account(String accountNumber, Customer c, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.customer = c;
        this.balance = balance;
    }

    // Getters / Setters
    public Long getId() { return id; }
    public String getAccountNumber() { return accountNumber; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

	public Customer getCustomer() {
		return customer;
	}

}
