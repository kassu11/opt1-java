package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import entity.*;
import java.util.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harj1PU");

	
	public void addRegister(Register reg) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(reg);
        
        em.getTransaction().commit();
        em.close();
	}
	
	public void addEvent(int eventNumber, int regNumber, double amount) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        Register reg = em.find(Register.class, regNumber);
        SalesEvent evt = new SalesEvent(eventNumber, reg, amount);
        
        em.persist(evt);
        
        em.getTransaction().commit();
        em.close();	
	}

	public void addServiceFee(double fee) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<SalesEvent> cu = cb.createCriteriaUpdate(SalesEvent.class);
		Root<SalesEvent> salesEvent = cu.from(SalesEvent.class);
		cu.where(cb.isNotNull(salesEvent.get("amount")))
			.set("amount", cb.sum(salesEvent.get("amount"), fee));

		Query q = em.createQuery(cu);
		q.executeUpdate();

		em.getTransaction().commit();
		em.close();
	}
	
	public List<SalesEvent> retrieveSmallSales(double limit) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<SalesEvent> result = null;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SalesEvent> cq = cb.createQuery(SalesEvent.class);
		Root<SalesEvent> salesEvent = cq.from(SalesEvent.class);
		cq.select(salesEvent);
		cq.where(cb.lt(salesEvent.get("amount"), limit));
		TypedQuery<SalesEvent> q = em.createQuery(cq);
		result = q.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return result;
	}

	public void deleteAllSales() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<SalesEvent> cd = cb.createCriteriaDelete(SalesEvent.class);
		Root<SalesEvent> salesEvent = cd.from(SalesEvent.class);
		cd.where(cb.isNotNull(salesEvent.get("eventId")));

		Query q = em.createQuery(cd);
		q.executeUpdate();

		em.getTransaction().commit();
		em.close();
	}
	
}
