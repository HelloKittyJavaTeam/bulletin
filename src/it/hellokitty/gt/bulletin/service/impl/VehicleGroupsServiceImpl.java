package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.repository.VehicleGroupsRepository;
import it.hellokitty.gt.bulletin.repository.impl.VehicleGroupsRepositoryImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class VehicleGroupsServiceImpl{
	VehicleGroupsRepository vehicleGroupsRepository = new VehicleGroupsRepositoryImpl();
	private static VehicleGroupsServiceImpl vehicleGroupsServiceImpl;

	private VehicleGroupsServiceImpl() {
		super();
	}
	
	public static VehicleGroupsServiceImpl getInstance(){
		if(vehicleGroupsServiceImpl == null){
			vehicleGroupsServiceImpl = new VehicleGroupsServiceImpl();
		}
		return vehicleGroupsServiceImpl;
	}
	
	public Long count() throws Exception {
		return vehicleGroupsRepository.count();
	}

	
	public Long count(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception {
		if(paramEquals == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramEquals parameter cannot be null.");
		}
		
		if(paramLike == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramLike parameter cannot be null.");
		}
		
		if(paramGE == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramGE parameter cannot be null.");
		}
		
		if(paramLE == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+ this.getClass()+" - paramLE parameter cannot be null.");
		}
		
		return vehicleGroupsRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<VehicleGroups> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return vehicleGroupsRepository.fetchAll(start, limit, orderColumn);
	}

	
	public VehicleGroups fetchById(Object id) throws Exception {
		return vehicleGroupsRepository.fetchById(id);
	}

	
	public List<VehicleGroups> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return vehicleGroupsRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
