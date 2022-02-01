package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session 
		Session session = factory.getCurrentSession();
		try {
					
			
			int studentId = 6;
					
			//get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id
			
			System.out.println("\nGetting student with id: " +studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			myStudent.setFirstName("Scooby");
			System.out.println("Get complete: "+myStudent);
			
	
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			
			//new 
			session = factory.getCurrentSession();
			
			
			session.beginTransaction();
			session.createQuery("update Student set email='@hotmail.com'")
			.executeUpdate();
			
			session.getTransaction().commit();
			
			
			
			
		}
		finally {
			factory.close();
		}

	}

}
