package com.pj.banking_system.dao;

import com.pj.banking_system.model.TransactionRecord;

public interface TransactionDao {
    void save(TransactionRecord record);
}
