package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.repository.impl.VehicleGroupsRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VehicleGroupsTest {
	private VehicleGroupsRepositoryImpl vehicleGroupsRep = new VehicleGroupsRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static VehicleGroups vehicleGroupsAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			vehicleGroupsAdd = new VehicleGroups();
			vehicleGroupsAdd.setId(99999l+i);
			vehicleGroupsAdd.setUserIns("testADD"+i);
			vehicleGroupsAdd.setDateIns(new Date());
			vehicleGroupsAdd.setDescription("testDescription"+i);
			vehicleGroupsAdd.setActive(true);
			em.persist(vehicleGroupsAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(VehicleGroups.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void vehicleGroupsFetchById(){
		try {
			VehicleGroups bull = vehicleGroupsRep.getById(99999l);
			assertNotNull("No VehicleGroups returned from fetchById", bull);
			assertTrue("vehicleGroupsFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getDescription()+" "
					+ "Expected value: testDescription0", bull.getDescription().equals("testDescription0"));
			
			bull= vehicleGroupsRep.getById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			fail("Caught Exception in vehicleGroupsFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void vehicleGroupsFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<VehicleGroups> bullList = vehicleGroupsRep.getAll(0, 20, cdMap);
			assertTrue("vehicleGroupsFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("vehicleGroupsFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) > 0){
					fail("vehicleGroupsFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in vehicleGroupsFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<VehicleGroups> bullList = vehicleGroupsRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) < 0){
					fail("vehicleGroupsFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in vehicleGroupsFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<VehicleGroups> bullList = vehicleGroupsRep.getAll(0, 17, cdMap);
			assertTrue("vehicleGroupsFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in vehicleGroupsFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void vehicleGroupsCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = vehicleGroupsRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("vehicleGroupsCount method failed. Number of VehicleGroups expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("vehicleGroupsCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = vehicleGroupsRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("vehicleGroupsCount method failed. Number of VehicleGroups expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("vehicleGroupsCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = vehicleGroupsRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue(" Number of VehicleGroups expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("vehicleGroupsCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void vehicleGroupsSearch(){
		List<VehicleGroups> vehicleGroupsList = new ArrayList<VehicleGroups>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			vehicleGroupsList = vehicleGroupsRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("vehicleGroupsSearch method failed. Expected List of VehicleGroups size: 20 Actual: "+vehicleGroupsList.size(),vehicleGroupsList.size() == 20);
			
			for(int index = 0; index < vehicleGroupsList.size() - 1; index++){
				assertTrue("vehicleGroupsSearch method failed on asc order check. Id at index "+index+": "+vehicleGroupsList.get(index).getId()+" next: "+vehicleGroupsList.get(index+1).getId(),
						vehicleGroupsList.get(index).getId().compareTo(vehicleGroupsList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("vehicleGroupsSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			vehicleGroupsList = vehicleGroupsRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("vehicleGroupsSearch method failed. Expected List of VehicleGroups size: 20 Actual: "+vehicleGroupsList.size(),vehicleGroupsList.size() == 20);
			
			for(int index = 0; index < vehicleGroupsList.size() - 1; index++){
				assertTrue("vehicleGroupsSearch method failed on desc order check. Id at index "+index+": "+vehicleGroupsList.get(index).getId()+" next: "+vehicleGroupsList.get(index+1).getId(),
						vehicleGroupsList.get(index).getId().compareTo(vehicleGroupsList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("vehicleGroupsSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("description", "testDescription0");
		
		try{
			vehicleGroupsList = vehicleGroupsRep.search(0, 20, null, map, null, null, null);
			assertTrue("vehicleGroupsSearch method failed. Expected List of VehicleGroups size: 1 Actual: "+vehicleGroupsList.size(),vehicleGroupsList.size() == 1);
		} catch (Exception e){
			fail("vehicleGroupsSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("description", "testDescription");

		try{
			vehicleGroupsList = vehicleGroupsRep.search(0, 20, null, null, map, null, null);
			assertTrue("vehicleGroupsSearch method failed. Expected List of VehicleGroups size: 20 Actual: "+vehicleGroupsList.size(),vehicleGroupsList.size() == 20);
		} catch (Exception e){
			fail("vehicleGroupsSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}
