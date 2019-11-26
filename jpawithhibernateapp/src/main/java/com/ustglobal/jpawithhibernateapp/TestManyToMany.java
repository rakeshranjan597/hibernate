package com.ustglobal.jpawithhibernateapp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.manytomany.Course;
import com.ustglobal.jpawithhibernateapp.manytomany.Student;
import com.ustglobal.jpawithhibernateapp.onetomany.PencilBox;

public class TestManyToMany {
	public static void main(String[] args) {
		
		Course course = new Course();
		course.setCid(1);
		course.setCname("Python");
		
		Course course1 = new Course();
		course1.setCid(2);
		course1.setCname("Java");
		
		Course course2 = new Course();
		course2.setCid(3);
		course2.setCname("C");
		
		ArrayList<Course> al = new ArrayList<Course>();
		al.add(course);
		al.add(course1);
		al.add(course2);
		
		Student student = new Student();
		student.setSid(10);
		student.setSname("Rakesh");
		student.setCourses(al);
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("TestPersistence");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			
//			PencilBox pb = em.find(PencilBox.class, 1);
//			System.out.println(pb.getPencil().get(1));
			
			
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
