package it.hellokitty.gt.bulletin.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.VehicleFamily;
import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.entity.VehicleMaster;

public interface FerrariCategoryService {
	/*
	 * GET BY ID
	 */
	
	VehicleFamily getVehicleFamilyById(Object id) throws IllegalArgumentException, Exception;
	
	VehicleGroups getVehicleGroupsById(Object id) throws IllegalArgumentException, Exception;
	
	VehicleMaster getVehicleMasterById(Object id) throws IllegalArgumentException, Exception;
	
	/*
	 * GET ALL
	 */
	
	List<VehicleFamily> getVehicleFamilyAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;

	List<VehicleGroups> getVehicleGroupsAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<VehicleMaster> getVehicleMasterAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	/*
	 * COUNT
	 */
	
	Long countVehicleFamily() throws Exception;
	
	Long countVehicleGroups() throws Exception;
	
	Long countVehicleMaster() throws Exception;
	
	Long countVehicleFamily(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countVehicleGroups(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countVehicleMaster(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;

	/*
	 * SEARCH
	 */
	
	List<VehicleFamily> searchVehicleFamily(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<VehicleGroups> searchVehicleGroups(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<VehicleMaster> searchVehicleMaster(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
}
