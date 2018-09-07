package com.example.CabBooking.Cab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CabBooking.Cab.Bean.LoginBean;
import com.example.CabBooking.Cab.Bean.UserBean;

public interface LoginRepository extends JpaRepository<LoginBean,String>{

	void save(UserBean userBean);
	
}
