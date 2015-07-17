package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.Dealers;
import it.hellokitty.gt.bulletin.repository.impl.DealerRepositoryImpl;

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


public class DealersTest {
	private DealerRepositoryImpl dealersRep = new DealerRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static Dealers dealersAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			dealersAdd = new Dealers();
			dealersAdd.setId(""+99999l+i);
			dealersAdd.setUserIns("testADD"+i);
			dealersAdd.setDateIns(new Date());
			dealersAdd.setEmail("emailTEST"+i);
			dealersAdd.setActive(true);
			em.persist(dealersAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(Dealers.class, ""+99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void dealersFetchById(){
		try {
			Dealers bull = dealersRep.getById(""+999990l);
			assertNotNull("No Dealers returned from fetchById", bull);
			assertTrue("dealersFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getEmail()+" "
					+ "Expected value: emailTEST0", bull.getEmail().equals("emailTEST0"));
			
			bull= dealersRep.getById(""+987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in dealersFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void dealersFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<Dealers> dealersList = dealersRep.getAll(0, 20, cdMap);
			assertTrue("dealersFetchAll returned a empty list.", dealersList.size() > 0);
			assertTrue("dealersFetchAll didn't return all the elements.", dealersList.size() >= 20);
			for(int index = 0; index < dealersList.size()-1; index++){
				if(dealersList.get(index).getId().compareTo(dealersList.get(index+1).getId())>0){
					fail("dealersFetchAll method failed during asc order check. Id at index "+index+":"+dealersList.get(index).getId()+" next: "+index+":"+dealersList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in dealersFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Dealers> bullList = dealersRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId())<0){
					fail("dealersFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in dealersFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<Dealers> bullList = dealersRep.getAll(0, 17, cdMap);
			assertTrue("dealersFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in dealersFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void dealersCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = dealersRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("dealersCount method failed. Number of Dealers expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("dealersCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = dealersRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("dealersCount method failed. Number of Dealers expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("dealersCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = dealersRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("dealersCount method with user parameter = 'unknowUser' failed. Number of Dealers expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("dealersCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void dealersSearch(){
		List<Dealers> dealersList = new ArrayList<Dealers>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			dealersList = dealersRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("dealersSearch method failed. Expected List of Dealers size: 20 Actual: "+dealersList.size(),dealersList.size() == 20);
			
			for(int index = 0; index < dealersList.size() - 1; index++){
				assertTrue("dealersSearch method failed on asc order check. Id at index "+index+": "+dealersList.get(index).getId()+" next: "+dealersList.get(index+1).getId(),
						dealersList.get(index).getId().compareTo(dealersList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("dealersSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			dealersList = dealersRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("dealersSearch method failed. Expected List of Dealers size: 20 Actual: "+dealersList.size(),dealersList.size() == 20);
			
			for(int index = 0; index < dealersList.size() - 1; index++){
				assertTrue("dealersSearch method failed on desc order check. Id at index "+index+": "+dealersList.get(index).getId()+" next: "+dealersList.get(index+1).getId(),
						dealersList.get(index).getId().compareTo(dealersList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("dealersSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", "emailTEST0");
		
		try{
			dealersList = dealersRep.search(0, 20, null, map, null, null, null);
			assertTrue("dealersSearch method failed. Expected List of Dealers size: 1 Actual: "+dealersList.size(),dealersList.size() == 1);
		} catch (Exception e){
			fail("dealersSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("email", "emailTEST");

		try{
			dealersList = dealersRep.search(0, 20, null, null, map, null, null);
			assertTrue("dealersSearch method failed. Expected List of Dealers size: 20 Actual: "+dealersList.size(),dealersList.size() == 20);
		} catch (Exception e){
			fail("dealersSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}