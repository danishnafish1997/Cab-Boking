package com.example.CabBooking.Cab.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.CabBooking.Cab.Bean.DriverBean;
import com.example.CabBooking.Cab.Bean.VehicleBean;
import com.example.CabBooking.Cab.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired  
    private VehicleService vehicleService;   
   
	@RequestMapping(value="/home",method = RequestMethod.GET)
	   public ModelAndView home() {
		   ModelAndView mav = new ModelAndView("Admin");
			return mav;
	   }
	
	@RequestMapping(value="/AddVehicle", method=RequestMethod.GET)
	public ModelAndView AddVehicle() {
		ModelAndView mav=new ModelAndView("AddVehicle");
		return mav;
	}
@RequestMapping(value="/vehicleMain", method=RequestMethod.POST)
public ModelAndView vehicleMain(@RequestParam Map<String,String> map) {
	VehicleBean vehicleBean=new VehicleBean();
	vehicleBean.setVehicleNumber(map.get("vehicleNumber"));
	vehicleBean.setVehicleName(map.get("vehicleName"));
	vehicleBean.setVehicleType(map.get("vehicleType"));
	String result=vehicleService.AddVehicle(vehicleBean);
	if(result.equals("FAIL")) {
		ModelAndView mav=new ModelAndView("AddVehicle");
		mav.addObject("warning", "Please fill the complete details");
		return mav;
	}
	else {
		ModelAndView mav = new ModelAndView("Admin");
		 mav.addObject("message", "Vehicle's Details Successfully Added");
			return mav;
	}
}

@RequestMapping(value="/updateVehicle",method = RequestMethod.GET)
   public ModelAndView updateVehicle() {
	   ModelAndView mav = new ModelAndView("updateVehicle");
		return mav;
   }

@RequestMapping(value="/updateMainVehicle",method = RequestMethod.GET)
public ModelAndView updateMainVehicle(@RequestParam Map<String,String> map) {
	  System.out.println(map.get("vehicleNumber"));
	  if(vehicleService.getVehicle(map.get("vehicleNumber"))!=null)
	  {
		  ModelAndView mav = new ModelAndView("updateMainVehicle");
		  mav.addObject("message", vehicleService.getVehicle(map.get("vehicleNumber")));
			return mav;
	  }
	  else{
	   ModelAndView mav = new ModelAndView("updateVehicle");
	   mav.addObject("message", "Requested vehcile number is not present");
		return mav;
		}
	}

@RequestMapping(value="/vehicleFinalUpdate", method=RequestMethod.POST)
public ModelAndView driverFinalUpdate(@RequestParam Map<String,String> map) {
	VehicleBean vehicleBean=new VehicleBean();
	vehicleBean.setVehicleNumber(map.get("vehicleNumber"));
	vehicleBean.setVehicleName(map.get("vehicleNme"));
	vehicleBean.setVehicleType(map.get("vehicleType"));
	ModelAndView mav=new ModelAndView("Admin");
	mav.addObject("message","Vehicle's detail updated successfully");
	return mav;
}

@RequestMapping(value="/deleteVehicle",method=RequestMethod.GET)
public ModelAndView deleteDriver() {
	ModelAndView mav=new ModelAndView("deleteVehicle");
	return mav;
}

@RequestMapping(value="/deleteMainVehicle",method = RequestMethod.GET)
public ModelAndView deleteMainVehicle(@RequestParam Map<String,String> map) {
	  System.out.println(map.get("vehicleNumber"));
	  if(vehicleService.getVehicle(map.get("vehicleNumber"))!=null)
	  {
		  ModelAndView mav = new ModelAndView("deleteMainVehicle");
		  mav.addObject("returning_object", vehicleService.getVehicle(map.get("vehicleNumber")));
			return mav;
	  }
	  else{
	   ModelAndView mav = new ModelAndView("deleteVehicle");
	   mav.addObject("message", "Requested vehicle number to be deleted is not present");
		return mav;
		}
}

@RequestMapping(value="/vehicleFinalDelete",method=RequestMethod.POST)
public ModelAndView driverFinalDelete(@RequestParam Map<String,String> map) {
	VehicleBean vehicleBean=new VehicleBean();
	vehicleBean.setVehicleNumber(map.get("vehicleNumber"));
	vehicleBean.setVehicleName(map.get("vehicleName"));
	vehicleBean.setVehicleType(map.get("vehicleType"));
	if(vehicleService.deleteVehicle(vehicleBean).equals("SUCCESS")) {
		ModelAndView mav=new ModelAndView("Admin");
		mav.addObject("message","Vehicle's details deleted successfully");
		return mav;
	}
	else
		return null;
}

@RequestMapping(value="/getAllVehicles",method=RequestMethod.GET)
public ModelAndView getAllVehicles() {
	List<VehicleBean> vehicles=new ArrayList<VehicleBean>();
	ModelAndView mav=new ModelAndView("getAllVehicles");
	vehicles=vehicleService.getAllVehicles();
	mav.addObject("listOfVehicles", vehicles);
		return mav;
}
}
