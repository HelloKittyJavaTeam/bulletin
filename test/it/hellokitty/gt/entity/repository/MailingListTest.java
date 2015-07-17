package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.MailingList;
import it.hellokitty.gt.bulletin.repository.impl.MailingListRepositoryImpl;

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


public class MailingListTest {
	private MailingListRepositoryImpl mailingListRep = new MailingListRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static MailingList mailingListAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			mailingListAdd = new MailingList();
			mailingListAdd.setId(99999l+i);
			mailingListAdd.setCreateDate(new Date());
			mailingListAdd.setUserCreate("testADD"+i);
			mailingListAdd.setName("name"+i);
			mailingListAdd.setActive(true);
			em.persist(mailingListAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(MailingList.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void mailingListFetchById(){
		try {
			MailingList bull = mailingListRep.getById(99999l);
			assertNotNull("No MailingList returned from fetchById", bull);
			assertTrue("mailingListFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getName()+" "
					+ "Expected value: CONTENUTOTEST 0", bull.getName().equals("name0"));
			
			bull= mailingListRep.getById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in mailingListFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void mailingListFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<MailingList> bullList = mailingListRep.getAll(0, 20, cdMap);
			assertTrue("mailingListFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("mailingListFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("mailingListFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in mailingListFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<MailingList> bullList = mailingListRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("mailingListFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in mailingListFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<MailingList> bullList = mailingListRep.getAll(0, 17, cdMap);
			assertTrue("mailingListFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in mailingListFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void mailingListInsert(){
		MailingList bullToAdd = new MailingList();
		bullToAdd.setId(98989898l);

		try{
			mailingListRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(MailingList.class, 98989898l));
		} catch (Exception e){
			fail("mailingListInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(MailingList.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void mailingListMerge(){
		MailingList bullToMerge = new MailingList();
		bullToMerge = em.find(MailingList.class, 99999l);
		bullToMerge.setName("nameMERGE");;
		
		try{
			mailingListRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(MailingList.class, 99999l);
			assertTrue("mailingListMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getName()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getName().equals("nameMERGE"));
			assertTrue("mailingListMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("mailingListMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new MailingList();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreate("test");
			bullToMerge.setName("nameMERGE");
			mailingListRep.merge(bullToMerge, "testMERGE");
			assertNotNull("mailingListMerge method fail. No element added.", em.find(MailingList.class, 9898989898l));
		} catch (Exception e){
			fail("mailingListMErge method fail during merge on inexistent mailingList. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(MailingList.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void mailingListDelete(){
		MailingList bullToDelete = new MailingList();
		bullToDelete = em.find(MailingList.class, 99999l);
		
		try {
			mailingListRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(MailingList.class, 99999l);
			assertFalse("mailingListDelete method failed. MailingList not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("mailingListDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void mailingListCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreate", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = mailingListRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("mailingListCount method failed. Number of MailingList expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("mailingListCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreate", "testADDUNKNOW");
		
		try{
			result = mailingListRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("mailingListCount method failed. Number of MailingList expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("mailingListCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreate", "testADD");
		
		try{
			result = mailingListRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("mailingListCount method with user parameter = 'unknowUser' failed. Number of MailingList expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("mailingListCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void mailingListSearch(){
		List<MailingList> mailingListList = new ArrayList<MailingList>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			mailingListList = mailingListRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("mailingListSearch method failed. Expected List of MailingList size: 20 Actual: "+mailingListList.size(),mailingListList.size() == 20);
			
			for(int index = 0; index < mailingListList.size() - 1; index++){
				assertTrue("mailingListSearch method failed on asc order check. Id at index "+index+": "+mailingListList.get(index).getId()+" next: "+mailingListList.get(index+1).getId(),
						mailingListList.get(index).getId().compareTo(mailingListList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("mailingListSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			mailingListList = mailingListRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("mailingListSearch method failed. Expected List of MailingList size: 20 Actual: "+mailingListList.size(),mailingListList.size() == 20);
			
			for(int index = 0; index < mailingListList.size() - 1; index++){
				assertTrue("mailingListSearch method failed on desc order check. Id at index "+index+": "+mailingListList.get(index).getId()+" next: "+mailingListList.get(index+1).getId(),
						mailingListList.get(index).getId().compareTo(mailingListList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("mailingListSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "name0");
		
		try{
			mailingListList = mailingListRep.search(0, 20, null, map, null, null, null);
			assertTrue("mailingListSearch method failed. Expected List of MailingList size: 1 Actual: "+mailingListList.size(),mailingListList.size() == 1);
		} catch (Exception e){
			fail("mailingListSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("name", "name");

		try{
			mailingListList = mailingListRep.search(0, 20, null, null, map, null, null);
			assertTrue("mailingListSearch method failed. Expected List of MailingList size: 20 Actual: "+mailingListList.size(),mailingListList.size() == 20);
		} catch (Exception e){
			fail("mailingListSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}