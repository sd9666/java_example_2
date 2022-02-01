package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

//Create Session 
Session session = factory.getCurrentSession();


try {
//use the session object to save Java object

//create 3 student objects
System.out.println("Creating a new student object ");
Student tempStudent1 = new Student("Jane", "Wall", "janewall@gmail.com");
Student tempStudent2 = new Student("Ela","Smith", "elasmith@gmail.com");
Student tempStudent3 = new Student("Johnny", "Depp","johnnydepp@gmail.com");

//start a transaction 
session.beginTransaction();
//save the student object 
System.out.println("Saving the students");
session.save(tempStudent1);
session.save(tempStudent2);
session.save(tempStudent3);

//commit transaction
session.getTransaction().commit();
System.out.println("Done");
}
finally {
factory.close();
}



	}

}
