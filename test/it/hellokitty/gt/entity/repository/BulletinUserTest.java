package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.BulletinUser;
import it.hellokitty.gt.repository.impl.BulletinUserRepositoryImpl;

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


public class BulletinUserTest {
	private BulletinUserRepositoryImpl bulletinUserRep = new BulletinUserRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static BulletinUser bulletinUserAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			bulletinUserAdd = new BulletinUser();
			bulletinUserAdd.setId(99999l+i);
			bulletinUserAdd.setCreateDate(new Date());
			bulletinUserAdd.setUserCreated("testADD"+i);
			bulletinUserAdd.setnRead(989898l+i);
			bulletinUserAdd.setActive(true);
			em.persist(bulletinUserAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(BulletinUser.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void bulletinUserFetchById(){
		try {
			BulletinUser bull = bulletinUserRep.fetchById(99999l);
			assertNotNull("No BulletinUser returned from fetchById", bull);
			assertTrue("bulletinUserFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getnRead()+" "
					+ "Expected value: CONTENUTOTEST 0", bull.getnRead() == 989898);
			
			bull= bulletinUserRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in bulletinUserFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void bulletinUserFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<BulletinUser> bullList = bulletinUserRep.fetchAll(0, 20, cdMap);
			assertTrue("bulletinUserFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("bulletinUserFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("bulletinUserFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in bulletinUserFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<BulletinUser> bullList = bulletinUserRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("bulletinUserFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in bulletinUserFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<BulletinUser> bullList = bulletinUserRep.fetchAll(0, 17, cdMap);
			assertTrue("bulletinUserFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in bulletinUserFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void bulletinUserInsert(){
		BulletinUser bullToAdd = new BulletinUser();
		bullToAdd.setId(98989898l);

		try{
			bulletinUserRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(BulletinUser.class, 98989898l));
		} catch (Exception e){
			fail("bulletinUserInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(BulletinUser.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void bulletinUserMerge(){
		BulletinUser bullToMerge = new BulletinUser();
		bullToMerge = em.find(BulletinUser.class, 99999l);
		bullToMerge.setnRead(989898l);;
		
		try{
			bulletinUserRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(BulletinUser.class, 99999l);
			assertTrue("bulletinUserMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getnRead()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getnRead() == 989898);
			assertTrue("bulletinUserMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("bulletinUserMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new BulletinUser();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setnRead(989898l);;
			bulletinUserRep.merge(bullToMerge, "testMERGE");
			assertNotNull("bulletinUserMerge method fail. No element added.", em.find(BulletinUser.class, 9898989898l));
		} catch (Exception e){
			fail("bulletinUserMErge method fail during merge on inexistent bulletinUser. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(BulletinUser.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void bulletinUserDelete(){
		BulletinUser bullToDelete = new BulletinUser();
		bullToDelete = em.find(BulletinUser.class, 99999l);
		
		try {
			bulletinUserRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(BulletinUser.class, 99999l);
			assertFalse("bulletinUserDelete method failed. BulletinUser not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("bulletinUserDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void bulletinUserCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = bulletinUserRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("bulletinUserCount method failed. Number of BulletinUser expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("bulletinUserCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = bulletinUserRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("bulletinUserCount method failed. Number of BulletinUser expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("bulletinUserCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = bulletinUserRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("bulletinUserCount method with user parameter = 'unknowUser' failed. Number of BulletinUser expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("bulletinUserCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void bulletinUserSearch(){
		List<BulletinUser> bulletinUserList = new ArrayList<BulletinUser>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			bulletinUserList = bulletinUserRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("bulletinUserSearch method failed. Expected List of BulletinUser size: 20 Actual: "+bulletinUserList.size(),bulletinUserList.size() == 20);
			
			for(int index = 0; index < bulletinUserList.size() - 1; index++){
				assertTrue("bulletinUserSearch method failed on asc order check. Id at index "+index+": "+bulletinUserList.get(index).getId()+" next: "+bulletinUserList.get(index+1).getId(),
						bulletinUserList.get(index).getId() < bulletinUserList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("bulletinUserSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			bulletinUserList = bulletinUserRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("bulletinUserSearch method failed. Expected List of BulletinUser size: 20 Actual: "+bulletinUserList.size(),bulletinUserList.size() == 20);
			
			for(int index = 0; index < bulletinUserList.size() - 1; index++){
				assertTrue("bulletinUserSearch method failed on desc order check. Id at index "+index+": "+bulletinUserList.get(index).getId()+" next: "+bulletinUserList.get(index+1).getId(),
						bulletinUserList.get(index).getId() > bulletinUserList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("bulletinUserSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("nRead", 989898l);
		
		try{
			bulletinUserList = bulletinUserRep.search(0, 20, null, map, null, null, null);
			assertTrue("bulletinUserSearch method failed. Expected List of BulletinUser size: 1 Actual: "+bulletinUserList.size(),bulletinUserList.size() == 1);
		} catch (Exception e){
			fail("bulletinUserSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("nRead", 989l);

		try{
			bulletinUserList = bulletinUserRep.search(0, 20, null, null, map, null, null);
			assertTrue("bulletinUserSearch method failed. Expected List of BulletinUser size: 20 Actual: "+bulletinUserList.size(),bulletinUserList.size() == 20);
		} catch (Exception e){
			fail("bulletinUserSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			bulletinUserList = bulletinUserRep.search(0, 20, null, null, null, map, null);
			for(BulletinUser bulletinUser : bulletinUserList){
				if(bulletinUser.getId() < 100){
					fail("bulletinUserSearch method failed on lowerEqual check. Id found: "+bulletinUser.getId());
				}
			}
		} catch (Exception e){
			fail("bulletinUserSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			bulletinUserList = bulletinUserRep.search(0, 20, null, null, null, null, map);
			for(BulletinUser bulletinUser : bulletinUserList){
				if(bulletinUser.getId() > 100){
					fail("bulletinUserSearch method failed on greaterEqual check. Id found: "+bulletinUser.getId());
				}
			}
		} catch (Exception e){
			fail("bulletinUserSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}