package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session 
		Session session = factory.getCurrentSession();
		try {
			//use the session object to save Java object
			
			//create a student object
			System.out.println("Creating a new student object ");
			Student tempStudent = new Student("Doe", "Wan", "doewan@gmail.com");
		
			//start a transaction 
			session.beginTransaction();
			//save the student object 
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();
			
			//find out student's id
			System.out.println("Saved student. Generated id "+tempStudent.getId());
			
			//get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id
			
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
	
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
