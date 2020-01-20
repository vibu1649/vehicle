package com.vrs.bo;



import org.apache.log4j.Logger;

import com.vrs.constants.ErrorConstants;
import com.vrs.dao.CustomerProfileDao;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.BusinessException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.CustomerTO;
import com.vrs.util.PropertyUtil;

public class CustomerProfileBO {

	ValidationsBO validations = new ValidationsBO();
	CustomerProfileDao profile = new CustomerProfileDao();
	public static final Logger LOG = Logger.getLogger("EmployeeBO");

	public void addProfile(CustomerTO customer)
			throws DatabaseOperationException, ApplicationException,
			BusinessException {
		String name = ValidationsBO.checkName(customer.getCustomer_Name());
		String email = ValidationsBO.checkEmail(customer.getEmail());
		String phone=ValidationsBO.checkPhone(customer.getPhone());
		String message;
		if (!name.equals(customer.getCustomer_Name())) {
			customer.setResult(1);
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		} else if (!phone.equals(customer.getPhone())) {
			customer.setResult(2);
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALID_PHONE);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}  else if (!email.equals(customer.getEmail())) {
			customer.setResult(3);
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALID_EMAIL);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		else {
			System.out.println("in bo else");
			profile.addCustmerProfileDao(customer);
			System.out.println("addedd");
		}

	}

}
