package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.onetomany.Pencil;
import com.ustglobal.jpawithhibernateapp.onetomany.PencilBox;


public class TestOneToMany {
public static void main(String[] args) {
		
		PencilBox pBox = new PencilBox();
		pBox.setBid(1);
		pBox.setBname("Apsara");
		
		Pencil pencil = new Pencil();
		pencil.setPid(11);
		pencil.setColor("black");
		pencil.setPencilBox(pBox);
		
		Pencil pencil1 = new Pencil();
		pencil1.setPid(12);
		pencil1.setColor("red");
		pencil1.setPencilBox(pBox);
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
//			em.persist(pencil);
//			em.persist(pencil1);
			
			PencilBox pb = em.find(PencilBox.class, 1);
			System.out.println(pb.getPencil().get(1));
			
			et.commit();
			System.out.println("~~~~ Data Inserted ~~~~");
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			System.out.println("~~~~ Failed To Insert ~~~~");
		} finally {
			em.close();
		}
	}
}
