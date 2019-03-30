package com.zwt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zwt.dao.UserDao;
import com.zwt.modle.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try {
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User selectUserByMailName(String mailName) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "From User where mailName='"+mailName+"'";
		System.out.println(queryString);
		List<?> results = session.createQuery(queryString).list();
		if(results.size() == 0) {
			System.out.println("NULL");
			return null;
		}
		User userresults = (User)results.get(0);
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return userresults;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			Session session = this.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			if(session.isOpen()) {
				session.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
