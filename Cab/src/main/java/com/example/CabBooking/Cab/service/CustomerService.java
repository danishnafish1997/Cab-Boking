package com.example.CabBooking.Cab.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CabBooking.Cab.Bean.BookingBean;
import com.example.CabBooking.Cab.Bean.SearchBean;
import com.example.CabBooking.Cab.Bean.VehicleBean;
import com.example.CabBooking.Cab.Dao.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public ArrayList<Object[]> search(SearchBean searchBean) throws ParseException{
		if(searchBean.getSource()==null||searchBean.getDestination()==null){
			return null;
		}
		else if(searchBean.getSource().equals(searchBean.getDestination())){
			return null;
		}
		else
		return 
				customerDao.search(searchBean);
	}
	
	public ArrayList<ArrayList<String>> sourceDestination(){
		return customerDao.sourceDestination();
	}

	public VehicleBean getVehicle(String vid)
	{
		return customerDao.getVehicle(vid);
	}

	 public ArrayList<BookingBean>  bookingHistoryCustomer()

	 {
		 return 
				 customerDao.bookingHistoryCustomer();
	 }

	public ArrayList<BookingBean> bookinghistory(HttpSession session) {
		return customerDao.bookingHistoryCustomer();
	}

	public ArrayList<Object[]> giveRouteDetails(SearchBean searchbean){
		return customerDao.giveRouteDetails(searchbean);
	}
}
