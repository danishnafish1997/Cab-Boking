package com.example.CabBooking.Cab.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.CabBooking.Cab.Bean.BookingBean;
import com.example.CabBooking.Cab.Bean.SearchBean;
import com.example.CabBooking.Cab.Bean.VehicleBean;
import com.example.CabBooking.Cab.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	//why have it when you're not using it?
	private DataFieldMaxValueIncrementer valueIncrementer;
	
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

	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView search(SearchBean searchBean,HttpSession session) throws ParseException {
		System.out.println("Destinate is"+ searchBean.getDestination());
		if(searchBean.getDestination().isEmpty()) {
			ModelAndView mav=new ModelAndView("BookCabNow");
			mav.addObject("message","Please enter the destination");
		}
		session.setAttribute("searchBean", searchBean);
		ArrayList<Object[]> vehicleBeans=new ArrayList<Object[]>();
			vehicleBeans= customerService.search(searchBean);
		
		if(vehicleBeans==null) {
			ModelAndView mav=new ModelAndView("BookCabNow");
			mav.addObject("message","Please enter correct soure and destination");
			return mav;
		}
		 if(vehicleBeans.size()==0){
			  ModelAndView model = new ModelAndView("BookCabNow");
				model.addObject("warning", "Sorry! vehicle with such specifications is not present, Please try another search");
				return model;
		  }
		 else {
			 ModelAndView mav=new ModelAndView("SearchResults");
			 mav.addObject("cabList",vehicleBeans);
			 return mav;
		 }
	}
	
	
	@RequestMapping(value="/ConfirmBooking",method = RequestMethod.GET)
	 public ModelAndView ConfirmBooking(@RequestParam Map<String,Object> map,HttpSession session) {
		   ModelAndView mav = new ModelAndView("ConfirmBooking");
		   mav.addObject("vehicleDetails",map.get("vehicleId"));
		  String vehicleId=(String)map.get("vehicleId");
		  VehicleBean vehicleBean=customerService.getVehicle(vehicleId);
		   mav.addObject("vehicleDetails",vehicleBean);

		   SearchBean searchBean=(SearchBean)session.getAttribute("searchbean");

		   mav.addObject("searchDetails",searchBean);
		   ArrayList<Object[]> routeDetails = customerService.giveRouteDetails(searchBean);
		   mav.addObject("routedetails",routeDetails);
			return mav;
	   }
	
	@RequestMapping(value="/BookingHistory",method = RequestMethod.GET)
	 public ModelAndView BookingHistory(HttpSession session)
	{
		ModelAndView mav = new ModelAndView("BookingHistory");
		 ArrayList<BookingBean> bookingBean=customerService.bookinghistory(session);
		mav.addObject("bookingBean",bookingBean);
		return mav;
	}
	
	@RequestMapping(value="/BookedTicketsAll",method = RequestMethod.GET)
	 public ModelAndView BookedTicketsAll()
	{
		ModelAndView mav = new ModelAndView("CustomerBookingHistory");
	 ArrayList<BookingBean> bookingBean=customerService.bookingHistoryCustomer();
		mav.addObject("bookingbeans",bookingBean);
		return mav;
	}


}
