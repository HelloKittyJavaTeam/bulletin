package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.Tag;
import it.hellokitty.gt.repository.impl.TagRepositoryImpl;

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


public class TagTest {
	private TagRepositoryImpl tagRep = new TagRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static Tag tagAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			tagAdd = new Tag();
			tagAdd.setId(99999l+i);
			tagAdd.setCreateDate(new Date());
			tagAdd.setUserCreated("testADD"+i);
			tagAdd.setWord("word"+i);
			tagAdd.setActive(true);
			em.persist(tagAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(Tag.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void tagFetchById(){
		try {
			Tag bull = tagRep.fetchById(99999l);
			assertNotNull("No Tag returned from fetchById", bull);
			assertTrue("tagFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getWord()+" "
					+ "Expected value: CONTENUTOTEST 0", bull.getWord().equals("word0"));
			
			bull= tagRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in tagFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void tagFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<Tag> bullList = tagRep.fetchAll(0, 20, cdMap);
			assertTrue("tagFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("tagFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("tagFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in tagFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Tag> bullList = tagRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("tagFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in tagFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Tag> bullList = tagRep.fetchAll(0, 17, cdMap);
			assertTrue("tagFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in tagFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  INSERT TEST
	 */
	@Test
	public void tagInsert(){
		Tag bullToAdd = new Tag();
		bullToAdd.setId(98989898l);

		try{
			tagRep.insert(bullToAdd, "testADD");
			assertNotNull(em.find(Tag.class, 98989898l));
		} catch (Exception e){
			fail("tagInsert method failed. Unexpected Exception catched. "+e.getMessage());
		}
		
		em.remove(em.find(Tag.class, 98989898l));
	}
	
	/*
	 *  MERGE TEST
	 */
	@Test
	public void tagMerge(){
		Tag bullToMerge = new Tag();
		bullToMerge = em.find(Tag.class, 99999l);
		bullToMerge.setWord("wordMERGE");
		
		try{
			tagRep.merge(bullToMerge, "testMERGE");
			bullToMerge = em.find(Tag.class, 99999l);
			assertTrue("tagMerge method failed. Word value wrong or not updated. "
					+ "Current value: "+bullToMerge.getWord()+" "
					+ "Expected value: wordMERGE.",bullToMerge.getWord().equals("wordMERGE"));
			assertTrue("tagMerge method failed. UserUpdate value not updated."
					+ "Current value: "+bullToMerge.getUserUpdate()+" "
					+ "Expected value: testMERGE.", bullToMerge.getUserUpdate().equals("testMERGE"));
		} catch (Exception e){
			fail("tagMerge method failed. Unexpected Exception catched. "+e.toString());
		}
		
		try{
			bullToMerge = new Tag();
			bullToMerge.setId(9898989898l);
			bullToMerge.setUserCreated("test");
			bullToMerge.setWord("wordMERGE");
			tagRep.merge(bullToMerge, "testMERGE");
			assertNotNull("tagMerge method fail. No element added.", em.find(Tag.class, 9898989898l));
		} catch (Exception e){
			fail("tagMErge method fail during merge on inexistent tag. Unexpected exception catched. "+e.toString());
		}
		em.remove(em.find(Tag.class, 9898989898l));
	}
	
	/*
	 *  DELETE TEST
	 */
	@Test
	public void tagDelete(){
		Tag bullToDelete = new Tag();
		bullToDelete = em.find(Tag.class, 99999l);
		
		try {
			tagRep.delete(bullToDelete, "testDELETE");
			bullToDelete = em.find(Tag.class, 99999l);
			assertFalse("tagDelete method failed. Tag not disactivated.", bullToDelete.isActive());
		} catch (Exception e){
			fail("tagDelete method failed with user=\"\". Unexpected Exception catched. "+e.getMessage());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void tagCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userCreated", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = tagRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("tagCount method failed. Number of Tag expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("tagCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADDUNKNOW");
		
		try{
			result = tagRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("tagCount method failed. Number of Tag expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("tagCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userCreated", "testADD");
		
		try{
			result = tagRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("tagCount method with user parameter = 'unknowUser' failed. Number of Tag expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("tagCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void tagSearch(){
		List<Tag> tagList = new ArrayList<Tag>();
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", "asc");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			tagList = tagRep.search(0, 20, map, emptyMap, emptyMap, emptyMap, emptyMap);
			assertTrue("tagSearch method failed. Expected List of Tag size: 1 Actual: "+tagList.size(),tagList.size() >= 1);
		} catch (Exception e){
			fail("tagSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}