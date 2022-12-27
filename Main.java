package com.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();

		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of entries");
		int no = scan.nextInt();
		
		for (int i = 1; i <= no; i++) {

			System.out.println("Enter first name");
			String firstName = scan.next();

			System.out.println("Enter last name");
			String lastname = scan.next();

			// insert data into database

			Student std = new Student();

			std.setFirstname(firstName);
			std.setLastname(lastname);

			s.save(std);
		}
		
		t.commit();
		s.close();
		System.out.println("Record saved successfully...");
	}
}