package dao;

import entities.Account;
import entities.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AccountDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
    public void saveAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(account);

        em.getTransaction().commit();
        em.close();
    }
}
