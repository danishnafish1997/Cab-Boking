package com.example.CabBooking.Cab.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.example.CabBooking.Cab.Bean.LoginBean;
import com.example.CabBooking.Cab.Bean.UserBean;

@Component
public class LoginDao {
	
	SessionFactory sessionFactory;
	
	public boolean IsUserValid(LoginBean loginBean) {
		LoginBean bean = null;
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(loginBean.getLoginid());	
			try{
			 bean=(LoginBean) session.get(LoginBean.class,loginBean.getLoginid());

		 }catch(Exception e) {
			 return false;
		 }
		
		if(bean==null)
			return false;
		else {
			if(bean.getPassword().equals(loginBean.getPassword()))
	    		return true;
	    	else
	    		return false;
		}
	}
	
	public String getUserType(LoginBean loginBean) {
		 Session session=sessionFactory.openSession();
		    Transaction transaction=session.beginTransaction();
		    LoginBean bean=(LoginBean) session.get(LoginBean.class,loginBean.getLoginid());
		return bean.getUserType();
	}
	
	public String checkUser(LoginBean loginBean) {
		LoginBean bean;
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		bean=(LoginBean)session.get(LoginBean.class, loginBean.getLoginid());
		if(bean==null) 
			return "User does not exist";
		else
			return "User exists";
	
	}
	
	public String addNewUser(LoginBean loginBean){
		Session session=sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();
	    session.save(loginBean);
	    transaction.commit();
	    session.close();
	    return "New User created";
	}
	
	public String addNewUser(UserBean userBean) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(userBean);
		transaction.commit();
		session.close();
		return "New User created";
	}
	
}

