package it.hellokitty.gt.bulletin.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
import it.hellokitty.gt.bulletin.repository.impl.AdUsersRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.DealerRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.DealerRolesRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.DepartmentRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.GeoAreasRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.GeoCountriesRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.GeoRegionsRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.TechAreaDeptRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.UserDealerRolesRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.VehicleFamilyRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.VehicleGroupsRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.VehicleMasterRepositoryImpl;
import it.hellokitty.gt.bulletin.service.ServiceExt;

public class ServiceExtImpl implements ServiceExt{
	private AdUsersRepositoryImpl 		  adUsersRepository 		= new AdUsersRepositoryImpl();
	private DealerRepositoryImpl 		  dealersRepository 		= new DealerRepositoryImpl();
	private DealerRolesRepositoryImpl 	  dealersRolesRepository	= new DealerRolesRepositoryImpl();
	private DepartmentRepositoryImpl 	  departmentRepository 		= new DepartmentRepositoryImpl();
	private GeoAreasRepositoryImpl 		  geoAreasRepository 		= new GeoAreasRepositoryImpl();
	private GeoCountriesRepositoryImpl 	  geoCountriesRepository 	= new GeoCountriesRepositoryImpl();
	private GeoRegionsRepositoryImpl 	  geoRegionsRepository 		= new GeoRegionsRepositoryImpl();
	private TechAreaDeptRepositoryImpl 	  techAreaDeptRepository	= new TechAreaDeptRepositoryImpl();
	private UserDealerRolesRepositoryImpl userDealerRolesRepository = new UserDealerRolesRepositoryImpl();
	private VehicleFamilyRepositoryImpl   vehicleFamilyRepository   = new VehicleFamilyRepositoryImpl();
	private VehicleGroupsRepositoryImpl   vehicleGroupsRepository   = new VehicleGroupsRepositoryImpl();
	private VehicleMasterRepositoryImpl   vehicleMasterRepository  = new VehicleMasterRepositoryImpl();
	
	private static ServiceExtImpl ferrariExtServiceImpl = null;
	
	private ServiceExtImpl(){}
	
	public static ServiceExtImpl getInstance(){
		if(ferrariExtServiceImpl == null){
			ferrariExtServiceImpl = new ServiceExtImpl();
		}
		return ferrariExtServiceImpl;
	}

	/*
	 * GET BY ID
	 */
	
	@Override
	public AdUsers getAdUsersById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return adUsersRepository.getById(id);
	}

	@Override
	public DealerRoles getDealerRolesById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return dealersRolesRepository.getById(id);
	}

	@Override
	public Dealers getDealersById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return dealersRepository.getById(id);
	}

	@Override
	public Department getDepartmentById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return departmentRepository.getById(id);
	}

	@Override
	public GeoAreas getAGeoAreasById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return geoAreasRepository.getById(id);
	}

	@Override
	public GeoCountries getGeoCountriesById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return geoCountriesRepository.getById(id);
	}

	@Override
	public GeoRegions getGeoRegionsById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return geoRegionsRepository.getById(id);
	}

	@Override
	public TechAreaDept getTechAreaDeptById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return techAreaDeptRepository.getById(id);
	}

	@Override
	public UserDealerRoles getUserDealerRolesById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null");
		}
		return userDealerRolesRepository.getById(id);
	}
	
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
	public List<AdUsers> getAdUsersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return adUsersRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<DealerRoles> getDealerRolesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return dealersRolesRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Dealers> getDealersAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return dealersRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Department> getDepartmentAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return departmentRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<GeoAreas> getGeoAreasAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return geoAreasRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<GeoCountries> getGeoCountriesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return geoCountriesRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<GeoRegions> getGeoRegionsAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return geoRegionsRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<TechAreaDept> getTechAreaDeptAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return techAreaDeptRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<UserDealerRoles> getUserDealerRolesAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		return userDealerRolesRepository.getAll(start, limit, orderColumn);
	}
	
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
	public Long countAdUsers() throws Exception {
		return adUsersRepository.count();
	}

	@Override
	public Long countDealerRoles() throws Exception {
		return dealersRolesRepository.count();
	}

	@Override
	public Long countDealers() throws Exception {
		return dealersRepository.count();
	}

	@Override
	public Long countDepartment() throws Exception {
		return departmentRepository.count();
	}

	@Override
	public Long countGeoAreas() throws Exception {
		return geoAreasRepository.count();
	}

	@Override
	public Long countGeoCountries() throws Exception {
		return geoCountriesRepository.count();
	}

	@Override
	public Long countGeoRegions() throws Exception {
		return geoRegionsRepository.count();
	}

	@Override
	public Long countTechAreaDept() throws Exception {
		return techAreaDeptRepository.count();
	}

	@Override
	public Long countUserDealerRoles() throws Exception {
		return userDealerRolesRepository.count();
	}
	
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
	public Long countAdUsers(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return adUsersRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countDealerRoles(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return dealersRolesRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countDealers(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return dealersRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countDepartment(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return departmentRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countGeoAreas(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return geoAreasRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countGeoCountries(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return geoCountriesRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countGeoRegions(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return geoRegionsRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countTechAreaDept(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return techAreaDeptRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countUserDealerRoles(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return userDealerRolesRepository.count(paramEquals, paramLike, paramGE, paramLE);
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
	public List<AdUsers> searchAdUsers(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return adUsersRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<DealerRoles> searchDealerRoles(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return dealersRolesRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Dealers> searchDealers(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return dealersRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Department> searchDepartment(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return departmentRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoAreas> searchGeoAreas(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return geoAreasRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoCountries> searchGeoCountries(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return geoCountriesRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<GeoRegions> searchGeoRegions(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return geoRegionsRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<TechAreaDept> searchTechAreaDept(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return techAreaDeptRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<UserDealerRoles> searchUserDealerRoles(Integer start,
			Integer limit, LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" limit parameter can't be null.");
		}
		
		return userDealerRolesRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
	
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
