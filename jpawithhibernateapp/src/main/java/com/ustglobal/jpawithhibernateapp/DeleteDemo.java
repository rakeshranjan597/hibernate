package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class DeleteDemo {
	public static void main(String[] args) {
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence"); 
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			ProductInfo info = entityManager.find(ProductInfo.class, 101);
			entityManager.remove(info);
			System.out.println("Deleted Record");
			entityTransaction.commit();
		
		} catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}
}
