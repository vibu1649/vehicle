package com.vrs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import com.vrs.constants.QueryConstants;
import com.vrs.exceptions.ApplicationException;
import com.vrs.exceptions.DatabaseOperationException;
import com.vrs.model.UserTO;
import com.vrs.util.DbUtil;

public class UserDao implements User{
	
	private Connection connection;
	
	
	public UserTO getUserDetails(final UserTO user) throws DatabaseOperationException, ApplicationException {
		
		//LOG.info("Inside - method getUserDetails in UserDao class");
		final String queryString = QueryConstants.QRY_USR_VALIDATE;
		int response = 0;
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			String password;
			String role;
			statement = connection.prepareStatement(queryString); 
			statement.setString(1, user.getUserid());
			result = statement.executeQuery(); 
			while (result.next()) { 
				password = result.getString(2);
				role = result.getString(3);
				if (user.getPassword().equals(password)) {
					response = 2;
					user.setRole(role);
				} else {
					response = 1;
				}
				user.setResult(response);
				
			}
			//LOG.info("Exit - method getUserDetails in UserDao class");
		} catch (SQLException e) {
			throw new DatabaseOperationException("SQL Exception happened", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} catch (IOException e) {
			
			throw new ApplicationException(e);
		} finally {

			try {
				if (result != null) {
					result.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException e) {
				throw new DatabaseOperationException("SQL Exception happened", e);
			}

		}
		return user;
	}

}
