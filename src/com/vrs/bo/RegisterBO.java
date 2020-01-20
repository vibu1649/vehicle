package com.vrs.bo;

import org.apache.log4j.Logger;
import com.vrs.constants.ErrorConstants;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.BusinessException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.UserTO;
import com.vrs.util.PropertyUtil;
import com.vrs.dao.RegisterDao;

public class RegisterBO {

	RegisterDao register=new RegisterDao();
	ValidationsBO validations=new ValidationsBO();
	public static final Logger LOG = Logger.getLogger("EmployeeBO");
	
	public void addUser(UserTO user) throws DatabaseOperationException, ApplicationException, BusinessException {
		String message = null;
		int i=0;
		@SuppressWarnings("static-access")
		int valid = validations.checkUserId(user.getUserid());
		String Password = validations.checkPassword(user.getPassword());
		if(valid!=Integer.parseInt(user.getUserid())){
			user.setResult(1);
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALID_USER);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		else if(!Password.equals(user.getPassword()))
		{
			user.setResult(2);
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALID_PASSWORD);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		else {
			System.out.println("in bo else");
			register.addUser(user);
		}
	}
	
}
