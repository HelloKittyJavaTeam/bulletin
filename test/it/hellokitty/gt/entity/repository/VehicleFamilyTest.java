package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.VehicleFamily;
import it.hellokitty.gt.bulletin.repository.impl.VehicleFamilyRepositoryImpl;

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

public class VehicleFamilyTest {
	private VehicleFamilyRepositoryImpl vehicleFamilyRep = new VehicleFamilyRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static VehicleFamily vehicleFamilyAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			vehicleFamilyAdd = new VehicleFamily();
			vehicleFamilyAdd.setId(""+99999l+i);
			vehicleFamilyAdd.setUserIns("testADD"+i);
			vehicleFamilyAdd.setDateIns(new Date());
			vehicleFamilyAdd.setDescription("testDescription"+i);
			vehicleFamilyAdd.setActive(true);
			em.persist(vehicleFamilyAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(VehicleFamily.class, ""+99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void vehicleFamilyFetchById(){
		try {
			VehicleFamily bull = vehicleFamilyRep.fetchById(""+999990l);
			assertNotNull("No VehicleFamily returned from fetchById", bull);
			assertTrue("vehicleFamilyFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getDescription()+" "
					+ "Expected value: testDescription0", bull.getDescription().equals("testDescription0"));
			
			bull= vehicleFamilyRep.fetchById(""+987654321l);
			assertNull(bull);
		} catch (Exception e) {
			fail("Caught Exception in vehicleFamilyFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void vehicleFamilyFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<VehicleFamily> bullList = vehicleFamilyRep.fetchAll(0, 20, cdMap);
			assertTrue("vehicleFamilyFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("vehicleFamilyFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) > 0){
					fail("vehicleFamilyFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in vehicleFamilyFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<VehicleFamily> bullList = vehicleFamilyRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) < 0){
					fail("vehicleFamilyFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in vehicleFamilyFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<VehicleFamily> bullList = vehicleFamilyRep.fetchAll(0, 17, cdMap);
			assertTrue("vehicleFamilyFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in vehicleFamilyFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void vehicleFamilyCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = vehicleFamilyRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("vehicleFamilyCount method failed. Number of VehicleFamily expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("vehicleFamilyCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = vehicleFamilyRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("vehicleFamilyCount method failed. Number of VehicleFamily expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("vehicleFamilyCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = vehicleFamilyRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue(" Number of VehicleFamily expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("vehicleFamilyCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void vehicleFamilySearch(){
		List<VehicleFamily> vehicleFamilyList = new ArrayList<VehicleFamily>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			vehicleFamilyList = vehicleFamilyRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("vehicleFamilySearch method failed. Expected List of VehicleFamily size: 20 Actual: "+vehicleFamilyList.size(),vehicleFamilyList.size() == 20);
			
			for(int index = 0; index < vehicleFamilyList.size() - 1; index++){
				assertTrue("vehicleFamilySearch method failed on asc order check. Id at index "+index+": "+vehicleFamilyList.get(index).getId()+" next: "+vehicleFamilyList.get(index+1).getId(),
						vehicleFamilyList.get(index).getId().compareTo(vehicleFamilyList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("vehicleFamilySearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			vehicleFamilyList = vehicleFamilyRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("vehicleFamilySearch method failed. Expected List of VehicleFamily size: 20 Actual: "+vehicleFamilyList.size(),vehicleFamilyList.size() == 20);
			
			for(int index = 0; index < vehicleFamilyList.size() - 1; index++){
				assertTrue("vehicleFamilySearch method failed on desc order check. Id at index "+index+": "+vehicleFamilyList.get(index).getId()+" next: "+vehicleFamilyList.get(index+1).getId(),
						vehicleFamilyList.get(index).getId().compareTo(vehicleFamilyList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("vehicleFamilySearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("description", "testDescription0");
		
		try{
			vehicleFamilyList = vehicleFamilyRep.search(0, 20, null, map, null, null, null);
			assertTrue("vehicleFamilySearch method failed. Expected List of VehicleFamily size: 1 Actual: "+vehicleFamilyList.size(),vehicleFamilyList.size() == 1);
		} catch (Exception e){
			fail("vehicleFamilySearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("description", "testDescription");

		try{
			vehicleFamilyList = vehicleFamilyRep.search(0, 20, null, null, map, null, null);
			assertTrue("vehicleFamilySearch method failed. Expected List of VehicleFamily size: 20 Actual: "+vehicleFamilyList.size(),vehicleFamilyList.size() == 20);
		} catch (Exception e){
			fail("vehicleFamilySearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}
