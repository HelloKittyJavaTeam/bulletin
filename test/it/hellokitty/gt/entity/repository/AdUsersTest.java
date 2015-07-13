package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.AdUsers;
import it.hellokitty.gt.repository.impl.AdUsersRepositoryImpl;

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


public class AdUsersTest {
	private AdUsersRepositoryImpl adUsersRep = new AdUsersRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static AdUsers adUsersAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			adUsersAdd = new AdUsers();
			adUsersAdd.setId(99999l+i);
			adUsersAdd.setUserIns("testADD"+i);
			adUsersAdd.setDateIns(new Date());
			adUsersAdd.setEmail("emailTEST"+i);
			adUsersAdd.setActive(true);
			em.persist(adUsersAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			adUsersAdd = new AdUsers();
			em.remove(em.find(AdUsers.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void adUsersFetchById(){
		try {
			AdUsers bull = adUsersRep.fetchById(99999l);
			assertNotNull("No AdUsers returned from fetchById", bull);
			assertTrue("adUsersFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getEmail()+" "
					+ "Expected value: emailTEST0", bull.getEmail().equals("emailTEST0"));
			
			bull= adUsersRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in adUsersFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void adUsersFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<AdUsers> bullList = adUsersRep.fetchAll(0, 20, cdMap);
			assertTrue("adUsersFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("adUsersFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("adUsersFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in adUsersFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<AdUsers> bullList = adUsersRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("adUsersFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in adUsersFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<AdUsers> bullList = adUsersRep.fetchAll(0, 17, cdMap);
			assertTrue("adUsersFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in adUsersFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void adUsersCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = adUsersRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("adUsersCount method failed. Number of AdUsers expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("adUsersCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = adUsersRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("adUsersCount method failed. Number of AdUsers expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("adUsersCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = adUsersRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("adUsersCount method with user parameter = 'unknowUser' failed. Number of AdUsers expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("adUsersCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void adUsersSearch(){
		List<AdUsers> adUsersList = new ArrayList<AdUsers>();
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", "asc");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			adUsersList = adUsersRep.search(0, 20, map, emptyMap, emptyMap, emptyMap, emptyMap);
			assertTrue("adUsersSearch method failed. Expected List of AdUsers size: 1 Actual: "+adUsersList.size(),adUsersList.size() >= 1);
		} catch (Exception e){
			fail("adUsersSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}