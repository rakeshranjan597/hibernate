package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class ReadDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		ProductInfo info = em.find(ProductInfo.class, 101);
		System.out.println("~~~~~~~~~~~");
		System.out.println("Id is : "+ info.getId());
		System.out.println("Pname is : "+ info.getPname());
		System.out.println("Quantity is : "+ info.getQuantity());
		
		em.close();
	}
}
