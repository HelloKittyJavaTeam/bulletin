package it.hellokitty.gt.bulletin.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.VehicleFamily;
import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.entity.VehicleMaster;
import it.hellokitty.gt.bulletin.repository.impl.VehicleFamilyRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.VehicleGroupsRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.VehicleMasterRepositoryImpl;
import it.hellokitty.gt.bulletin.service.FerrariCategoryService;

public class FerrariCategoryServiceImpl implements FerrariCategoryService{
	private VehicleFamilyRepositoryImpl vehicleFamilyRepository = new VehicleFamilyRepositoryImpl();
	private VehicleGroupsRepositoryImpl vehicleGroupsRepository = new VehicleGroupsRepositoryImpl();
	private VehicleMasterRepositoryImpl vehicleMasterRepository = new VehicleMasterRepositoryImpl();

	private static FerrariCategoryServiceImpl ferrariCategoryServiceImpl = null;
	
	private FerrariCategoryServiceImpl(){}
	
	public static FerrariCategoryServiceImpl getInstance(){
		if(ferrariCategoryServiceImpl == null){
			ferrariCategoryServiceImpl = new FerrariCategoryServiceImpl();
		}
		return ferrariCategoryServiceImpl;
	}
	
	/*
	 * GET BY ID
	 */
	
	@Override
	public VehicleFamily getVehicleFamilyById(Object id)
			throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return vehicleFamilyRepository.getById(id);
	}

	@Override
	public VehicleGroups getVehicleGroupsById(Object id)
			throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return vehicleGroupsRepository.getById(id);
	}

	@Override
	public VehicleMaster getVehicleMasterById(Object id)
			throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return vehicleMasterRepository.getById(id);
	}

	/*
	 * GET ALL
	 */
	
	@Override
	public List<VehicleFamily> getVehicleFamilyAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return vehicleFamilyRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<VehicleGroups> getVehicleGroupsAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return vehicleGroupsRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<VehicleMaster> getVehicleMasterAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return vehicleMasterRepository.getAll(start, limit, orderColumn);
	}

	/*
	 * COUNT 
	 */
	
	@Override
	public Long countVehicleFamily() throws Exception {
		return vehicleFamilyRepository.count();
	}

	@Override
	public Long countVehicleGroups() throws Exception {
		return vehicleGroupsRepository.count();
	}

	@Override
	public Long countVehicleMaster() throws Exception {
		return vehicleMasterRepository.count();
	}

	@Override
	public Long countVehicleFamily(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return  vehicleFamilyRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countVehicleGroups(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return  vehicleGroupsRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countVehicleMaster(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return  vehicleMasterRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	/*
	 * SEARCH 
	 */
	
	@Override
	public List<VehicleFamily> searchVehicleFamily(Integer start,
			Integer limit, LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return vehicleFamilyRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<VehicleGroups> searchVehicleGroups(Integer start,
			Integer limit, LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return vehicleGroupsRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<VehicleMaster> searchVehicleMaster(Integer start,
			Integer limit, LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return vehicleMasterRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}