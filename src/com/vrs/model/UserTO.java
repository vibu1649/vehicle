package com.vrs.model;



public class UserTO {

	
	private String userid;
	private String password;	
	private String role;
	private String status;
	private String date;
	private int result;
	private String Dob;
	

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getDob() {
		return Dob;
	}


	

}
