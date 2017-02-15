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
public class UserDAOImpl implements UserDAO{
	
	@Autowired(required=true)
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public void addUser(User userobj) {
		
		System.out.println("user -----------" +userobj);

		User uc=new User();
		uc.setUsername(userobj.getUsername());
		uc.setPassword(userobj.getPassword());
		/*if((userobj.getUsername()==uc.getUsername())&& userobj.getPassword()==uc.getPassword())
		{
		System.out.println("Already logged in ");;	
		}
			*/
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
