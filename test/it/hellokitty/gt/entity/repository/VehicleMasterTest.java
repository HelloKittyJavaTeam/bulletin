package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.VehicleMaster;
import it.hellokitty.gt.bulletin.repository.impl.VehicleMasterRepositoryImpl;

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

public class VehicleMasterTest {
	private VehicleMasterRepositoryImpl vehicleMasterRep = new VehicleMasterRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static VehicleMaster vehicleMasterAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			vehicleMasterAdd = new VehicleMaster();
			vehicleMasterAdd.setId(99999l+i);
			vehicleMasterAdd.setUserIns("testADD"+i);
			vehicleMasterAdd.setDateIns(new Date());
			vehicleMasterAdd.setDescription("testDescription"+i);
			vehicleMasterAdd.setActive(true);
			em.persist(vehicleMasterAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(VehicleMaster.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void vehicleMasterFetchById(){
		try {
			VehicleMaster bull = vehicleMasterRep.getById(99999l);
			assertNotNull("No VehicleMaster returned from fetchById", bull);
			assertTrue("vehicleMasterFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getDescription()+" "
					+ "Expected value: testDescription0", bull.getDescription().equals("testDescription0"));
			
			bull= vehicleMasterRep.getById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			fail("Caught Exception in vehicleMasterFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void vehicleMasterFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<VehicleMaster> bullList = vehicleMasterRep.getAll(0, 20, cdMap);
			assertTrue("vehicleMasterFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("vehicleMasterFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) > 0){
					fail("vehicleMasterFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in vehicleMasterFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<VehicleMaster> bullList = vehicleMasterRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) < 0){
					fail("vehicleMasterFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in vehicleMasterFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<VehicleMaster> bullList = vehicleMasterRep.getAll(0, 17, cdMap);
			assertTrue("vehicleMasterFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in vehicleMasterFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void vehicleMasterCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = vehicleMasterRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("vehicleMasterCount method failed. Number of VehicleMaster expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("vehicleMasterCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = vehicleMasterRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("vehicleMasterCount method failed. Number of VehicleMaster expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("vehicleMasterCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = vehicleMasterRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue(" Number of VehicleMaster expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("vehicleMasterCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void vehicleMasterSearch(){
		List<VehicleMaster> vehicleMasterList = new ArrayList<VehicleMaster>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			vehicleMasterList = vehicleMasterRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("vehicleMasterSearch method failed. Expected List of VehicleMaster size: 20 Actual: "+vehicleMasterList.size(),vehicleMasterList.size() == 20);
			
			for(int index = 0; index < vehicleMasterList.size() - 1; index++){
				assertTrue("vehicleMasterSearch method failed on asc order check. Id at index "+index+": "+vehicleMasterList.get(index).getId()+" next: "+vehicleMasterList.get(index+1).getId(),
						vehicleMasterList.get(index).getId().compareTo(vehicleMasterList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("vehicleMasterSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			vehicleMasterList = vehicleMasterRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("vehicleMasterSearch method failed. Expected List of VehicleMaster size: 20 Actual: "+vehicleMasterList.size(),vehicleMasterList.size() == 20);
			
			for(int index = 0; index < vehicleMasterList.size() - 1; index++){
				assertTrue("vehicleMasterSearch method failed on desc order check. Id at index "+index+": "+vehicleMasterList.get(index).getId()+" next: "+vehicleMasterList.get(index+1).getId(),
						vehicleMasterList.get(index).getId().compareTo(vehicleMasterList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("vehicleMasterSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("description", "testDescription0");
		
		try{
			vehicleMasterList = vehicleMasterRep.search(0, 20, null, map, null, null, null);
			assertTrue("vehicleMasterSearch method failed. Expected List of VehicleMaster size: 1 Actual: "+vehicleMasterList.size(),vehicleMasterList.size() == 1);
		} catch (Exception e){
			fail("vehicleMasterSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("description", "testDescription");

		try{
			vehicleMasterList = vehicleMasterRep.search(0, 20, null, null, map, null, null);
			assertTrue("vehicleMasterSearch method failed. Expected List of VehicleMaster size: 20 Actual: "+vehicleMasterList.size(),vehicleMasterList.size() == 20);
		} catch (Exception e){
			fail("vehicleMasterSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}
