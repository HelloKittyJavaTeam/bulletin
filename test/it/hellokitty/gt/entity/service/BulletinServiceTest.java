//package it.hellokitty.gt.entity.service;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//import it.hellokitty.gt.bulletin.entity.Bulletin;
//import it.hellokitty.gt.bulletin.entity.BulletinUser;
//import it.hellokitty.gt.bulletin.entity.Tag;
//import it.hellokitty.gt.bulletin.service.impl.BulletinServiceImpl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class BulletinServiceTest {
//	private BulletinServiceImpl bulletinSerImpl = BulletinServiceImpl.getInstance();
//	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
//	private static Bulletin bullAdd;
//	private static BulletinUser bullUserAdd;
//	private static Tag tagAdd;
//	private static List<BulletinUser> bullUserAddList = new ArrayList<BulletinUser>();
//	private static List<Tag> tagAddList = new ArrayList<Tag>();
//	private static LinkedHashMap<String, String> cdList = new LinkedHashMap<String, String>();
//
//	@Before
//	public void insert20Elements() {
//		EntityTransaction transaction = em.getTransaction();
//		
//		transaction.begin();
//		for(int i = 0; i < 20; i++){
//			bullAdd = new Bulletin();
//			tagAdd  = new Tag("testTAG"+i);
//			bullUserAdd = new BulletinUser();
//			bullUserAdd.setUserCreate("testADD");
//			bullUserAdd.setUserName("user"+i);
//			bullUserAddList = new ArrayList<BulletinUser>();
//			bullUserAddList.add(bullUserAdd);
//			tagAdd.setUserCreate("testUSER"+i);
//			tagAddList = new ArrayList<Tag>();
//			tagAddList.add(tagAdd);
//			bullAdd.setId(99999l+i);
//			bullAdd.setUserCreate("testADD"+i);
//			bullAdd.setCreateDate(new Date());
//			bullAdd.setContentIt("CONTENUTOTEST "+i);
//			bullAdd.setActive(true);
//			bullAdd.setTags(tagAddList);
//			bullAdd.setBulletinUsers(bullUserAddList);
//			em.persist(bullAdd);
//		}
//		transaction.commit();
//	}
//	
//	@After
//	public void delete20Elements() {
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		for(int i = 0; i < 20; i++){
//			bullAdd = new Bulletin();
//			bullAdd.setId(99999l+i);
//			bullAdd.setUserCreate("testADD"+i);
//			bullAdd.setContentIt("CONTENUTOTEST "+i);
//			em.remove(em.find(Bulletin.class, 99999l+i));
//
//		}
//		transaction.commit();
//	}
//	
//	/*
//	 *  FETCH BY ID TEST
//	 */
//	@Test
//	public void bulletinFetchById(){
//		try{
//			bulletinSerImpl.fetchById(null);
//			fail("bulletinFetchById method with id = null failed. No IllegalArgumentException thrown.");
//		} catch (IllegalArgumentException e){
//			assertTrue(true); // Just for visibility :)
//		} catch (Exception e){
//			fail("bulletinFetchById method with id = null failed. Unexpected exception catched. "+e.toString());
//		}
//		
//		try {
//			Bulletin bull = bulletinSerImpl.fetchById(99999l);
//			assertNotNull("No Bulletin returned from fetchById", bull);
//			assertTrue("bulletinFetchById method failed on retrieve content value. "
//					+ "Actual value: "+bull.getContentIt()+" "
//					+ "Expected value: CONTENUTOTEST 0", bull.getContentIt().equals("CONTENUTOTEST 0"));
//			bull= bulletinSerImpl.fetchById(987654321l);
//			assertNull(bull);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Caught Exception in bulletinFetchById method. "+e.toString());
//		}
//	}
//	
//	@Test
//	public void bulletinFetchAll(){
//		cdList = new LinkedHashMap<String, String>();
//		cdList.put("id", "asc");
//		try{
//			bulletinSerImpl.fetchAll(null, 10, cdList);
//			fail("bulletinFetchAll method with start parameter = null failed. No IllegalArgumentException thrown.");
//		} catch (IllegalArgumentException e){
//			assertTrue(true); // Just for visibility :)
//		} catch (Exception e){
//			fail("bulletinFetchAll method with start parameter = null failed. Unexpected exception catched. "+e.toString());
//		}
//		
//		try{
//			bulletinSerImpl.fetchAll(0, null, cdList);
//			fail("bulletinFetchAll method with limit parameter = null failed. No IllegalArgumentException thrown.");
//		} catch (IllegalArgumentException e){
//			assertTrue(true); // Just for visibility :)
//		} catch (Exception e){
//			fail("bulletinFetchAll method with limit parameter = null failed. Unexpected exception catched. "+e.toString());
//		}
//		
////		try{
////			bulletinSerImpl.fetchAll(0, -1, cdList);
////			fail("bulletinFetchAll method with limit parameter = -1 failed. No IllegalArgumentException thrown.");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchAll method with limit parameter = -1 failed. Unexpected exception catched. "+e.toString());
////		}
//		
////		try{
////			bulletinSerImpl.fetchAll(0, 10, null);
////			fail("bulletinFetchAll method with limit parameter = -1 failed. No IllegalArgumentException thrown.");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchAll method with limit parameter = -1 failed. Unexpected exception catched. "+e.toString());
////		}
//		
//		try {
//			List<Bulletin> bullList = bulletinSerImpl.fetchAll(0, 20, cdList);
//			assertTrue("bulletinFetchAll returned a empty list.", bullList.size() > 0);
//			assertTrue("bulletinFetchAll didn't return all the elements.", bullList.size() >= 20);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("Caught Exception in bulletinFetchById method.");
//		}
//	}
//	
//	/*
//	 *  INSERT TEST
//	 */
//	@Test
//	public void bulletinInsert(){
//		Bulletin bullToAdd = new Bulletin();
//		bullToAdd.setId(98989898l);
//		
////		try{
////			bulletinSerImpl.insert(null, "testADD");
////			fail("bulletinInsert method with elem parameter = null failed. No IllegalArgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinInsert method with elem parmeter = null failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.insert(bullToAdd, null);
////			fail("bulletinInsert method with user parameter = null failed. No IllegalArgumentExcepion thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinInsert method with elem user = null failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.insert(bullToAdd, "");
////			fail("bulletinInsert method with user parameter = '' failed. No IllegalArgumentExcepion thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinInsert method with elem user = '' failed. Unexpected exception catched. "+e.toString());
////		}
//
//		try{
//			bulletinSerImpl.insert(bullToAdd, "testADD");
//			assertNotNull(em.find(Bulletin.class, 98989898l));
//		} catch (Exception e){
//			fail("bulletinInsert method failed. Unexpected Exception catched. "+e.getMessage());
//		}
//		
//		em.remove(em.find(Bulletin.class, 98989898l));
//	}
//	
//	/*
//	 *  MERGE TEST
//	 */
//	@Test
//	public void bulletinMerge(){
//		Bulletin bullToMerge = new Bulletin();
//		bullToMerge = em.find(Bulletin.class, 99999l);
//		bullToMerge.setContentIt("CONTENUTO TEST ITA");
//		
////		try{
////			bulletinSerImpl.merge(null, "testADD");
////			fail("bulletinMerge method with elem parameter = null failed. No IllegalArgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinMerge method with elem parmeter = null failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.merge(bullToMerge, null);
////			fail("bulletinMerge method with user parameter = null failed. No IllegalArgumentExcepion thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinMerge method with elem user = null failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.merge(bullToMerge, "");
////			fail("bulletinMerge method with user parameter = '' failed. No IllegalArgumentExcepion thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinMerge method with elem user = '' failed. Unexpected exception catched. "+e.toString());
////		}
//		
//		try{
//			bulletinSerImpl.merge(bullToMerge, "testMERGE");
//			bullToMerge = em.find(Bulletin.class, 99999l);
//			assertTrue("bulletinMErge method failed. ItContent value wrong or not updated. "
//					+ "Current value: "+bullToMerge.getTitleIt()+" "
//					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getContentIt().equals("CONTENUTO TEST ITA"));
//			assertTrue("bulletinMerge method failed. UserUpdate value not updated."
//					+ "Current value: "+bullToMerge.getUserUpdate()+" "
//					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
//		} catch (Exception e){
//			fail("bulletinMerge method failed. Unexpected Exception catched. "+e.toString());
//		}
//		
//		try{
//			bullToMerge = new Bulletin();
//			bullToMerge.setId(9898989898l);
//			bullToMerge.setUserCreate("test");
//			bullToMerge.setContentIt("CONTENUTO TEST ITA");
//			bulletinSerImpl.merge(bullToMerge, "testMERGE");
//			assertNotNull("bulletinMerge method fail. No element added.", em.find(Bulletin.class, 9898989898l));
//		} catch (Exception e){
//			fail("bulletinMErge method fail during merge on inexistent bulletin. Unexpected exception catched. "+e.toString());
//		}
//		em.remove(em.find(Bulletin.class, 9898989898l));
//	}
//	
//	/*
//	 *  DELETE TEST
//	 */
//	@Test
//	public void bulletinDelete(){
//		Bulletin bullToDelete = new Bulletin();
//		bullToDelete = em.find(Bulletin.class, 99999l);
//		
////		try{
////			bulletinSerImpl.delete(null, "testADD");
////			fail("bulletinDelete method with elem parameter = null failed. No IllegalArgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinDelete method with elem parmeter = null failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.delete(bullToDelete, null);
////			fail("bulletinDelete method with user parameter = null failed. No IllegalArgumentExcepion thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinDelete method with elem user = null failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.delete(bullToDelete, "");
////			fail("bulletinDelete method with user parameter = '' failed. No IllegalArgumentExcepion thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility
////		} catch(Exception e){
////			fail("bulletinDelete method with elem user = '' failed. Unexpected exception catched. "+e.toString());
////		}
//		
//		try {
//			bulletinSerImpl.delete(bullToDelete, "testDELETE");
//			bullToDelete = em.find(Bulletin.class, 99999l);
//			assertFalse("bulletinDelete method failed. Bulletin not disactivated.", bullToDelete.isActive());
//		} catch (Exception e){
//			fail("bulletinDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
//		}
//	}
//
////	/*
////	 *  FETCH BY TAG TEST
////	 */
////	@Test
////	public void bulletinFetchByTag(){
////		List<Bulletin> bulletinList = new ArrayList<Bulletin>();
////		
////		try{
////			bulletinSerImpl.fetchByTag(null, 10, 20, cdList);
////			fail("bulletinFEtchByTag method with tag parameter = null. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTag method with tag parameter = null. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", -1, 20, cdList);
////			fail("bulletinFEtchByTag method with start parameter = -1. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTag method with start parameter = -1. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", 10, -1, cdList);
////			fail("bulletinFEtchByTag method with limit parameter = -1. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTag method with limit parameter = -1. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", 10, 20, null);
////			fail("bulletinFEtchByTag method with tag parameter = null. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTag method with tag parameter = null. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			ColumnDirection cd = new ColumnDirection("id", "asc");
////			List<ColumnDirection> cdList = new ArrayList<ColumnDirection>();
////			cdList.add(cd);
////			bulletinList = bulletinSerImpl.fetchByTag("testTAG0", "user0", 0, 20, cdList);
////			assertTrue("bulletinFetchByTag method failed. Expected list size:1 actual size:"+bulletinList.size(),bulletinList.size()==1);
////			assertTrue(bulletinList.get(0).getTags().get(0).getWord().equals("testTAG0"));
////		} catch(Exception e){
////			fail("bulletinFetchByTag method fail. Unexpected exception catched. "+e.toString());
////		}
////	}
////	
////	/*
////	 * FETCH BY TAG LIKE TEST
////	 */
////	@Test
////	public void bulletinFetchByTagLike(){
////		List<Bulletin> bulletinList = new ArrayList<Bulletin>();
////		
////		ColumnDirection cd = new ColumnDirection("id", "asc");
////		List<ColumnDirection> cdList = new ArrayList<ColumnDirection>();
////		cdList.add(cd);
////
////		try{
////			bulletinSerImpl.fetchByTag(null, 10, 20, cdList);
////			fail("bulletinFetchByTagLike method with tag parameter = null. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTagLike method with tag parameter = null. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", -1, 20, cdList);
////			fail("bulletinFetchByTagLike method with start parameter = -1. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTagLike method with start parameter = -1. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", 1, -2, cdList);
////			fail("bulletinFetchByTagLike method with start parameter = -1. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTagLike method with start parameter = -1. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", 1, -2, cdList);
////			fail("bulletinFetchByTagLike method with start parameter = -1. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTagLike method with start parameter = -1. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinSerImpl.fetchByTag("test", 1, 20, null);
////			fail("bulletinFetchByTagLike method with start parameter = -1. No IllegalARgumentException thrown");
////		} catch (IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch (Exception e){
////			fail("bulletinFetchByTagLike method with start parameter = -1. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByTagLike("testTAG0", "admin", 0, 20, cdList);
////			assertTrue("bulletinFetchByTag method failed. Expected list size:1 actual size:"+bulletinList.size(),bulletinList.size()==1);
////			assertTrue(bulletinList.get(0).getTags().get(0).getWord().equals("testTAG0"));
////		} catch(Exception e){
////			fail("bulletinFetchByTag method fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByTagLike("testTAG", "admin", 0, 20, cdList);
////			assertTrue("bulletinFetchByTag method failed. Expected list size:20 actual size:"+bulletinList.size(),bulletinList.size()==20);
////		} catch(Exception e){
////			fail("bulletinFetchByTag method fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByTagLike("testTAG", "user0", 0, 20, cdList);
////			assertTrue("bulletinFetchByTag method failed. Expected list size:1 actual size:"+bulletinList.size(),bulletinList.size()==1);
////		} catch(Exception e){
////			fail("bulletinFetchByTag method fail. Unexpected exception catched. "+e.toString());
////		}
////	}
////	
////	/*
////	 *  FETCH BY USER TEST
////	 */
////	@Test
////	public void bulletinFetchByUser(){
////		List<Bulletin> bulletinList = new ArrayList<Bulletin>();
////		
////		ColumnDirection cd = new ColumnDirection("id", "asc");
////		List<ColumnDirection> cdList = new ArrayList<ColumnDirection>();
////		cdList.add(cd);
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByUser(null, 0, 20, cdList);
////			fail("bulletinFetchByUser method with user parameter = null failed. No IllegalArgumentException thrown.");
////		} catch(IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch(Exception e){
////			fail("bulletinFetchByTag method with user parameter = null fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByUser("user", -1, 20, cdList);
////			fail("bulletinFetchByUser method with start parameter = -1 failed. No IllegalArgumentException thrown.");
////		} catch(IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch(Exception e){
////			fail("bulletinFetchByTag method with start parameter = -1 fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByUser("user", 1, -1, cdList);
////			fail("bulletinFetchByUser method with limit parameter = -1 failed. No IllegalArgumentException thrown.");
////		} catch(IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch(Exception e){
////			fail("bulletinFetchByTag method with limit parameter = -1 fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByUser("user", 0, 20, null);
////			fail("bulletinFetchByUser method with cdList parameter = null failed. No IllegalArgumentException thrown.");
////		} catch(IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch(Exception e){
////			fail("bulletinFetchByTag method with cdList parameter = null fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByUser("user0", 0, 20, cdList);
////			assertTrue("bulletinFetchByUser method failed. Expected list size:1 actual size:"+bulletinList.size(),bulletinList.size()==1);
////			assertTrue(bulletinList.get(0).getTags().get(0).getWord().equals("testTAG0"));
////		} catch(Exception e){
////			fail("bulletinFetchByUser method failed. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			bulletinList = bulletinSerImpl.fetchByUser("unknowUser", 0, 20, cdList);
////			assertTrue("bulletinFetchByUser method failed. Expected list size:1 actual size:"+bulletinList.size(),bulletinList.size()==0);
////		} catch(Exception e){
////			fail("bulletinFetchByUser method failed. Unexpected exception catched. "+e.toString());
////		}
////	}
//	
//	/*
//	 *  COUNT TEST
//	 */
//	@Test
//	public void bulletinCount(){
//		Long result;
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("userCreated", "testADD0");
//		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
//		
////		try{
////			result = bulletinSerImpl.count(map, emptyMap, emptyMap, emptyMap);;
////			fail("bulletinCount method with user parameter = null failed. No IllegalArgumentException thrown.");
////		} catch(IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch(Exception e){
////			fail("bulletinCount method with user parameter = null fail. Unexpected exception catched. "+e.toString());
////		}
////		
////		try{
////			result = bulletinSerImpl.count(emptyMap, map, emptyMap, emptyMap);;
////			fail("bulletinCount method with user parameter = '' failed. No IllegalArgumentException thrown.");
////		} catch(IllegalArgumentException e){
////			assertTrue(true); // Just for visibility :)
////		} catch(Exception e){
////			fail("bulletinCount method with user parameter = '' fail. Unexpected exception catched. "+e.toString());
////		}
//		
//		try{
//			result = bulletinSerImpl.count(map, null, null, null);
//			assertTrue("bulletinCount method failed. Number of Bulletin expected: 1 Actual:"+result, result==1);
//		} catch (Exception e){
//			fail("bulletinCount method failed. Unexpected exception catched. "+e.toString());
//		}
//		
//		map = new HashMap<String, Object>();
//		map.put("userCreated", "testADDUNKNOW");
//		
//		try{
//			result = bulletinSerImpl.count(map, emptyMap, emptyMap, emptyMap);
//			assertTrue("bulletinCount method with user parameter = 'unknowUser' failed. Number of Bulletin expected: 0 Actual:"+result, result==0);
//		} catch (Exception e){
//			fail("bulletinCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
//		}
//	}
//	
//	/*
//	 *  SEARCH TEST
//	 */
//	@Test
//	public void bulletinSearch(){
//		List<Bulletin> bulletinList = new ArrayList<Bulletin>();
//		
//		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//		map.put("id", "asc");
//		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
//		
//		try{
//			bulletinList = bulletinSerImpl.search(0, 20, map, emptyMap, emptyMap, emptyMap, emptyMap);
//			assertTrue("bulletinSearch method failed. Expected List of Bulletin size: 1 Actual: "+bulletinList.size(),bulletinList.size() >= 1);
//		} catch (Exception e){
//			fail("bulletinSearch method failed. Unexpected exception catched. "+e.toString());
//		}
//	}
//}