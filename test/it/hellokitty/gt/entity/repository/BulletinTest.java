package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.Tag;
import it.hellokitty.gt.bulletin.repository.impl.BulletinRepositoryImpl;

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


public class BulletinTest {
	private BulletinRepositoryImpl bulletinRep = new BulletinRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static Bulletin bulletinAdd;
	private static BulletinUser bulletinUserAdd;
	private static Tag tagAdd;
	private static List<BulletinUser> bulletinUserAddList = new ArrayList<BulletinUser>();
	private static List<Tag> tagAddList = new ArrayList<Tag>();

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			bulletinAdd = new Bulletin();
			tagAdd  = new Tag("testTAG"+i);
			bulletinUserAdd = new BulletinUser();
			bulletinUserAdd.setUserCreate("testADD");
			bulletinUserAdd.setUserName("user"+i);
			bulletinUserAddList = new ArrayList<BulletinUser>();
			bulletinUserAddList.add(bulletinUserAdd);
			tagAdd.setUserCreate("testUSER"+i);
			tagAddList = new ArrayList<Tag>();
			tagAddList.add(tagAdd);
			bulletinAdd.setId(99999l+i);
			bulletinAdd.setUserCreate("testADD"+i);
			bulletinAdd.setCreateDate(new Date());
			bulletinAdd.setContentIt("CONTENUTOTEST "+i);
			bulletinAdd.setActive(true);
			bulletinAdd.setTags(tagAddList);
			bulletinAdd.setBulletinUsers(bulletinUserAddList);
			em.persist(bulletinAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(Bulletin.class, 99999l+i));

		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void bulletinFetchById(){
		try {
			Bulletin bull = bulletinRep.getById(99999l);
			assertNotNull("No Bulletin returned from fetchById", bull);
			assertTrue("bulletinFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getContentIt()+" "
					+ "Expected value: CONTENUTOTEST 0", bull.getContentIt().equals("CONTENUTOTEST 0"));
			
			bull= bulletinRep.getById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in bulletinFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void bulletinFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<Bulletin> bullList = bulletinRep.getAll(0, 20, cdMap);
			assertTrue("bulletinFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("bulletinFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("bulletinFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in bulletinFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Bulletin> bullList = bulletinRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("bulletinFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in bulletinFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Bulletin> bullList = bulletinRep.getAll(0, 17, cdMap);
			assertTrue("bulletinFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in bulletinFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void bulletinInsert(){
		Bulletin bullToAdd = new Bulletin();
		bullToAdd.setId(98989898l);

		try{
			bulletinRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(Bulletin.class, 98989898l));
		} catch (Exception e){
			fail("bulletinInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(Bulletin.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void bulletinMerge(){
		Bulletin bullToMerge = new Bulletin();
		bullToMerge = em.find(Bulletin.class, 99999l);
		bullToMerge.setContentIt("CONTENUTO TEST ITA");
		
		try{
			bulletinRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(Bulletin.class, 99999l);
			assertTrue("bulletinMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getTitleIt()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getContentIt().equals("CONTENUTO TEST ITA"));
			assertTrue("bulletinMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("bulletinMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new Bulletin();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreate("test");
			bullToMerge.setContentIt("CONTENUTO TEST ITA");
			bulletinRep.merge(bullToMerge, "testMERGE");
			assertNotNull("bulletinMerge method fail. No element added.", em.find(Bulletin.class, 9898989898l));
		} catch (Exception e){
			fail("bulletinMErge method fail during merge on inexistent bulletin. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Bulletin.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void bulletinDelete(){
		Bulletin bullToDelete = new Bulletin();
		bullToDelete = em.find(Bulletin.class, 99999l);
		
		try {
			bulletinRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(Bulletin.class, 99999l);
			assertFalse("bulletinDelete method failed. Bulletin not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("bulletinDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void bulletinCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreate", "testADD0");
		
		try{
			result = bulletinRep.count(map, null, null, null);
			assertTrue("bulletinCount method failed. Number of Bulletin expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("bulletinCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreate", "testADDUNKNOW");
		
		try{
			result = bulletinRep.count(map, null, null, null);
			assertTrue("bulletinCount method failed. Number of Bulletin expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("bulletinCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreate", "testADD");
		
		try{
			result = bulletinRep.count(null, map, null, null);
			assertTrue("bulletinCount method with user parameter = 'unknowUser' failed. Number of Bulletin expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("bulletinCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void bulletinSearch(){
		List<Bulletin> bulletinList = new ArrayList<Bulletin>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			bulletinList = bulletinRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("bulletinSearch method failed. Expected List of Bulletin size: 20 Actual: "+bulletinList.size(),bulletinList.size() == 20);
			
			for(int index = 0; index < bulletinList.size() - 1; index++){
				assertTrue("bulletinSearch method failed on asc order check. Id at index "+index+": "+bulletinList.get(index).getId()+" next: "+bulletinList.get(index+1).getId(),
						bulletinList.get(index).getId() < bulletinList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			bulletinList = bulletinRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("bulletinSearch method failed. Expected List of Bulletin size: 20 Actual: "+bulletinList.size(),bulletinList.size() == 20);
			
			for(int index = 0; index < bulletinList.size() - 1; index++){
				assertTrue("bulletinSearch method failed on desc order check. Id at index "+index+": "+bulletinList.get(index).getId()+" next: "+bulletinList.get(index+1).getId(),
						bulletinList.get(index).getId() > bulletinList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tag", "testTAG0");
		
		try{
			bulletinList = bulletinRep.search(0, 20, null, map, null, null, null);
			assertTrue("bulletinSearch method failed. Expected List of Bulletin size: 1 Actual: "+bulletinList.size(),bulletinList.size() == 1);
		} catch (Exception e){
			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("tag", "testTAG");
		
		try{
			bulletinList = bulletinRep.search(0, 20, null, null, map, null, null);
			assertTrue("bulletinSearch method failed. Expected List of Bulletin size: 20 Actual: "+bulletinList.size(),bulletinList.size() == 20);
		} catch (Exception e){
			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			bulletinList = bulletinRep.search(0, 20, null, null, null, map, null);
			for(Bulletin bulletin : bulletinList){
				if(bulletin.getId() < 100){
					fail("bulletinSearch method failed on lowerEqual check. Id found: "+bulletin.getId());
				}
			}
		} catch (Exception e){
			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			bulletinList = bulletinRep.search(0, 20, null, null, null, null, map);
			for(Bulletin bulletin : bulletinList){
				if(bulletin.getId() > 100){
					fail("bulletinSearch method failed on greaterEqual check. Id found: "+bulletin.getId());
				}
			}
		} catch (Exception e){
			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}