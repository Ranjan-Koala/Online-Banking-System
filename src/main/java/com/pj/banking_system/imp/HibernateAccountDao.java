package com.pj.banking_system.imp;

import com.pj.banking_system.dao.AccountDao;
import com.pj.banking_system.model.Account;
import com.pj.banking_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class HibernateAccountDao implements AccountDao {

    @Override
    public Account save(Account a) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        var tx = s.beginTransaction();

        if (a.getId() == null) {
            // NEW ACCOUNT -> persist
            s.persist(a);
        } else {
            // EXISTING ACCOUNT -> merge (update)
            a = s.merge(a);
        }

        tx.commit();
        s.close();
        return a;
    }

    @Override
    public Optional<Account> findById(Long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Account a = s.find(Account.class, id);
        s.close();
        return Optional.ofNullable(a);
    }
    @Override
    public Account findByAccountNumber(String accountNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Account> query = session.createQuery(
                "from Account where accountNumber = :num",
                Account.class
        );
        query.setParameter("num", accountNumber);

        Account acc = query.uniqueResult();
        session.close();
        return acc;
    }

}
