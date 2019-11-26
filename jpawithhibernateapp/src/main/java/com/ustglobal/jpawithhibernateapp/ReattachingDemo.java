package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class ReattachingDemo {
	public static void main(String[] args) {
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			ProductInfo info = entityManager.find(ProductInfo.class, 101);
			
			System.out.println(entityManager.contains(info));
			entityManager.detach(info);
			System.out.println(entityManager.contains(info));
			
			ProductInfo info2 = entityManager.merge(info);
			info2.setPname("Mobiles");
			System.out.println("Updated Record");
			entityTransaction.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();

	}
}
