package com.example.CabBooking.Cab.Dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.CabBooking.Cab.Bean.BookingBean;
import com.example.CabBooking.Cab.Bean.SearchBean;
import com.example.CabBooking.Cab.Bean.VehicleBean;

@Component
public class CustomerDao {
	
	SessionFactory sessionFactory;
	
	public  ArrayList<Object[]> search(SearchBean searchBean)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		 ArrayList<Object[]> vehicles;
		if(!(searchBean.getVehicleType().isEmpty())&&!(searchBean.getVehicleName().isEmpty())){
			 Query query = session.createSQLQuery("select * from vehicle_table where vehicle_number not in(select vehicle_number from booking_table ) and vehicle_name=? and vehicle_type=?");
			 query.setString(0, searchBean.getVehicleType());
			  query.setString(1, searchBean.getVehicleName());
			  vehicles= (ArrayList<Object[]>) query.list();
		}
		else if(searchBean.getVehicleType().isEmpty()){
			  Query query = session.createSQLQuery("select * from vehicle_table where vehicle_number not in(select vehicle_number from booking_table) and vehicle_name=?");
			  query.setString(0, searchBean.getVehicleName());

			  vehicles= (ArrayList<Object[]>) query.list();
		  }
		  else{
			  Query query = session.createSQLQuery("select * from vehicle_table where vehicle_number not in(select vehicle_number from booking_table) and vehicle_type=?");
		
			  query.setString(0, searchBean.getVehicleType());
			  vehicles= (ArrayList<Object[]>) query.list();
		  }

		   transaction.commit();
		   session.close();
		   return vehicles;
	}
	
	public ArrayList<ArrayList<String>> sourceDestination(){
		Session session=sessionFactory.openSession();
	    Transaction transaction= session.beginTransaction();
	    Query query = session.createSQLQuery("select source from route_table");
	    ArrayList<String> sources = (ArrayList<String>) query.list();

	    Query query1 = session.createSQLQuery("select destination from route_table");
	    ArrayList<String> destinations = (ArrayList<String>) query1.list();
	    ArrayList<ArrayList<String>> sourceDestination = new ArrayList<ArrayList<String>>();
	    sourceDestination.add(sources);
	    sourceDestination.add(destinations);

	    return sourceDestination;

	}
	
	public VehicleBean getVehicle(String vid)
	{
		Session session=sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();
	    VehicleBean vehicleBean=(VehicleBean)session.get(VehicleBean.class,vid);
	    return vehicleBean;

	}
	
	public ArrayList<BookingBean>  bookingHistoryCustomer()
	{
		Session session=sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();

	    Query query = session.createQuery("from booking_table where loginid=?");


	    ArrayList<BookingBean> bookingBean = (ArrayList <BookingBean>)query.list();
		return bookingBean;
	}
	
	public ArrayList<Object[]> giveRouteDetails(SearchBean searchbean){
		Session session=sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();
	    System.out.println("source"+searchbean.getSource());
	    System.out.println("destination"+searchbean.getDestination());

	    Query query = session.createSQLQuery("select route_id from route_table where source=? and destination=?");
	    query.setString(0,searchbean.getSource());
	    query.setString(1,searchbean.getDestination());
	    ArrayList<Object[]> routedetails = (ArrayList<Object[]>) query.list();
	    transaction.commit();
		session.close();
	    return routedetails;
	}

	public ArrayList<BookingBean>  bookinghistory(HttpSession httpSession)
	{
		
		Session session=sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();
	    String loginid=(String) httpSession.getAttribute("loginid");
	    Query query = session.createSQLQuery("from booking_table where login_id=?");
	    query.setString(0,loginid);

	    ArrayList<BookingBean> bookingBeans = (ArrayList <BookingBean>)query.list();
	    return bookingBeans;

	}
	
}
