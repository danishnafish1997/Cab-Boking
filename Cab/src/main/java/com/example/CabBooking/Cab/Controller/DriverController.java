package com.example.CabBooking.Cab.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.CabBooking.Cab.Bean.DriverBean;
import com.example.CabBooking.Cab.Repository.DriverRepository;
import com.example.CabBooking.Cab.Repository.VehicleRepository;
import com.example.CabBooking.Cab.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired  
    private DriverService driverService;  
	
	@Autowired
	private VehicleRepository repo;
	
	@Autowired
	DriverRepository repository;
   
	@RequestMapping(value="/AddDriver", method=RequestMethod.GET)
		public ModelAndView AddDriver() {
			ModelAndView mav=new ModelAndView("AddDriver");
			return mav;
		}
	@RequestMapping(value="/driverMain" ,method=RequestMethod.POST)
	   public ModelAndView driverMain(@RequestParam Map<String ,String> map){
		
        if((repo.existsById(map.get("vehicleNumber")) &&(!repository.existsByVehicleNumber(map.get("vehicleNumber")))) ){
        	ModelAndView mav = new ModelAndView("redirect:/getAllDrivers");
            DriverBean driver = new DriverBean();
            driver.setDriverId(map.get("driverId"));
            driver.setVehicleNumber(map.get("vehicleNumber"));
            driver.setDriverName(map.get("driverName"));
            driver.setDriverContactNumber(map.get("driverContactNumber"));
            driverService.addDriver(driver);
            return mav;
        }
        ModelAndView mav = new ModelAndView("AddDriver");
        mav.addObject("message", "Invalid");
		return mav;
	}
		
	@RequestMapping(value="/updateDriver",method = RequestMethod.GET)
	   public ModelAndView updateDriver(@RequestParam String id, ModelMap model) {
		DriverBean driver = repository.findById(id).get();
		model.put("driver", driver);
		ModelAndView mav = new ModelAndView("updateDriver");
			return mav;
	   }
	
	@RequestMapping(value="/updateDriver",method = RequestMethod.POST)
	public ModelAndView updateDriver(ModelMap model, @Valid DriverBean driver,BindingResult result) {
        if(result.hasErrors()){
        	ModelAndView mav = new ModelAndView("updateDriver");
    		return mav;
        }
        	
        	
		driver.setVehicleNumber(driver.getVehicleNumber());;
		repository.save(driver);
		ModelAndView mav = new ModelAndView("redirect:/getAllDrivers");
		return mav;
		
	}
	
	@RequestMapping(value="/deleteDriver",method=RequestMethod.GET)
	public ModelAndView deleteDriver(@RequestParam String id) {
		repository.deleteById(id);
		ModelAndView mav=new ModelAndView("redirect:/getAllDrivers");
		return mav;
	}
	
	
	@RequestMapping(value="/getAllDrivers",method=RequestMethod.GET)
	public ModelAndView getAllDrivers() {
		List<DriverBean> drivers=new ArrayList<DriverBean>();
		ModelAndView mav=new ModelAndView("getAllDrivers");
		drivers=driverService.getAllDrivers();
		mav.addObject("message", drivers);
			return mav;
	}
}
