package com.ustglobal.jpahibernatejpqlassign3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ustglobal.jpahibernatejpqlassign3.dto.EmployeeInfo;

public class EmployeeDAO_JPQL implements EmployeeDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public int deleteEmp(int id) {
		try {
			et.begin();
			
			String jpql = "delete from EmployeeInfo where id=:id";
			Query query = em.createQuery(jpql);
			query.setParameter("id", id);
			int count = query.executeUpdate();
			
			et.commit();
			return count;
			
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			
		} finally {
			em.close();
		
		}
		return 0;
	}

	public List<EmployeeInfo> selectAllEmp() {
		try {
			String jpql = "from EmployeeInfo";
			Query query = em.createQuery(jpql);
			List<EmployeeInfo> info = query.getResultList();
			return info;
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
		}
		return null;
	}

	public int updateEmp(int id, String name, int sal, String gender) {
		try {
			et.begin();
			
			String jpql = "update EmployeeInfo set name=:name1, sal=:sal1, gender=:gender1 where id=:id1";
			Query query = em.createQuery(jpql);
			query.setParameter("name1", name);
			query.setParameter("sal1", sal);
			query.setParameter("gender1", gender);
			query.setParameter("id1", id);
			int count = query.executeUpdate();
				
			et.commit();
			return count;
			
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			
		} finally {
			em.close();
		}
		return 0;
	}

	public EmployeeInfo selectEmp(int id) {
		try {
			String jpql = "select e from EmployeeInfo e where e.id=:id";
			Query query = em.createQuery(jpql);
			query.setParameter("id", id);
			EmployeeInfo info = (EmployeeInfo) query.getSingleResult();

//			String jpql2 = "find EmployeeInfo by id";	//	DB id
//			Query query2 = em.createNamedQuery(jpql2);
//			query2.setParameter("id", id);		
//			EmployeeInfo info = (EmployeeInfo) query2.getResultList();
			
			return info;
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			em.close();
		}
		return null;
	}

	public int insertEmp(int id, String name, int sal, String gender) {
		try {
			et.begin();
			String jpql = "insert into emp values(:id, :name, :sal, :gender)";
			Query query = em.createNativeQuery(jpql);
			query.setParameter("id", id);
			query.setParameter("name", name);
			query.setParameter("sal", sal);
			query.setParameter("gender", gender);
			int count = query.executeUpdate();
			et.commit();
			return count;
			
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			
		} finally {
			em.close();
		}
		
		return 0;
	}

}
