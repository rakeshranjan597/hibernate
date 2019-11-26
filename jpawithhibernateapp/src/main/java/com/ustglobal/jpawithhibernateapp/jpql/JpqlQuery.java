package com.ustglobal.jpawithhibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class JpqlQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em  = emf.createEntityManager();

//		String jpql = "from ProductInfo";
//		Query q = em.createQuery(jpql);
//		List<ProductInfo> l = q.getResultList();
//		
//		for(ProductInfo info: l) {
//			System.out.println("~~~~~~~~~~~~~~~");
//			System.out.println("Id is: "+ info.getId());
//			System.out.println("Pname is: "+ info.getPname());
//			System.out.println("Quantity is: "+ info.getQuantity());
//		}
		
		String jpql = "select pname from ProductInfo";
		Query q = em.createQuery(jpql);
		List<String> l = q.getResultList();
		
		for(String st: l) {
			System.out.println("~~~~~~~~~~~~~~~");
			System.out.println("Pname is: "+ st);
		}

		
		
	}
}
