package com.pj.banking_system.dao;

import com.pj.banking_system.model.Customer;
import java.util.Optional;

public interface CustomerDao {
    Customer save(Customer c);
    Optional<Customer> findById(Long id);
}
