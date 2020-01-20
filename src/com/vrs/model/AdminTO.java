package com.vrs.model;

public class AdminTO {
	private String Vehicle_code;
	private String Manufacturer_Name;	
	private String Ex_showroom_price;
	private String Colour;
	private String No_of_vehicle_In_stock;
	private String Branch;
	private String request_more_vehiclescol;
	public String getVehicle_code() {
		return Vehicle_code;
	}
	public void setVehicle_code(String vehicle_code) {
		Vehicle_code = vehicle_code;
	}
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
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}
	public String getNo_of_vehicle_In_stock() {
		return No_of_vehicle_In_stock;
	}
	public void setNo_of_vehicle_In_stock(String no_of_vehicle_In_stock) {
		No_of_vehicle_In_stock = no_of_vehicle_In_stock;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getRequest_more_vehiclescol() {
		return request_more_vehiclescol;
	}
	public void setRequest_more_vehiclescol(String request_more_vehiclescol) {
		this.request_more_vehiclescol = request_more_vehiclescol;
	}
	
}
