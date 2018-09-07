package com.example.CabBooking.Cab.Bean;

public class SearchBean {

	private String source;
	private String destination;
	private String vehicleName;
	private String vehicleType;
	
	public SearchBean() {
		
	}

	public SearchBean(String source, String destination, String vehicleName, String vehicleType) {
		super();
		this.source = source;
		this.destination = destination;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
