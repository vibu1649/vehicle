package com.vrs.constants;

public final class ErrorConstants {

	private ErrorConstants(){
		new ErrorConstants();
	}
	
	public static final String ERRORCODE = "SYS001";
	public static final String FATALERROR = "500";
	public static final String ERRORPAGE = "error.jsp";
	public static final String ERRORMESSAGES = "errormessages";
	public static final String INVALID_USER = "U001";
	public static final String USERPAGE = "user.jsp";
	public static final String INVALIDUSERNAME = "510";
	public static final String INVALIDPASSWORD = "511";
	public static final String PASSWORD_MISMATCH = "512";
	public static final String ROLE_MISSING = "513";
	public static final String INVALID_PASSWORD = "514";
	public static final String INVALID_EMAIL = "515";
	public static final String INVALID_PHONE = "516";
}
