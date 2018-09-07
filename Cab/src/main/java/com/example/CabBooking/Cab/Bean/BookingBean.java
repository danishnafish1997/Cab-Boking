package com.example.CabBooking.Cab.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="booking_table")
public class BookingBean {

	@Id
	@Column(name="booking_id")
	private String bookingId;
	@Column(name="vehicle_number")
	private String vehicleNumber;
	@Column(name="booking_date")
	private String bookingDate;
	 @Column(name="login_id")
	private String loginid;
	
	 public BookingBean() {
		 
	 }
	 
	 public BookingBean(String bookingId, String vehicleName, String bookingDate, String fare, String loginid) {
		super();
		this.bookingId = bookingId;
		this.vehicleNumber = vehicleName;
		this.bookingDate = bookingDate;
		this.loginid = loginid;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleName) {
		this.vehicleNumber = vehicleName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	 
}
