package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.UserDealerRoles;
import it.hellokitty.gt.bulletin.repository.impl.UserDealerRolesRepositoryImpl;

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


public class UserDealerRoleTest {
	private UserDealerRolesRepositoryImpl userDealerRolesRep = new UserDealerRolesRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static UserDealerRoles userDealerRolesAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			userDealerRolesAdd = new UserDealerRoles();
			userDealerRolesAdd.setId(99999l+i);
			userDealerRolesAdd.setUserIns("testADD"+i);
			userDealerRolesAdd.setDateIns(new Date());
			userDealerRolesAdd.setLanguage("languageTEST"+i);
			userDealerRolesAdd.setActive(true);
			em.persist(userDealerRolesAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(UserDealerRoles.class, 99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void userDealerRolesFetchById(){
		try {
			UserDealerRoles bull = userDealerRolesRep.fetchById(99999l);
			assertNotNull("No UserDealerRoles returned from fetchById", bull);
			assertTrue("userDealerRolesFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getLanguage()+" "
					+ "Expected value: emailTEST0", bull.getLanguage().equals("languageTEST0"));
			
			bull= userDealerRolesRep.fetchById(987654321l);
			assertNull(bull);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Caught Exception in userDealerRolesFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void userDealerRolesFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<UserDealerRoles> bullList = userDealerRolesRep.fetchAll(0, 20, cdMap);
			assertTrue("userDealerRolesFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("userDealerRolesFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() > bullList.get(index+1).getId()){
					fail("userDealerRolesFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in userDealerRolesFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<UserDealerRoles> bullList = userDealerRolesRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId() < bullList.get(index+1).getId()){
					fail("userDealerRolesFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in userDealerRolesFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<UserDealerRoles> bullList = userDealerRolesRep.fetchAll(0, 17, cdMap);
			assertTrue("userDealerRolesFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in userDealerRolesFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void userDealerRolesCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = userDealerRolesRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("userDealerRolesCount method failed. Number of UserDealerRoles expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("userDealerRolesCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = userDealerRolesRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("userDealerRolesCount method failed. Number of UserDealerRoles expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("userDealerRolesCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = userDealerRolesRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("userDealerRolesCount method with user parameter = 'unknowUser' failed. Number of UserDealerRoles expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("userDealerRolesCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void userDealerRolesSearch(){
		List<UserDealerRoles> userDealerRolesList = new ArrayList<UserDealerRoles>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			userDealerRolesList = userDealerRolesRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("userDealerRolesSearch method failed. Expected List of UserDealerRoles size: 20 Actual: "+userDealerRolesList.size(),userDealerRolesList.size() == 20);
			
			for(int index = 0; index < userDealerRolesList.size() - 1; index++){
				assertTrue("userDealerRolesSearch method failed on asc order check. Id at index "+index+": "+userDealerRolesList.get(index).getId()+" next: "+userDealerRolesList.get(index+1).getId(),
						userDealerRolesList.get(index).getId() < userDealerRolesList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("userDealerRolesSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			userDealerRolesList = userDealerRolesRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("userDealerRolesSearch method failed. Expected List of UserDealerRoles size: 20 Actual: "+userDealerRolesList.size(),userDealerRolesList.size() == 20);
			
			for(int index = 0; index < userDealerRolesList.size() - 1; index++){
				assertTrue("userDealerRolesSearch method failed on desc order check. Id at index "+index+": "+userDealerRolesList.get(index).getId()+" next: "+userDealerRolesList.get(index+1).getId(),
						userDealerRolesList.get(index).getId() > userDealerRolesList.get(index+1).getId());
			}
		} catch (Exception e){
			fail("userDealerRolesSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("email", "emailTEST0");
		
		try{
			userDealerRolesList = userDealerRolesRep.search(0, 20, null, map, null, null, null);
			assertTrue("userDealerRolesSearch method failed. Expected List of UserDealerRoles size: 1 Actual: "+userDealerRolesList.size(),userDealerRolesList.size() == 1);
		} catch (Exception e){
			fail("userDealerRolesSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("email", "emailTEST");

		try{
			userDealerRolesList = userDealerRolesRep.search(0, 20, null, null, map, null, null);
			assertTrue("userDealerRolesSearch method failed. Expected List of UserDealerRoles size: 20 Actual: "+userDealerRolesList.size(),userDealerRolesList.size() == 20);
		} catch (Exception e){
			fail("userDealerRolesSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			userDealerRolesList = userDealerRolesRep.search(0, 20, null, null, null, map, null);
			for(UserDealerRoles userDealerRoles : userDealerRolesList){
				if(userDealerRoles.getId() < 100){
					fail("userDealerRolesSearch method failed on lowerEqual check. Id found: "+userDealerRoles.getId());
				}
			}
		} catch (Exception e){
			fail("userDealerRolesSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("id", 100l);
		
		try{
			userDealerRolesList = userDealerRolesRep.search(0, 20, null, null, null, null, map);
			for(UserDealerRoles userDealerRoles : userDealerRolesList){
				if(userDealerRoles.getId() > 100){
					fail("userDealerRolesSearch method failed on greaterEqual check. Id found: "+userDealerRoles.getId());
				}
			}
		} catch (Exception e){
			fail("userDealerRolesSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}