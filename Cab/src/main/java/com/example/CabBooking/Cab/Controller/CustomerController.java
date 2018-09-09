package com.example.CabBooking.Cab.Controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.CabBooking.Cab.Bean.LoginBean;
import com.example.CabBooking.Cab.Repository.LoginRepository;

@RestController
public class CustomerController {


	
	@Autowired
	LoginRepository repo;
	
	@RequestMapping(value="/CustomerHomePage",method = RequestMethod.GET)
	   public ModelAndView CustomerHomePage() {
		   ModelAndView mav = new ModelAndView("Customer");
			return mav;
	   }
	
	@RequestMapping(value="/BookCabNow",method = RequestMethod.GET)
	   public ModelAndView bookCabNow() {
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		 ArrayList<String> destination = new ArrayList<>();
		 destination.add("New Delhi station");
		 destination.add("Uttam Nagar");
		 data.add(destination);
		 ArrayList<String> source = new ArrayList<>();
		 source.add("Janak Puri");
		 source.add("Lakshminagar");
		 data.add(source);
		  ModelAndView mav = new ModelAndView("BookCabNow");
		  mav.addObject("sourceDestination",data);

			return mav;
	   }

	
	
	
	   
	@RequestMapping(value="/viewProfile",method=RequestMethod.GET)
	public ModelAndView profile(HttpSession httpSession) {
		String id = httpSession.getAttribute("user").toString();
		LoginBean customer = repo.findByEmail(id);
		ModelAndView mav = new ModelAndView("viewProfile");
		mav.addObject("customer", customer);
		return mav;
	}
	
	@RequestMapping(value="/editProfile",method=RequestMethod.GET)
    public ModelAndView editProfile(@RequestParam long loginid,ModelMap model) {
		LoginBean loginBean = new LoginBean();
		loginBean = repo.findById(loginid).get();
		System.out.println(loginid);
		ModelAndView mav = new ModelAndView("editProfile");
		model.put("loginBean", loginBean);
		return mav;
	}
	
	@RequestMapping(value="/editProfile",method=RequestMethod.POST)
    public ModelAndView editProfil(ModelMap model,@Valid LoginBean loginBean,BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("editProfile");
			return mav;
		}
		loginBean.setEmail(loginBean.getEmail());
		repo.save(loginBean);
		ModelAndView mav = new ModelAndView("redirect:/viewProfile");
		return mav;
	}
}
