package com.vrs.bo;

import com.vrs.dao.AddVehicleDao;
import com.vrs.model.VehicleTO;

public class addVehicleBO {

	public void addvehicle(VehicleTO vehicle) {
		AddVehicleDao vehicledao=new AddVehicleDao();
		vehicledao.addNewVehicle(vehicle);
		
	}

	
	
	
}
