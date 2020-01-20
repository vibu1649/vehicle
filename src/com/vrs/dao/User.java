package com.vrs.dao;

import com.vrs.exceptions.ApplicationException;


import com.vrs.model.UserTO;

public interface User {
	  
	public UserTO getUserDetails(final UserTO user) throws ApplicationException; 
}
