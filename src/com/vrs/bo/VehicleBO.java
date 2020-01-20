package com.vrs.bo;

import java.util.ArrayList;
import java.util.List;

import com.vrs.dao.VehicleDao;
import com.vrs.model.VehicleTO;

public class VehicleBO {
	VehicleDao vehicleDao= new VehicleDao();
	VehicleTO vehicleBean=new VehicleTO();
	public List<VehicleTO> approved_requests()
	{
		System.out.println("in vehicle bo");
		List<VehicleTO> approved_list = vehicleDao.approved_requests();
		System.out.println("after vehicle bo");
		return approved_list;
	}
	
}
