package com.vrs.model;

public class BookedTO {

	private String Manufacturer_Name;
	public String getManufacturer_Name() {
		return Manufacturer_Name;
	}
	public void setManufacturer_Name(String manufacturer_Name) {
		Manufacturer_Name = manufacturer_Name;
	}
	public String getEx_showroom_price() {
		return Ex_showroom_price;
	}
	public void setEx_showroom_price(String ex_showroom_price) {
		Ex_showroom_price = ex_showroom_price;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getVehicle_code() {
		return Vehicle_code;
	}
	public void setVehicle_code(String vehicle_code) {
		Vehicle_code = vehicle_code;
	}
	public String getBooking_confirmed_date() {
		return Booking_confirmed_date;
	}
	public void setBooking_confirmed_date(String booking_confirmed_date) {
		Booking_confirmed_date = booking_confirmed_date;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getBooking_status() {
		return Booking_status;
	}
	public void setBooking_status(String booking_status) {
		Booking_status = booking_status;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	private String Ex_showroom_price;
	private String Color;
	private String User_id;
	private String Branch;
	private String Vehicle_code;
	private String Booking_confirmed_date;
	private String Comments;
	private String Booking_status;
	private String Booking_date;
	public String getBooking_date() {
		return Booking_date;
	}
	public void setBooking_date(String booking_date) {
		Booking_date = booking_date;
	}
	private int result;
	
}
