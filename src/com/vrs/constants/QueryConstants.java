package com.vrs.constants;

public class QueryConstants {
	public static final String QRY_USR_VALIDATE = "select User_id,Password,Role from user_details where User_id =? ";
	public static final String CREATE_USER = "insert into user_details(User_id,Password,Role,status,registered_date) values (?, ?, ?, ?,? )";
	public static final String CUSTOMER_PROFILE = "insert into customer_details values (?,?,?,?,?,?,?)";
	public static final String BOOK_QUERY1 = "select * from vehicles where Branch_Location=? and Vehicle_code=?";
	public static final String REQUESTED_VEHICLE=" insert into vehicle_booking values(?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_APPROVED="select * from vehicle_booking where Booking_status='approved';";
	public static final String SHOW_STOCK_REQUEST="select * from request_more_vehicles order by Vehicle_code;";
	public static final String ADD_NEW_VEHICLE = "insert into vehicles values (?,?,?,?,?,?,?,?)";
	public static final String PENDING_REGISTRATIONS = "select * from user_details where status='F'";
	
	
}
