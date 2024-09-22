package dao;

import entities.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TransactionDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
    public void saveTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(transaction);

        em.getTransaction().commit();
        em.close();
    }

    public Transaction getTransaction(int transactionId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Transaction transaction = em.find(Transaction.class, transactionId);

        em.getTransaction().commit();
        em.close();

        return transaction;
    }
}
