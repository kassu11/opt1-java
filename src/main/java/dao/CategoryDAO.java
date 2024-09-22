package dao;

import entities.Category;
import entities.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
    public void saveCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(category);

        em.getTransaction().commit();
        em.close();
    }
}
