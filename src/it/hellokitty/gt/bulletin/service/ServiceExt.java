package it.hellokitty.gt.bulletin.service;

import it.hellokitty.gt.bulletin.entity.AdUsers;
import it.hellokitty.gt.bulletin.entity.DealerRoles;
import it.hellokitty.gt.bulletin.entity.Dealers;
import it.hellokitty.gt.bulletin.entity.Department;
import it.hellokitty.gt.bulletin.entity.GeoAreas;
import it.hellokitty.gt.bulletin.entity.GeoCountries;
import it.hellokitty.gt.bulletin.entity.GeoRegions;
import it.hellokitty.gt.bulletin.entity.TechAreaDept;
import it.hellokitty.gt.bulletin.entity.UserDealerRoles;
import it.hellokitty.gt.bulletin.entity.VehicleFamily;
import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.entity.VehicleMaster;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface ServiceExt {
	/*
	 *  GET BY ID
	 */
	
	AdUsers 		getAdUsersById(Object id) 		 throws IllegalArgumentException, Exception;
	DealerRoles 	getDealerRolesById(Object id) 	 throws IllegalArgumentException, Exception;
	Dealers 		getDealersById(Object id) 		 throws IllegalArgumentException, Exception;
	Department 		getDepartmentById(Object id) 	 throws IllegalArgumentException, Exception;
	GeoAreas 		getAGeoAreasById(Object id) 	 throws IllegalArgumentException, Exception;
	GeoCountries 	getGeoCountriesById(Object id) 	 throws IllegalArgumentException, Exception;
	GeoRegions 		getGeoRegionsById(Object id) 	 throws IllegalArgumentException, Exception;
	TechAreaDept 	getTechAreaDeptById(Object id) 	 throws IllegalArgumentException, Exception;	
	UserDealerRoles getUserDealerRolesById(Object id)throws IllegalArgumentException, Exception;
	VehicleFamily 	getVehicleFamilyById(Object id)  throws IllegalArgumentException, Exception;
	VehicleGroups 	getVehicleGroupsById(Object id)  throws IllegalArgumentException, Exception;
	VehicleMaster 	getVehicleMasterById(Object id)  throws IllegalArgumentException, Exception;
	
	/*
	 *  GET ALL
	 */
	
	List<AdUsers> 		 getAdUsersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		throws IllegalArgumentException, Exception;
	List<DealerRoles> 	 getDealerRolesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	throws IllegalArgumentException, Exception;
	List<Dealers> 		 getDealersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		throws IllegalArgumentException, Exception;
	List<Department> 	 getDepartmentAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		throws IllegalArgumentException, Exception;
	List<GeoAreas> 		 getGeoAreasAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		throws IllegalArgumentException, Exception;
	List<GeoCountries> 	 getGeoCountriesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn)	throws IllegalArgumentException, Exception;
	List<GeoRegions> 	 getGeoRegionsAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		throws IllegalArgumentException, Exception;
	List<TechAreaDept> 	 getTechAreaDeptAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn)	throws IllegalArgumentException, Exception;
	List<UserDealerRoles>getUserDealerRolesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	List<VehicleFamily>  getVehicleFamilyAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	throws IllegalArgumentException, Exception;
	List<VehicleGroups>  getVehicleGroupsAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	throws IllegalArgumentException, Exception;
	List<VehicleMaster>  getVehicleMasterAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	throws IllegalArgumentException, Exception;

	/*
	 *  COUNT
	 */
	
	Long countAdUsers() 		throws Exception;
	Long countDealerRoles() 	throws Exception;
	Long countDealers() 		throws Exception;
	Long countDepartment() 		throws Exception;
	Long countGeoAreas() 		throws Exception;
	Long countGeoCountries() 	throws Exception;
	Long countGeoRegions() 		throws Exception;
	Long countTechAreaDept() 	throws Exception;	
	Long countUserDealerRoles() throws Exception;
	Long countVehicleFamily() 	throws Exception;
	Long countVehicleGroups() 	throws Exception;
	Long countVehicleMaster() 	throws Exception;
	
	Long countVehicleFamily	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countVehicleGroups	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countVehicleMaster	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countAdUsers		 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countDealerRoles	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countDealers		 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countDepartment	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countGeoAreas		 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countGeoCountries	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countGeoRegions	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countTechAreaDept	 (HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countUserDealerRoles(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	/*
	 *  SEARCH
	 */
	
	List<AdUsers> 		 searchAdUsers		  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<DealerRoles> 	 searchDealerRoles	  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<Dealers> 		 searchDealers		  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<Department> 	 searchDepartment	  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<GeoAreas> 		 searchGeoAreas		  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<GeoCountries> 	 searchGeoCountries	  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<GeoRegions> 	 searchGeoRegions	  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<TechAreaDept> 	 searchTechAreaDept	  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<UserDealerRoles>searchUserDealerRoles(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<VehicleFamily>  searchVehicleFamily  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<VehicleGroups>  searchVehicleGroups  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<VehicleMaster>  searchVehicleMaster  (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
}