package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.onetoone.Person;
import com.ustglobal.jpawithhibernateapp.onetoone.VoterCard;

public class TestOneToOne {
	public static void main(String[] args) {
		
		VoterCard vc = new VoterCard();
		vc.setVid(10);
		vc.setVname("Ram");
		
		Person p = new Person();
		p.setPid(1);
		p.setPname("Ram");
		p.setVoterCard(vc);
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
//			em.persist(p);
			VoterCard vCard = em.find(VoterCard.class, 10);
			System.out.println(vCard.getPerson().getPid());
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
