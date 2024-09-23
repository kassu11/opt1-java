package dao;

import entities.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DriverDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
    public void saveDriver(Driver driver) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(driver);

        em.getTransaction().commit();
        em.close();
    }

    public void updateDriver(Driver driver) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(driver);

        em.getTransaction().commit();
        em.close();
    }
}
