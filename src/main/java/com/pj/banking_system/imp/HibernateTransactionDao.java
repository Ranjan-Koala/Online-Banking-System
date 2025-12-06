package com.pj.banking_system.imp;

import com.pj.banking_system.dao.TransactionDao;
import com.pj.banking_system.model.TransactionRecord;
import com.pj.banking_system.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateTransactionDao implements TransactionDao {

    @Override
    public void save(TransactionRecord record) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.persist(record);
        s.getTransaction().commit();
        s.close();
    }
}
