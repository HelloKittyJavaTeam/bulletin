package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.repository.impl.RolesActionRepositoryImpl;

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


public class RolesActionTest {
	private RolesActionRepositoryImpl rolesActionRep = new RolesActionRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static RolesAction rolesActionAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			rolesActionAdd = new RolesAction();
			rolesActionAdd.setId(99999l+i);
			rolesActionAdd.setCreateDate(new Date());
			rolesActionAdd.setUserCreated("testADD"+i);
			rolesActionAdd.setRoles("roles"+i);
			rolesActionAdd.setActive(true);
			em.persist(rolesActionAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(RolesAction.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void rolesActionFetchById(){
		try {
			RolesAction bull = rolesActionRep.fetchById(99999l);
			assertNotNull("No RolesAction returned from fetchById", bull);
			assertTrue("rolesActionFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getRoles()+" "
					+ "Expected value: roles0", bull.getRoles().equals("roles0"));
			
			bull= rolesActionRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in rolesActionFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void rolesActionFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<RolesAction> bullList = rolesActionRep.fetchAll(0, 20, cdMap);
			assertTrue("rolesActionFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("rolesActionFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("rolesActionFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in rolesActionFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<RolesAction> bullList = rolesActionRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("rolesActionFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in rolesActionFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<RolesAction> bullList = rolesActionRep.fetchAll(0, 17, cdMap);
			assertTrue("rolesActionFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in rolesActionFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void rolesActionInsert(){
		RolesAction bullToAdd = new RolesAction();
		bullToAdd.setId(98989898l);

		try{
			rolesActionRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(RolesAction.class, 98989898l));
		} catch (Exception e){
			fail("rolesActionInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(RolesAction.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void rolesActionMerge(){
		RolesAction bullToMerge = new RolesAction();
		bullToMerge = em.find(RolesAction.class, 99999l);
		bullToMerge.setRoles("rolesMERGE");;
		
		try{
			rolesActionRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(RolesAction.class, 99999l);
			assertTrue("rolesActionMerge method failed. Word value wrong or not updated. "
					+ "Current value: "+bullToMerge.getRoles()+" "
					+ "Expected value: wordMERGE.",bullToMerge.getRoles().equals("rolesMERGE"));
			assertTrue("rolesActionMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("rolesActionMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new RolesAction();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setRoles("rolesMERGE");;
			rolesActionRep.merge(bullToMerge, "testMERGE");
			assertNotNull("rolesActionMerge method fail. No element added.", em.find(RolesAction.class, 9898989898l));
		} catch (Exception e){
			fail("rolesActionMErge method fail during merge on inexistent rolesAction. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(RolesAction.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void rolesActionDelete(){
		RolesAction bullToDelete = new RolesAction();
		bullToDelete = em.find(RolesAction.class, 99999l);
		
		try {
			rolesActionRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(RolesAction.class, 99999l);
			assertFalse("rolesActionDelete method failed. RolesAction not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("rolesActionDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void rolesActionCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = rolesActionRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("rolesActionCount method failed. Number of RolesAction expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("rolesActionCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = rolesActionRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("rolesActionCount method failed. Number of RolesAction expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("rolesActionCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = rolesActionRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("rolesActionCount method with user parameter = 'unknowUser' failed. Number of RolesAction expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("rolesActionCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void rolesActionSearch(){
		List<RolesAction> rolesActionList = new ArrayList<RolesAction>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			rolesActionList = rolesActionRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("rolesActionSearch method failed. Expected List of RolesAction size: 20 Actual: "+rolesActionList.size(),rolesActionList.size() == 20);
			
			for(int index = 0; index < rolesActionList.size() - 1; index++){
				assertTrue("rolesActionSearch method failed on asc order check. Id at index "+index+": "+rolesActionList.get(index).getId()+" next: "+rolesActionList.get(index+1).getId(),
						rolesActionList.get(index).getId().compareTo(rolesActionList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("rolesActionSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			rolesActionList = rolesActionRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("rolesActionSearch method failed. Expected List of RolesAction size: 20 Actual: "+rolesActionList.size(),rolesActionList.size() == 20);
			
			for(int index = 0; index < rolesActionList.size() - 1; index++){
				assertTrue("rolesActionSearch method failed on desc order check. Id at index "+index+": "+rolesActionList.get(index).getId()+" next: "+rolesActionList.get(index+1).getId(),
						rolesActionList.get(index).getId().compareTo(rolesActionList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("rolesActionSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roles", "roles0");
		
		try{
			rolesActionList = rolesActionRep.search(0, 20, null, map, null, null, null);
			assertTrue("rolesActionSearch method failed. Expected List of RolesAction size: 1 Actual: "+rolesActionList.size(),rolesActionList.size() == 1);
		} catch (Exception e){
			fail("rolesActionSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("roles", "roles");

		try{
			rolesActionList = rolesActionRep.search(0, 20, null, null, map, null, null);
			assertTrue("rolesActionSearch method failed. Expected List of RolesAction size: 20 Actual: "+rolesActionList.size(),rolesActionList.size() == 20);
		} catch (Exception e){
			fail("rolesActionSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}