package it.hellokitty.gt.entity.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.hellokitty.gt.bulletin.entity.GeoRegions;
import it.hellokitty.gt.bulletin.repository.impl.GeoRegionsRepositoryImpl;

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


public class GeoRegionsTest {
	private GeoRegionsRepositoryImpl geoRegionsRep = new GeoRegionsRepositoryImpl();
	private static EntityManager em = Persistence.createEntityManagerFactory("BULLETIN_PU").createEntityManager();
	private static GeoRegions geoRegionsAdd;

	@Before
	public void insert20Elements() {
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		for(int i = 0; i < 20; i++){
			geoRegionsAdd = new GeoRegions();
			geoRegionsAdd.setId(""+99999l+i);
			geoRegionsAdd.setUserIns("testADD"+i);
			geoRegionsAdd.setDateIns(new Date());
			geoRegionsAdd.setDescriptionEn("testDescription"+i);
			geoRegionsAdd.setActive(true);
			em.persist(geoRegionsAdd);
		}
		transaction.commit();
	}
	
	@After
	public void delete20Elements() {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for(int i = 0; i < 20; i++){
			em.remove(em.find(GeoRegions.class, ""+99999l+i));
		}
		transaction.commit();
	}
	
	/*
	 *  FETCH BY ID TEST
	 */
	@Test
	public void geoRegionsFetchById(){
		try {
			GeoRegions bull = geoRegionsRep.getById(""+999990l);
			assertNotNull("No GeoRegions returned from fetchById", bull);
			assertTrue("geoRegionsFetchById method failed on retrieve content value. "
					+ "Actual value: "+bull.getDescriptionEn()+" "
					+ "Expected value: testDescription0", bull.getDescriptionEn().equals("testDescription0"));
			
			bull= geoRegionsRep.getById(""+987654321l);
			assertNull(bull);
		} catch (Exception e) {
			fail("Caught Exception in geoRegionsFetchById method. "+e.toString());
		}
	}
	
	/*
	 * 	FETCH ALL TEST
	 */
	@Test
	public void geoRegionsFetchAll(){
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "asc");
			List<GeoRegions> bullList = geoRegionsRep.getAll(0, 20, cdMap);
			assertTrue("geoRegionsFetchAll returned a empty list.", bullList.size() > 0);
			assertTrue("geoRegionsFetchAll didn't return all the elements.", bullList.size() >= 20);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) > 0){
					fail("geoRegionsFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in geoRegionsFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<GeoRegions> bullList = geoRegionsRep.getAll(0, 20, cdMap);
			for(int index = 0; index < bullList.size()-1; index++){
				if(bullList.get(index).getId().compareTo(bullList.get(index+1).getId()) < 0){
					fail("geoRegionsFetchAll method failed during asc order check. Id at index "+index+":"+bullList.get(index).getId()+" next "+index+":"+bullList.get(index+1).getId());
				}
			}
		} catch (Exception e) {
			fail("Caught Exception in geoRegionsFetchById method. "+e.toString());
		}
		
		try {
			LinkedHashMap<String, String> cdMap = new LinkedHashMap<String, String>();
			cdMap.put("id", "desc");
			List<GeoRegions> bullList = geoRegionsRep.getAll(0, 17, cdMap);
			assertTrue("geoRegionsFetchAll didn't return all the elements.", bullList.size() == 17);
		} catch (Exception e) {
			fail("Caught Exception in geoRegionsFetchById method. "+e.toString());
		}
	}
	
	/*
	 *  COUNT TEST
	 */
	@Test
	public void geoRegionsCount(){
		Long result;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userIns", "testADD0");
		HashMap<String, Object> emptyMap = new HashMap<String, Object>();
		
		try{
			result = geoRegionsRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("geoRegionsCount method failed. Number of GeoRegions expected: 1 Actual:"+result, result==1);
		} catch (Exception e){
			fail("geoRegionsCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADDUNKNOW");
		
		try{
			result = geoRegionsRep.count(map, emptyMap, emptyMap, emptyMap);
			assertTrue("geoRegionsCount method failed. Number of GeoRegions expected: 0 Actual:"+result, result==0);
		} catch (Exception e){
			fail("geoRegionsCount method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("userIns", "testADD");
		
		try{
			result = geoRegionsRep.count(emptyMap, map, emptyMap, emptyMap);
			assertTrue("geoRegionsCount method with user parameter = 'unknowUser' failed. Number of GeoRegions expected: 20 Actual:"+result, result == 20);
		} catch (Exception e){
			fail("geoRegionsCount method with user parameter = 'unknowUser' failed. Unexpected exception catched. "+e.toString());
		}
	}
	
	/*
	 *  SEARCH TEST
	 */
	@Test
	public void geoRegionsSearch(){
		List<GeoRegions> geoRegionsList = new ArrayList<GeoRegions>();
		
		LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "asc");
		
		try{
			geoRegionsList = geoRegionsRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("geoRegionsSearch method failed. Expected List of GeoRegions size: 20 Actual: "+geoRegionsList.size(),geoRegionsList.size() == 20);
			
			for(int index = 0; index < geoRegionsList.size() - 1; index++){
				assertTrue("geoRegionsSearch method failed on asc order check. Id at index "+index+": "+geoRegionsList.get(index).getId()+" next: "+geoRegionsList.get(index+1).getId(),
						geoRegionsList.get(index).getId().compareTo(geoRegionsList.get(index+1).getId()) < 0);
			}
		} catch (Exception e){
			fail("geoRegionsSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		orderMap = new LinkedHashMap<String, String>();
		orderMap.put("id", "desc");
		
		try{
			geoRegionsList = geoRegionsRep.search(0, 20, orderMap, null, null, null, null);
			assertTrue("geoRegionsSearch method failed. Expected List of GeoRegions size: 20 Actual: "+geoRegionsList.size(),geoRegionsList.size() == 20);
			
			for(int index = 0; index < geoRegionsList.size() - 1; index++){
				assertTrue("geoRegionsSearch method failed on desc order check. Id at index "+index+": "+geoRegionsList.get(index).getId()+" next: "+geoRegionsList.get(index+1).getId(),
						geoRegionsList.get(index).getId().compareTo(geoRegionsList.get(index+1).getId()) > 0);
			}
		} catch (Exception e){
			fail("geoRegionsSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("descriptionEn", "testDescription0");
		
		try{
			geoRegionsList = geoRegionsRep.search(0, 20, null, map, null, null, null);
			assertTrue("geoRegionsSearch method failed. Expected List of GeoRegions size: 1 Actual: "+geoRegionsList.size(),geoRegionsList.size() == 1);
		} catch (Exception e){
			fail("geoRegionsSearch method failed. Unexpected exception catched. "+e.toString());
		}
		
		map = new HashMap<String, Object>();
		map.put("descriptionEn", "testDescription");

		try{
			geoRegionsList = geoRegionsRep.search(0, 20, null, null, map, null, null);
			assertTrue("geoRegionsSearch method failed. Expected List of GeoRegions size: 20 Actual: "+geoRegionsList.size(),geoRegionsList.size() == 20);
		} catch (Exception e){
			fail("geoRegionsSearch method failed. Unexpected exception catched. "+e.toString());
		}
	}
}