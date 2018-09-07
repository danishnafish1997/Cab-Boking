package com.example.CabBooking.Cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CabBooking.Cab.Bean.LoginBean;
import com.example.CabBooking.Cab.Bean.UserBean;
import com.example.CabBooking.Cab.Dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public String login(LoginBean bean) {
		boolean ifValid;
		if(bean==null)
			return "INVALID";
		else if(bean.getLoginid()==null || bean.getPassword()==null)
			return "INVALID";
		else
			ifValid=loginDao.IsUserValid(bean);
		if(ifValid==false)
			return "INVALID";
		else 
			return loginDao.getUserType(bean);
	}
	
	public String addNewUser(LoginBean loginBean){
		String result = loginDao.checkUser(loginBean);
		if(result.equals("User does not exist"))
		{
			return loginDao.addNewUser(loginBean);

		}
		else
			return "User Exist";
	}

	public String addNewUser(UserBean userBean){
		return loginDao.addNewUser(userBean);
	}

}
