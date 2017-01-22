package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.niit.model.Register;
import com.niit.model.User;

@Repository
public class RegisterDAO {
	
	SessionFactory sessionFactory;
	

public void addUser(Register userobj) {
		
		
		User uc=new User();
		uc.setUsername(userobj.getUsername());
		uc.setPassword(userobj.getPassword());
		
		System.out.println("usercredential");
		
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		//tx.begin();
		session.save(userobj);
		session.save(uc);
		tx.commit();
		session.flush();
		session.close();
	
}
	
}
