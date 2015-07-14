package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.entity.GeoAreas;
import it.hellokitty.gt.repository.impl.GeoAreasRepositoryImpl;

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


public class GeoAreasTest {
	private GeoAreasRepositoryImpl geoAreasRep = new GeoAreasRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static GeoAreas geoAreasAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			geoAreasAdd = new GeoAreas();
			geoAreasAdd.setId(""+99999l+i);
			geoAreasAdd.setUserIns("testADD"+i);
			geoAreasAdd.setDateIns(new Date());
			geoAreasAdd.setDescriptionEn("testDescription"+i);
			geoAreasAdd.setActive(true);
			em.persist(geoAreasAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(GeoAreas.class, ""+99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void geoAreasFetchById(){
		try {
			GeoAreas bull = geoAreasRep.fetchById(""+999990l);
			assertNotNull("No GeoAreas returned from fetchById", bull);
			assertTrue("geoAreasFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getDescriptionEn()+" "
					+ "Expected value: testDescription0", bull.getDescriptionEn().equals("testDescription0"));
			
			bull= geoAreasRep.fetchById(""+987654321l);
			assertNull(bull);
		} catch (Exception e) {
			fail("Caught Exception in geoAreasFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void geoAreasFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<GeoAreas> bullList = geoAreasRep.fetchAll(0, 20, cdMap);
			assertTrue("geoAreasFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("geoAreasFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) > 0){
					fail("geoAreasFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in geoAreasFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<GeoAreas> bullList = geoAreasRep.fetchAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) < 0){
					fail("geoAreasFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next: "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in geoAreasFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<GeoAreas> bullList = geoAreasRep.fetchAll(0, 17, cdMap);
			assertTrue("geoAreasFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in geoAreasFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void geoAreasCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = geoAreasRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("geoAreasCount method failed. Number of GeoAreas expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("geoAreasCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = geoAreasRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("geoAreasCount method failed. Number of GeoAreas expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("geoAreasCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = geoAreasRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue(" Number of GeoAreas expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("geoAreasCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void geoAreasSearch(){
		List<GeoAreas> geoAreasList = new ArrayList<GeoAreas>();
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", "asc");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			geoAreasList = geoAreasRep.search(0, 20, map, emptyMap, emptyMap, emptyMap, emptyMap);
			assertTrue("geoAreasSearch method failed. Expected List of GeoAreas size: 1 Actual: "+geoAreasList.size(),geoAreasList.size() >= 1);
		} catch (Exception e){
			fail("geoAreasSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}