package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Jane", "Wall", "janewall@gmail.com");
		
			//start a transaction 
			session.beginTransaction();
			//save the student object 
			System.out.println("Saving the student");
			session.save(tempStudent);
					
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
