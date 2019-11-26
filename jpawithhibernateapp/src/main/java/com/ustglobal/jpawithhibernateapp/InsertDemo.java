package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class InsertDemo {
	public static void main(String[] args) {
		
		
		ProductInfo pro = new ProductInfo();
		pro.setId(103);
		pro.setPname("Phones");
		pro.setQuantity(6);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pro);
		System.out.println("Record Saved");
		et.commit();
		em.close();
		
	}
}
