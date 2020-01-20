package com.vrs.bo;

import java.util.List;

import com.vrs.dao.AdminDao;
import com.vrs.dao.VehicleDao;
import com.vrs.model.AdminTO;
import com.vrs.model.UserTO;
import com.vrs.model.VehicleTO;

public class AdminBO {
	AdminDao adminDao= new AdminDao();
	AdminTO adminBean=new AdminTO();
	public List<AdminTO> stock_requests()
	{
	
		List<AdminTO> show_list = adminDao.stock_requests();
	
		return show_list;
	}
	public List<UserTO> pendingRegistrations()
	{
	
		List<UserTO> show_list = adminDao.pendingRegistrations();

		return show_list;
	}
	public int approveRegistrations(String[] userids)
	{
	
		int count = adminDao.approveRegistrations(userids);

		return count;
		
	}
	public int approveVehicles(String[] vehicles)
	{
		System.out.println("in admin bo");
		int count = adminDao.approveVehicles(vehicles);
		System.out.println("after admin bo");
		return count;
		
	}
}
