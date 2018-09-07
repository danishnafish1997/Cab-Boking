package com.example.CabBooking.Cab.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.CabBooking.Cab.Bean.LoginBean;
import com.example.CabBooking.Cab.Bean.UserBean;
import com.example.CabBooking.Cab.Repository.LoginRepository;

@RestController
public class LoginController {

	
	@Autowired
	LoginRepository repo;
	
	 @RequestMapping(value="/",method = RequestMethod.GET)
	   public ModelAndView Login() {
		   ModelAndView mav = new ModelAndView("index");
			return mav;
	   }
	 
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView login( HttpSession httpSession, @RequestParam Map<String,String> map1,@RequestParam Map<String,String> map2) {
		 
		 String loginid = map1.get("loginid");
		 String password = map2.get("password");
		 if((loginid == null) || password == null){
			 ModelAndView mav = new ModelAndView("index");
			 mav.addObject("message", "Please check loginid or password");
		 }
		 else if(loginid.equals("admin") && password.equals("password")){
			 httpSession.setAttribute("admin", "admin");
			 ModelAndView mav = new ModelAndView("Admin");
			 mav.addObject("admin", loginid);
			 return mav;
		 }
		 else if( repo.existsById(loginid)){
			 LoginBean user = repo.findById(loginid).get();
			 if(user.getLoginid().equals(loginid) && user.getPassword().equals(password)){
				 httpSession.setAttribute("loginid", loginid);
				 ModelAndView mav = new ModelAndView("Customer");
				 return mav;
			 }
		 }
		 
		 ModelAndView mav = new ModelAndView("index");
		 mav.addObject("message", "Please check loginid or password");
		 
	   return mav;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav=new ModelAndView("register");
		return mav;
	}
	
	@RequestMapping(value="/registerPage",method=RequestMethod.POST)
	public ModelAndView registerPage(@RequestParam Map<String,String> map) {
		
		 if(map.get("password").equals(map.get("con_password"))==false){
			  ModelAndView mav = new ModelAndView("register");
				mav.addObject("warning", "Please make the password same");
				return mav;
		  }

		 
		UserBean userBean=new UserBean();
		userBean.setLoginid(map.get("loginid"));
		userBean.setUserName(map.get("userName"));
		userBean.setUserAddress(map.get("userAddress"));
		userBean.setUserContactNumber(map.get("userContactNumber"));
	
		LoginBean loginBean=new LoginBean();
		loginBean.setLoginid(map.get("loginid"));
		loginBean.setPassword(map.get("password"));
		loginBean.setUserType(map.get("userType"));
		
		
		if(repo.existsById(map.get("loginid"))) {
		ModelAndView mav=new ModelAndView("register");
		mav.addObject("message","User already exist");
		return mav;
		}
		else {
			repo.save(loginBean);
			repo.save(userBean);
			ModelAndView mav=new ModelAndView("index");
			mav.addObject("message", "You have registered succeddfully");
			return mav;
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession httpSession) {
		ModelAndView mav=new ModelAndView("index");
		httpSession.invalidate();
		mav.addObject("message","Logged out successfully");
		return mav;
	}

}