package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Register;
import com.niit.model.User;

@Repository
public class RegisterDAOImpl implements RegDAO {
	
@Autowired(required=true)	
SessionFactory sessionFactory;
	
@Override
@Transactional
public void addUser(Register userobj) {
		
		
		User uc = new User();
		uc.setUsername(userobj.getUsername());
		uc.setPassword(userobj.getPassword());
		
		System.out.println("usercredential");
		
		Session session=sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		//tx.begin();
		session.merge(userobj);
		session.merge(uc);
		tx.commit();
		session.flush();
		session.close();
	
}
	
}
