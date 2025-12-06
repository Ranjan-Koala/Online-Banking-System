package com.pj.banking_system.imp;

import com.pj.banking_system.dao.CustomerDao;
import com.pj.banking_system.model.Customer;
import com.pj.banking_system.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Optional;

public class HibernateCustomerDao implements CustomerDao {

    @Override
    public Customer save(Customer c) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.persist(c);
        s.getTransaction().commit();
        s.close();
        return c;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Customer c = s.get(Customer.class, id);
        s.close();
        return Optional.ofNullable(c);
    }
}
