package com.ustglobal.jpawithhibernateassign2.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ustglobal.jpawithhibernateassign2.dto.EmployeeInfo;

public class EmployeeDAO_Hib implements EmployeeDAO{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AssignPersistence");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public EmployeeInfo selectEmp(int id) {
//		EntityManagerFactory emf = null;
//		EntityManager em = null;
		try {
//			emf = Persistence.createEntityManagerFactory("AssignPersistence");
//			em = emf.createEntityManager();
			EmployeeInfo info = em.find(EmployeeInfo.class, id);
			return info;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();			
		}
		return null;
	}

	public void deleteEmp(int id) {
//		EntityManagerFactory emf = null;
//		EntityManager em = null;
//		EntityTransaction et = null;
		try {
//			emf = Persistence.createEntityManagerFactory("AssignPersistence");
//			em = emf.createEntityManager();
//			et = em.getTransaction();
			et.begin();
			EmployeeInfo info = em.find(EmployeeInfo.class, id);
			em.remove(info);
			et.commit();
			System.out.println("~~~~ Data Deleted ~~~~");
			
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			System.out.println("~~~~ Failed To Delete ~~~~");
		} finally {
			em.close();			
		}
	}

	public void updateEmp(int id, String name, int sal, String gender) {
//		EntityManagerFactory emf = null;
//		EntityManager em = null;
//		EntityTransaction et = null;
		try {
//			emf = Persistence.createEntityManagerFactory("AssignPersistence");
//			em = emf.createEntityManager();
//			et = em.getTransaction();
			et.begin();
			EmployeeInfo info = em.find(EmployeeInfo.class, id);
			info.setName(name);
			info.setSal(sal);
			info.setGender(gender);
			
			et.commit();
			System.out.println("~~~~ Data Updated ~~~~");
			
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			System.out.println("~~~~ Failed To Update ~~~~");
		} finally {
			em.close();			
		}
	}

	public void insertEmp(EmployeeInfo info) {
//		EntityManagerFactory emf = null;
//		EntityManager em = null;
//		EntityTransaction et = null;
		try {
//			emf = Persistence.createEntityManagerFactory("AssignPersistence");
//			em = emf.createEntityManager();
//			et = em.getTransaction();
			et.begin();
			em.persist(info);
			et.commit();
			System.out.println("~~~~ Data Inserted ~~~~");
			
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			System.out.println("~~~~ Failed To Delete~~~~");
		} finally {
			em.close();			
		}
	}

	public List<EmployeeInfo> selectAllEmp() {
		try {
			et.begin();
			String jpql = "from EmployeeInfo";
			Query q = em.createQuery(jpql);
			List<EmployeeInfo> info = q.getResultList();
			et.commit();
			return info;
			
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			System.out.println("~~~~ Failed To Retreive All Data ~~~~");
			
		} finally {
			em.close();
		}
		return null;
	}

}
