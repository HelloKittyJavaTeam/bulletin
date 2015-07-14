package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.AttachmentHistory;
import it.hellokitty.gt.repository.impl.AttachmentHistoryRepositoryImpl;

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


public class AttachmentHistoryTest {
	private AttachmentHistoryRepositoryImpl attachmentHistoryRep = new AttachmentHistoryRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static AttachmentHistory attachmentHistoryAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			attachmentHistoryAdd = new AttachmentHistory();
			attachmentHistoryAdd.setId(99999l+i);
			attachmentHistoryAdd.setUserCreated("testADD"+i);
			attachmentHistoryAdd.setCreateDate(new Date());
			attachmentHistoryAdd.setnDownload(989898l);;
			attachmentHistoryAdd.setActive(true);
			em.persist(attachmentHistoryAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(AttachmentHistory.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void attachmentHistoryFetchById(){		
		try {
			AttachmentHistory bull = attachmentHistoryRep.fetchById(99999l);
			assertNotNull("No AttachmentHistory returned from fetchById", bull);
			assertTrue("attachmentHistoryFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getnDownload()+" "
					+ "Expected value: NAMETEST 0", bull.getnDownload() == 989898);
			bull= attachmentHistoryRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in attachmentHistoryFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void attachmentHistoryFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<AttachmentHistory> bullList = attachmentHistoryRep.fetchAll(0, 20, cdMap);
			assertTrue("attachmentHistoryFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("attachmentHistoryFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("attachmentHistoryFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in attachmentHistoryFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<AttachmentHistory> bullList = attachmentHistoryRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("attachmentHistoryFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in attachmentHistoryFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<AttachmentHistory> bullList = attachmentHistoryRep.fetchAll(0, 17, cdMap);
			assertTrue("attachmentHistoryFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in attachmentHistoryFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void attachmentHistoryInsert(){
		AttachmentHistory bullToAdd = new AttachmentHistory();
		bullToAdd.setId(98989898l);

		try{
			attachmentHistoryRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(AttachmentHistory.class, 98989898l));
		} catch (Exception e){
			fail("attachmentHistoryInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(AttachmentHistory.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void attachmentHistoryMerge(){
		AttachmentHistory bullToMerge = new AttachmentHistory();
		bullToMerge = em.find(AttachmentHistory.class, 99999l);
		bullToMerge.setnDownload(989898l);
		
		try{
			attachmentHistoryRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(AttachmentHistory.class, 99999l);
			assertTrue("attachmentHistoryMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getnDownload()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getnDownload()==989898);
			assertTrue("attachmentHistoryMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("attachmentHistoryMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new AttachmentHistory();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setnDownload(989898l);
			attachmentHistoryRep.merge(bullToMerge, "testMERGE");
			assertNotNull("attachmentHistoryMerge method fail. No element added.", em.find(AttachmentHistory.class, 9898989898l));
		} catch (Exception e){
			fail("attachmentHistoryMErge method fail during merge on inexistent attachmentHistory. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(AttachmentHistory.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void attachmentHistoryDelete(){
		AttachmentHistory bullToDelete = new AttachmentHistory();
		bullToDelete = em.find(AttachmentHistory.class, 99999l);
		
		try {
			attachmentHistoryRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(AttachmentHistory.class, 99999l);
			assertFalse("attachmentHistoryDelete method failed. AttachmentHistory not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("attachmentHistoryDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void attachmentHistoryCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = attachmentHistoryRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("attachmentHistoryCount method failed. Number of AttachmentHistory expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("attachmentHistoryCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = attachmentHistoryRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("attachmentHistoryCount method failed. Number of AttachmentHistory expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("attachmentHistoryCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = attachmentHistoryRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("attachmentHistoryCount method with user parameter = 'unknowUser' failed. Number of AttachmentHistory expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("attachmentHistoryCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void attachmentHistorySearch(){
		List<AttachmentHistory> attachmentHistoryList = new ArrayList<AttachmentHistory>();
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", "asc");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			attachmentHistoryList = attachmentHistoryRep.search(0, 20, map, emptyMap, emptyMap, emptyMap, emptyMap);
			assertTrue("attachmentHistorySearch method failed. Expected List of AttachmentHistory size: 1 Actual: "+attachmentHistoryList.size(),attachmentHistoryList.size() >= 1);
		} catch (Exception e){
			fail("attachmentHistorySearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}