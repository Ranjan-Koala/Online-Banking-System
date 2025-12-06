package com.pj.banking_system.service;

import com.pj.banking_system.imp.HibernateAccountDao;
import com.pj.banking_system.imp.HibernateTransactionDao;
import com.pj.banking_system.model.Account;
import com.pj.banking_system.model.TransactionRecord;
import com.pj.banking_system.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class BankingService {

    private final HibernateAccountDao accountDao = new HibernateAccountDao();
    private final HibernateTransactionDao txDao = new HibernateTransactionDao();
    
    public Long findIdByAccountNumber(String accNumber) {
        Account acc = accountDao.findByAccountNumber(accNumber);

        if (acc == null) {
            throw new RuntimeException("Account not found for number: " + accNumber);
        }

        return acc.getId();
    }

    public boolean transferFunds(Long fromId, Long toId, BigDecimal amount) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            // Hibernate 7 -> find()
            Account from = session.find(Account.class, fromId);
            Account to   = session.find(Account.class, toId);

            if (from == null || to == null) {
                throw new RuntimeException("Account not found");
            }

            if (from.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient funds");
            }

            // Sirf values change karo, update() call karne ki zaroorat nahi
            from.setBalance(from.getBalance().subtract(amount));
            to.setBalance(to.getBalance().add(amount));

            // Y E  L I N E S  H A T A  D O  👇
            // session.update(from);
            // session.update(to);

            // Transaction record ko persist karo (save() nahi)
            TransactionRecord tr =
                    new TransactionRecord(fromId, toId, amount, "TRANSFER");
            session.persist(tr);   // <- save() ki jagah persist()

            tx.commit();
            return true;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }
    }
}
