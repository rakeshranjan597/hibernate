package com.ustglobal.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDemo {
	public static void main(String[] args) {
		
		EntityManagerFactory emf  = null;
		EntityManager em  = null;
		EntityTransaction et = null;
		
		try {
			emf  = Persistence.createEntityManagerFactory("TestPersistence");
			em  = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			String jpql = "delete from ProductInfo where id = 103";
			Query q = em.createQuery(jpql);
			int result = q.executeUpdate();
			System.out.println(result);
			et.commit();
			em.close();

		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			
		} finally {
			
			em.close();
		}
	}
}
