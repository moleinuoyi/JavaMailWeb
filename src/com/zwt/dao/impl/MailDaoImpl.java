package com.zwt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zwt.dao.MailDao;
import com.zwt.modle.Local;
import com.zwt.modle.Mail_Receive;
import com.zwt.modle.Mail_Send;
import com.zwt.modle.Status;
import com.zwt.util.Page;

public class MailDaoImpl  extends HibernateDaoSupport implements MailDao{

	@Override
	public boolean insertMail_Receive(Mail_Receive mail) {
		// TODO Auto-generated method stub
		try {
			Session session = this.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(mail);
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

	@Override
	public boolean insertMail_Send(Mail_Send mail) {
		// TODO Auto-generated method stub
		try {
			Session session = this.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.save(mail);
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
	
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public List<Mail_Receive> selectMailByUserName(String userName) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "From Mail_Receive as model where model.receivePeople ='"+userName+"' AND model.local = 1";
		//System.out.println(queryString);
		List<Mail_Receive> results = session.createQuery(queryString).list();
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return results;
	}

	@Override
	public int selectMailAllCount(String mailName) {
		// TODO Auto-generated method stub
		return selectMailByUserName(mailName).size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mail_Receive> selectMailByMailName_Commons_FenYe(String userName, Page page, int localid) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "From Mail_Receive as model where model.receivePeople ='"+userName+"' AND model.local = "+localid;
		Query<?> query = session.createQuery(queryString).setCacheable(true);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		List<?> results = query.list();
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return (List<Mail_Receive>)results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Local> selectMail_Local(String userId) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "From Local as model where model.userId = 0 OR model.userId = "+userId;
		//System.out.println(queryString);
		List<Local> results = (List<Local>)session.createQuery(queryString).list();
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> selectMail_Status(String userId) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "From Status as model where model.userId = 0 OR model.userId = "+userId;
		//System.out.println(queryString);
		List<Status> results = (List<Status>)session.createQuery(queryString).list();
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return results;
	}

	@Override
	public Mail_Receive selectMailByMailId(String mailId) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "From Mail_Receive as modle where modle.id="+mailId;
		List results = session.createQuery(queryString).setCacheable(true).list();
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return (Mail_Receive)results.get(0);
	}

	@Override
	public boolean updateMail_ReceiveStayus(Mail_Receive mail) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(mail);
		tx.commit();
		if(session.isOpen()) {
			session.close();
		}
		return false;
	}

}
