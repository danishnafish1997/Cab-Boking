package com.example.CabBooking.Cab.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.CabBooking.Cab.Bean.VehicleBean;

public interface VehicleRepository extends CrudRepository<VehicleBean,String>{

	//VehicleBean find(String vehicleNumber);

}
