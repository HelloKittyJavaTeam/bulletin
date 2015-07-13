package it.hellokitty.gt.service.impl;

import it.hellokitty.gt.entity.VehicleGroups;
import it.hellokitty.gt.repository.VehicleGroupsRepository;
import it.hellokitty.gt.repository.impl.VehicleGroupsRepositoryImpl;
import it.hellokitty.gt.service.VehicleGroupsService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class VehicleGroupsServiceImpl implements VehicleGroupsService{
	VehicleGroupsRepository vehicleGroupRepository = new VehicleGroupsRepositoryImpl();
	
	@Override
	public Long count() throws Exception {
		return vehicleGroupRepository.count();
	}

	@Override
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
		
		return vehicleGroupRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<VehicleGroups> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return vehicleGroupRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public VehicleGroups fetchById(Object id) throws Exception {
		return vehicleGroupRepository.fetchById(id);
	}

	@Override
	public List<VehicleGroups> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return vehicleGroupRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
