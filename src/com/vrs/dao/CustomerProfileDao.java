package com.vrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Logger;

import com.vrs.constants.QueryConstants;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.CustomerTO;
import com.vrs.util.DbUtil;

public class CustomerProfileDao {

	
	private Connection connection;
	public static final Logger LOG = Logger.getLogger("CustomerProfileBO");
	public void addCustmerProfileDao(CustomerTO customer) throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement=null;
		try {
			LOG.info("Inside - method addEmp in addCustmerProfileDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.CUSTOMER_PROFILE);
			preparedStatement.setString(1, customer.getLogin_id());
			preparedStatement.setString(2, customer.getCustomer_Name());
			preparedStatement.setString(3, customer.getDob());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getPhone());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setString(7, customer.getOccupation());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("inserted");
			LOG.info("Exit - method addUser in CustomerDao class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);
		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		}
		finally {

			try {
				preparedStatement.close();
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(
						sqlException);
			}
		}
	}
	
	
}
