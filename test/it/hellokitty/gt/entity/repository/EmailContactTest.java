package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.repository.impl.EmailContactRepositoryImpl;

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


public class EmailContactTest {
	private EmailContactRepositoryImpl emailContactRep = new EmailContactRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static EmailContact emailContactAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			emailContactAdd = new EmailContact();
			emailContactAdd.setId(99999l+i);
			emailContactAdd.setCreateDate(new Date());
			emailContactAdd.setUserCreate("testADD"+i);
			emailContactAdd.setName("name"+i);
			emailContactAdd.setActive(true);
			em.persist(emailContactAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(EmailContact.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void emailContactFetchById(){
		try {
			EmailContact bull = emailContactRep.fetchById(99999l);
			assertNotNull("No EmailContact returned from fetchById", bull);
			assertTrue("emailContactFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getName()+" "
					+ "Expected value: name0", bull.getName().equals("name0"));
			
			bull= emailContactRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in emailContactFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void emailContactFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<EmailContact> bullList = emailContactRep.fetchAll(0, 20, cdMap);
			assertTrue("emailContactFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("emailContactFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("emailContactFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in emailContactFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<EmailContact> bullList = emailContactRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("emailContactFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in emailContactFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<EmailContact> bullList = emailContactRep.fetchAll(0, 17, cdMap);
			assertTrue("emailContactFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in emailContactFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void emailContactInsert(){
		EmailContact bullToAdd = new EmailContact();
		bullToAdd.setId(98989898l);

		try{
			emailContactRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(EmailContact.class, 98989898l));
		} catch (Exception e){
			fail("emailContactInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(EmailContact.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void emailContactMerge(){
		EmailContact bullToMerge = new EmailContact();
		bullToMerge = em.find(EmailContact.class, 99999l);
		bullToMerge.setName("nameMERGE");;
		
		try{
			emailContactRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(EmailContact.class, 99999l);
			assertTrue("emailContactMErge method failed. ItContent value wrong or not updated. "
					+ "Current value: "+bullToMerge.getName()+" "
					+ "Expected value: CONTENUTO TEST ITA.",bullToMerge.getName().equals("nameMERGE"));
			assertTrue("emailContactMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("emailContactMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new EmailContact();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreate("test");
			bullToMerge.setName("nameMERGE");
			emailContactRep.merge(bullToMerge, "testMERGE");
			assertNotNull("emailContactMerge method fail. No element added.", em.find(EmailContact.class, 9898989898l));
		} catch (Exception e){
			fail("emailContactMErge method fail during merge on inexistent emailContact. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(EmailContact.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void emailContactDelete(){
		EmailContact bullToDelete = new EmailContact();
		bullToDelete = em.find(EmailContact.class, 99999l);
		
		try {
			emailContactRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(EmailContact.class, 99999l);
			assertFalse("emailContactDelete method failed. EmailContact not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("emailContactDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void emailContactCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreate", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = emailContactRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("emailContactCount method failed. Number of EmailContact expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("emailContactCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreate", "testADDUNKNOW");
		
		try{
			result = emailContactRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("emailContactCount method failed. Number of EmailContact expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("emailContactCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreate", "testADD");
		
		try{
			result = emailContactRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("emailContactCount method with user parameter = 'unknowUser' failed. Number of EmailContact expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("emailContactCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void emailContactSearch(){
		List<EmailContact> emailContactList = new ArrayList<EmailContact>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			emailContactList = emailContactRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("emailContactSearch method failed. Expected List of EmailContact size: 20 Actual: "+emailContactList.size(),emailContactList.size() == 20);
			
			for(int index = 0; index < emailContactList.size() - 1; index++){
				assertTrue("emailContactSearch method failed on asc order check. Id at index "+index+": "+emailContactList.get(index).getId()+" next: "+emailContactList.get(index+1).getId(),
						emailContactList.get(index).getId().compareTo(emailContactList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("emailContactSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			emailContactList = emailContactRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("emailContactSearch method failed. Expected List of EmailContact size: 20 Actual: "+emailContactList.size(),emailContactList.size() == 20);
			
			for(int index = 0; index < emailContactList.size() - 1; index++){
				assertTrue("emailContactSearch method failed on desc order check. Id at index "+index+": "+emailContactList.get(index).getId()+" next: "+emailContactList.get(index+1).getId(),
						emailContactList.get(index).getId().compareTo(emailContactList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("emailContactSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "name0");
		
		try{
			emailContactList = emailContactRep.search(0, 20, null, map, null, null, null);
			assertTrue("emailContactSearch method failed. Expected List of EmailContact size: 1 Actual: "+emailContactList.size(),emailContactList.size() == 1);
		} catch (Exception e){
			fail("emailContactSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("name", "name");

		try{
			emailContactList = emailContactRep.search(0, 20, null, null, map, null, null);
			assertTrue("emailContactSearch method failed. Expected List of EmailContact size: 20 Actual: "+emailContactList.size(),emailContactList.size() == 20);
		} catch (Exception e){
			fail("emailContactSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}