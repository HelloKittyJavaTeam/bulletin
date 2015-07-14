package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.GeoCountries;
import it.hellokitty.gt.repository.impl.GeoCountriesRepositoryImpl;

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


public class GeoCountriesTest {
	private GeoCountriesRepositoryImpl geoCountriesRep = new GeoCountriesRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static GeoCountries geoCountriesAdd;

	@Before
	public void insert10Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 10; i++){
			geoCountriesAdd = new GeoCountries();
			geoCountriesAdd.setId(""+99999l+i);
			geoCountriesAdd.setUserIns("testADD"+i);
			geoCountriesAdd.setDateIns(new Date());
			geoCountriesAdd.setDescriptionEn("testDescription"+i);
			geoCountriesAdd.setActive(true);
			em.persist(geoCountriesAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete10Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 10; i++){
			em.remove(em.find(GeoCountries.class, ""+99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void geoCountriesFetchById(){
		try {
			GeoCountries bull = geoCountriesRep.fetchById(""+999990l);
			assertNotNull("No GeoCountries returned from fetchById", bull);
			assertTrue("geoCountriesFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getDescriptionEn()+" "
					+ "Expected value: testDescription0", bull.getDescriptionEn().equals("testDescription0"));
			
			bull= geoCountriesRep.fetchById(""+987654321l);
			assertNull(bull);
		} catch (Exception e) {
			fail("Caught Exception in geoCountriesFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void geoCountriesFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<GeoCountries> bullList = geoCountriesRep.fetchAll(0, 10, cdMap);
			assertTrue("geoCountriesFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("geoCountriesFetchAll didn't return all the elements.", bullList.size() >= 10);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) > 0){
					fail("geoCountriesFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in geoCountriesFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<GeoCountries> bullList = geoCountriesRep.fetchAll(0, 10, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) < 0){
					fail("geoCountriesFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in geoCountriesFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<GeoCountries> bullList = geoCountriesRep.fetchAll(0, 7, cdMap);
			assertTrue("geoCountriesFetchAll didn't return all the elements.", bullList.size() == 7);
		} catch (Exception e) {
			fail("Caught Exception in geoCountriesFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void geoCountriesCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = geoCountriesRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("geoCountriesCount method failed. Number of GeoCountries expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("geoCountriesCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = geoCountriesRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("geoCountriesCount method failed. Number of GeoCountries expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("geoCountriesCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = geoCountriesRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("geoCountriesCount method with user parameter = 'unknowUser' failed. Number of GeoCountries expected: 10 Actual:"+result, result == 10);
		} catch (Exception e){
			fail("geoCountriesCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void geoCountriesSearch(){
		List<GeoCountries> geoCountriesList = new ArrayList<GeoCountries>();
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", "asc");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			geoCountriesList = geoCountriesRep.search(0, 10, map, emptyMap, emptyMap, emptyMap, emptyMap);
			assertTrue("geoCountriesSearch method failed. Expected List of GeoCountries size: 1 Actual: "+geoCountriesList.size(),geoCountriesList.size() >= 1);
		} catch (Exception e){
			fail("geoCountriesSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}