package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session 
		Session session = factory.getCurrentSession();
		try {
	
			
	
			//start a transaction 
			session.beginTransaction();
		
			
			//query 
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			//display the students
					
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Wan'").getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Smith' OR s.firstName='Johnny'").getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where "+ "s.email LIKE '%gmail.com'").getResultList();
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
