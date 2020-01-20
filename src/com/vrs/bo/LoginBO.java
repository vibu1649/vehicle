package com.vrs.bo;

//import org.apache.log4j.Logger;

import com.vrs.exceptions.*;
import com.vrs.constants.ErrorConstants;
import com.vrs.dao.User;
import com.vrs.dao.UserDao;
import com.vrs.exceptions.BusinessException;
import com.vrs.model.UserTO;
import com.vrs.util.PropertyUtil;
import org.apache.log4j.Logger;

public class LoginBO {
	
	UserDao userdao = new UserDao();
	public static final Logger LOG = Logger.getLogger("LoginBO");
	public UserTO validateUser(UserTO userTO)throws BusinessException, DatabaseOperationException, ApplicationException {
	
		String message = null;
		int flag = 0; 
		LOG.info("Method Validate User Invoked" + userTO);
		userdao.getUserDetails(userTO);
		LOG.debug("Authentication flag" + flag);
		if (userTO.getResult() == 0) {
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		} else if (userTO.getResult() == 1) {
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDPASSWORD);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		LOG.info("Validate User: Response true");
		return userTO;
	}
}
