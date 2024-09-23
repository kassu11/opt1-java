package dao;

import entities.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CarDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
    public void saveCar(Car car) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(car);

        em.getTransaction().commit();
        em.close();
    }
}
