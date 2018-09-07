package com.example.CabBooking.Cab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CabBooking.Cab.Bean.VehicleBean;

public interface VehicleRepository extends JpaRepository<VehicleBean,String>{

	//VehicleBean find(String vehicleNumber);

}
