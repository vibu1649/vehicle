package com.vrs.bo;


import java.util.ArrayList;
import java.util.List;

import com.vrs.dao.SearchDao;
import com.vrs.model.VehicleTO;


public class SearchBO {

	SearchDao search= new SearchDao();
	public ArrayList<String> Search(String value)
	{
		ArrayList<String> vehicle = search.search(value);
	
		return vehicle;
	}
	
	public List<VehicleTO> searchItems(String first,String second )
	{
		System.out.println("in search bo");
		List<VehicleTO> vehicle = search.searchItem(first,second);
		System.out.println("after search bo");
		return vehicle;
	}
	
	
	
}
