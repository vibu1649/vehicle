package com.vrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Logger;

import com.vrs.constants.Constants;
import com.vrs.constants.QueryConstants;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.UserTO;
import com.vrs.util.DbUtil;

public class RegisterDao {

	private Connection connection;
	public static final Logger LOG = Logger.getLogger("EmployeeBO");
	public void addUser(UserTO user) throws DatabaseOperationException, ApplicationException {
		PreparedStatement preparedStatement=null;
		try {
			LOG.info("Inside - method addEmp in EmployeeDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.CREATE_USER);
			preparedStatement.setString(1, user.getUserid());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.setString(4, user.getStatus());
			preparedStatement.setString(5, user.getDate());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("inserted");
			LOG.info("Exit - method addUser in RegisterDao class");
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
