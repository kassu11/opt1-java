package dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import entity.*;
import java.util.*;

public class Dao {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harj1PU");

	
	public void addAccount(Account account) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
        em.persist(account);
        
        em.getTransaction().commit();
        em.close();
	}

	public Account getAccount(int accountNumber) {
		EntityManager em = emf.createEntityManager();
		Account account = em.find(Account.class, accountNumber);
		em.close();
		return account;
	}

	public void transfer(int sourceAccountNumber, int destinationAccountNumber, double amount) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Account source = em.find(Account.class, sourceAccountNumber);
			Account destination = em.find(Account.class, destinationAccountNumber);

			if (source.getBalance() >= amount && amount > 0) {
				source.setBalance(source.getBalance() - amount);
				destination.setBalance(destination.getBalance() + amount);

				em.merge(source);
				em.merge(destination);

				em.getTransaction().commit();
			} else {
				System.out.println("Insufficient funds.");
			}
		} catch (OptimisticLockException ole) {
			em.getTransaction().rollback();
			System.out.println("Optimistic locking exception: version conflict.");
		} finally {
			em.close();
		}
	}
}
