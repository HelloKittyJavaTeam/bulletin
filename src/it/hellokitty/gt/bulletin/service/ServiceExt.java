package it.hellokitty.gt.bulletin.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.AdUsers;
import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.DealerRoles;
import it.hellokitty.gt.bulletin.entity.Dealers;
import it.hellokitty.gt.bulletin.entity.Department;
import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.entity.GeoAreas;
import it.hellokitty.gt.bulletin.entity.GeoCountries;
import it.hellokitty.gt.bulletin.entity.GeoRegions;
import it.hellokitty.gt.bulletin.entity.MailingList;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.entity.Tag;
import it.hellokitty.gt.bulletin.entity.TechAreaDept;
import it.hellokitty.gt.bulletin.entity.UserDealerRoles;
import it.hellokitty.gt.bulletin.entity.VehicleFamily;
import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.entity.VehicleMaster;

public interface ServiceExt {
	/*
	 *  GET BY ID
	 */
	
	AdUsers getAdUsersById(Object id) throws IllegalArgumentException, Exception;
	
	AttachmentHistory getAttachmentHistoryById(Object id) throws IllegalArgumentException, Exception;

	Attachment getAttachmentById(Object id) throws IllegalArgumentException, Exception;
	 
	Bulletin getBulletinById(Object id) throws IllegalArgumentException, Exception;
	
	BulletinUser getBulletinUserById(Object id) throws IllegalArgumentException, Exception;
	
	DealerRoles getDealerRolesById(Object id) throws IllegalArgumentException, Exception;
	
	Dealers getDealersById(Object id) throws IllegalArgumentException, Exception;
	
	Department getDepartmentById(Object id) throws IllegalArgumentException, Exception;
	
	EmailContact getEmailContactById(Object id) throws IllegalArgumentException, Exception;
	
	GeoAreas getAGeoAreasById(Object id) throws IllegalArgumentException, Exception;
	
	GeoCountries getGeoCountriesById(Object id) throws IllegalArgumentException, Exception;
	
	GeoRegions getGeoRegionsById(Object id) throws IllegalArgumentException, Exception;
	 
	MailingList getMailingListById(Object id) throws IllegalArgumentException, Exception;
	
	RolesAction getRolesActionById(Object id) throws IllegalArgumentException, Exception;
	
	Tag getTagById(Object id) throws IllegalArgumentException, Exception;
	
	TechAreaDept getTechAreaDeptById(Object id) throws IllegalArgumentException, Exception;
	
	UserDealerRoles getUserDealerRolesById(Object id) throws IllegalArgumentException, Exception;
	
	VehicleFamily getVehicleFamilyById(Object id) throws IllegalArgumentException, Exception;
	
	VehicleGroups getVehicleGroupsById(Object id) throws IllegalArgumentException, Exception;
	
	VehicleMaster getVehicleMasterById(Object id) throws IllegalArgumentException, Exception;
	
	/*
	 *  GET ALL
	 */
	
	List<AdUsers> getAllAdUsers() throws Exception;
	
	List<AttachmentHistory> getAllAttachmentHistory() throws Exception;
	
	List<Attachment> getAllAttachment() throws Exception;
	
	List<Bulletin> getAllBulletin() throws Exception;
	
	List<BulletinUser> getAllBulletinUser() throws Exception;
	
	List<DealerRoles> getAllDealerRoles() throws Exception;
	
	List<Dealers> getAllDealers() throws Exception;
	
	List<Department> getAllDepartment() throws Exception;
	
	List<EmailContact> getAllEmailContact() throws Exception;
	
	List<GeoAreas> getAllGeoAreas() throws Exception;
	
	List<GeoCountries> getAllGeoCountries() throws Exception;
	
	List<GeoRegions> getAllGeoRegions() throws Exception;
	
	List<MailingList> getAllMailingList() throws Exception;
	
	List<RolesAction> getAllRolesAction() throws Exception;

	List<Tag> getAllTag() throws Exception;
	
	List<TechAreaDept> getAllTechAreaDept() throws Exception;
	
	List<UserDealerRoles> getAllUserDealerRoles() throws Exception;
	
	List<VehicleFamily> getAllVehicleFamily() throws Exception;

	List<VehicleGroups> getAllVehicleGroups() throws Exception;
	
	List<VehicleMaster> getAllVehicleMaster() throws Exception;
	
	/*
	 *  COUNT
	 */
	
	Long countAdUsers() throws Exception;
	
	Long countAttachmentHistory() throws Exception;

	Long countAttachment() throws Exception;
	 
	Long countBulletin() throws Exception;
	
	Long countBulletinUser() throws Exception;
	
	Long countDealerRoles() throws Exception;
	
	Long countDealers() throws Exception;
	
	Long countDepartment() throws Exception;
	
	Long countEmailContact() throws Exception;
	
	Long countGeoAreas() throws Exception;
	
	Long countGeoCountries() throws Exception;
	
	Long countGeoRegions() throws Exception;
	 
	Long countMailingList() throws Exception;
	
	Long countRolesAction() throws Exception;
	
	Long countTag() throws Exception;
	
	Long countTechAreaDept() throws Exception;
	
	Long countUserDealerRoles() throws Exception;
	
	Long countVehicleFamily() throws Exception;
	
	Long countVehicleGroups() throws Exception;
	
	Long countVehicleMaster() throws Exception;
	
	Long countAdUsers(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countAttachmentHistory(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countAttachment(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countBulletin(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countBulletinUser(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;

	Long countDealerRoles(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countDealers(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countDepartment(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countEmailContact(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countGeoAreas(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countGeoCountries(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countGeoRegions(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countMailingList(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countRolesAction(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countTag(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countTechAreaDept(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countUserDealerRoles(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countVehicleFamily(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countVehicleGroups(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;
	
	Long countVehicleMaster(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception;

	/*
	 *  SEARCH
	 */
	
	List<AdUsers> searchAdUsers(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<AttachmentHistory> searchAttachmentHistory(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Attachment> searchAttachment(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Bulletin> searchBulletin(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<BulletinUser> searchBulletinUser(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<DealerRoles> searchDealerRoles(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Dealers> searchDealers(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Department> searchDepartment(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<EmailContact> searchEmailContact(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<GeoAreas> searchGeoAreas(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<GeoCountries> searchGeoCountries(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<GeoRegions> searchGeoRegions(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<MailingList> searchMailingList(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<RolesAction> searchRolesAction(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Tag> searchTag(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<TechAreaDept> searchTechAreaDept(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<UserDealerRoles> searchUserDealerRoles(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<VehicleFamily> searchVehicleFamily(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<VehicleGroups> searchVehicleGroups(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<VehicleMaster> searchVehicleMaster(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
}
