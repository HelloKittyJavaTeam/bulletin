package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.Attachment;
import it.hellokitty.gt.repository.impl.AttachmentRepositoryImpl;

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


public class AttachmentTest {
	private AttachmentRepositoryImpl attachmentRep = new AttachmentRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static Attachment attachmentAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			attachmentAdd = new Attachment();
			attachmentAdd.setId(99999l+i);
			attachmentAdd.setUserCreated("testADD"+i);
			attachmentAdd.setCreateDate(new Date());
			attachmentAdd.setFileName("NAMETEST "+i);
			attachmentAdd.setActive(true);
			em.persist(attachmentAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			attachmentAdd = new Attachment();
			attachmentAdd.setId(99999l+i);
			em.remove(em.find(Attachment.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void attachmentFetchById(){
		try {
			Attachment bull = attachmentRep.fetchById(99999l);
			assertNotNull("No Attachment returned from fetchById", bull);
			assertTrue("attachmentFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getFileName()+" "
					+ "Expected value: NAMETEST 0", bull.getFileName().equals("NAMETEST 0"));
			bull= attachmentRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in attachmentFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void attachmentFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<Attachment> bullList = attachmentRep.fetchAll(0, 20, cdMap);
			assertTrue("attachmentFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("attachmentFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("attachmentFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in attachmentFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Attachment> bullList = attachmentRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("attachmentFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in attachmentFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Attachment> bullList = attachmentRep.fetchAll(0, 17, cdMap);
			assertTrue("attachmentFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in attachmentFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void attachmentInsert(){
		Attachment bullToAdd = new Attachment();
		bullToAdd.setId(98989898l);

		try{
			attachmentRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(Attachment.class, 98989898l));
		} catch (Exception e){
			fail("attachmentInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(Attachment.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void attachmentMerge(){
		Attachment bullToMerge = new Attachment();
		bullToMerge = em.find(Attachment.class, 99999l);
		bullToMerge.setFileName("NAME TEST");
		
		try{
			attachmentRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(Attachment.class, 99999l);
			assertTrue("attachmentMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getFileName()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getFileName().equals("NAME TEST"));
			assertTrue("attachmentMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("attachmentMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new Attachment();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setFileName("NAME TEST");
			attachmentRep.merge(bullToMerge, "testMERGE");
			assertNotNull("attachmentMerge method fail. No element added.", em.find(Attachment.class, 9898989898l));
		} catch (Exception e){
			fail("attachmentMErge method fail during merge on inexistent attachment. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Attachment.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void attachmentDelete(){
		Attachment bullToDelete = new Attachment();
		bullToDelete = em.find(Attachment.class, 99999l);
		
		try {
			attachmentRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(Attachment.class, 99999l);
			assertFalse("attachmentDelete method failed. Attachment not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("attachmentDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void attachmentCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = attachmentRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("attachmentCount method failed. Number of Attachment expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("attachmentCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = attachmentRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("attachmentCount method failed. Number of Attachment expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("attachmentCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = attachmentRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("attachmentCount method with user parameter = 'unknowUser' failed. Number of Attachment expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("attachmentCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void attachmentSearch(){
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", "asc");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			attachmentList = attachmentRep.search(0, 20, map, emptyMap, emptyMap, emptyMap, emptyMap);
			assertTrue("attachmentSearch method failed. Expected List of Attachment size: 1 Actual: "+attachmentList.size(),attachmentList.size() >= 1);
		} catch (Exception e){
			fail("attachmentSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}