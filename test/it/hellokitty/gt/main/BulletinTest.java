package it.hellokitty.gt.main;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.Dealers;
import it.hellokitty.gt.bulletin.entity.Tag;
import it.hellokitty.gt.bulletin.repository.impl.BulletinRepositoryImpl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


public class BulletinTest {
	public static void main(String[] args) {
		
		List<Bulletin> bullList = new ArrayList<Bulletin>();
		BulletinRepositoryImpl bullRepo = new BulletinRepositoryImpl();
		
		insertThings(1);

		System.out.println("-------------");
		System.out.println("BULLETIN");
		System.out.println("-------------");

		try {
			Long cnt = bullRepo.count();
			System.out.println("bulletin cnt: " + cnt);
			
			Method handler  = (Bulletin.class).getMethod("getDescriptionIt", new Class[] {});
			

			bullList = bullRepo.fetchAll(0,cnt.intValue(), new LinkedHashMap<String, String>());
			
			for(Bulletin b : bullList){
				String res = (String) handler.invoke(b, new Object[] {});
				System.out.println("bulletin id: " + b.getId() + " desc: " + res);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("-------------");
		System.out.println("BULLETIN END");
		System.out.println("-------------");
		
//		System.out.println("-------------");
//		System.out.println("FETCH BULLETIN BY ID");
//		System.out.println("-------------");
//		
//		try {
//			Bulletin b = bullRepo.fetchById(new Long("1073"));
//			System.out.println("bulletin title: " + b.getTitleIt());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("-------------");
//		System.out.println("FETCH BULLETIN BY ID END");
//		System.out.println("-------------");
//		
//		System.out.println("-------------");
//		System.out.println("SEARCH BULLETIN BY TITLE");
//		System.out.println("-------------");
//		
//		try {
//			HashMap<String, Object> paramLike = new HashMap<String, Object>();
//			paramLike.put("itTitle", "85");
//			
//			Long cnt = bullRepo.count(new HashMap<String,Object>(), paramLike, new HashMap<String,Object>(), new HashMap<String,Object>());
//			System.out.println("bulletin cnt: " + cnt);
//			
//			bullList = bullRepo.search(0, cnt.intValue(), new LinkedHashMap<String, String>(), new HashMap<String,Object>(), paramLike, new HashMap<String,Object>(), new HashMap<String,Object>());
//			
//			for(Bulletin b : bullList){
//				System.out.println("bulletin id: " + b.getId() + " bulletin title: " + b.getTitleIt());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("-------------");
//		System.out.println("SEARCH BULLETIN BY TITLE END");
//		System.out.println("-------------");
//		
//		System.out.println("-------------");
//		System.out.println("DEALER");
//		System.out.println("-------------");
//		
//		DealerRepositoryImpl dealRepo = new DealerRepositoryImpl();
//		
//		try {
//			Long cnt = dealRepo.count();
//			System.out.println("dealers: " + cnt);
//			
//			List<Dealers> dealerList = dealRepo.fetchAll(0, cnt.intValue(), null);
//			for(Dealers d : dealerList){
//				System.out.println("id: " + d.getId() + " name: " + d.getName() + " country: " + d.getCountry().getDescriptionIt() + " region: " + d.getCountry().getRegion().getDescriptionIt() + " area: " + d.getCountry().getRegion().getArea().getDescriptionIt());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("-------------");
//		System.out.println("DEALER END");
//		System.out.println("-------------");
//		
//		System.out.println("-------------");
//		System.out.println("AREA-REGION-COUNTRY-DEALER");
//		System.out.println("-------------");
//		
//		GeoAreasRepositoryImpl geoRepo = new GeoAreasRepositoryImpl();
//		
//		try {
//			Long cnt = geoRepo.count();
//			System.out.println("areas: " + cnt);
//			
//			List<GeoAreas> areaList = geoRepo.fetchAll(0, cnt.intValue(), null);
//			for(GeoAreas a : areaList){
//				System.out.println("id: " + a.getId() + " name: " + a.getDescriptionIt());
//				for(GeoRegions r : a.getRegions()){
//					System.out.println("region_id: " + r.getId() + " name: " + r.getDescriptionIt());
//					for(GeoCountries c : r.getCountries()){
//						System.out.println("country_id: " + c.getId() + " name: " + c.getDescriptionIt());
//						for(Dealers d : c.getDealers()){
//							System.out.println("dealer_id: " + d.getId() + " name: " + d.getName());
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("-------------");
//		System.out.println("AREA-REGION-COUNTRY-DEALER END");
//		System.out.println("-------------");
//		
//		System.out.println("-------------");
//		System.out.println("VEHICLE FAMILY-GROUP-MASTER");
//		System.out.println("-------------");
//		
//		VehicleFamilyRepositoryImpl vehRepo = new VehicleFamilyRepositoryImpl();
//		
//		try {
//			Long cnt = vehRepo.count();
//			System.out.println("families: " + cnt);
//			
//			List<VehicleFamily> familyList = vehRepo.fetchAll(0, cnt.intValue(), null);
//			for(VehicleFamily f : familyList){
//				System.out.println("id: " + f.getId() + " name: " + f.getDescription());
//				for(VehicleGroups g : f.getGroups()){
//					System.out.println("group_id: " + g.getId() + " name: " + g.getDescription());
//					for(VehicleMaster m : g.getVehicles()){
//						System.out.println("master_id: " + m.getId() + " name: " + m.getDescription());
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("-------------");
//		System.out.println("VEHICLE FAMILY-GROUP-MASTER END");
//		System.out.println("-------------");
//		
//		System.out.println("-------------");
//		System.out.println("VEHICLE");
//		System.out.println("-------------");
//		
//		VehicleMasterRepositoryImpl masRepo = new VehicleMasterRepositoryImpl();
//		
//		try {
//			Long cnt = masRepo.count();
//			System.out.println("vehicles: " + cnt);
//			
//			List<VehicleMaster> masterList = masRepo.fetchAll(0, cnt.intValue(), null);
//			for(VehicleMaster m : masterList){
//				System.out.println("id: " + m.getId() + " name: " + m.getDescription() + " group: " + m.getGroup().getDescription() + " family: " + m.getGroup().getFamily().getDescription());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("-------------");
//		System.out.println("VEHICLE END");
//		System.out.println("-------------");
	}

	public static void insert1thing(BulletinRepositoryImpl bullRepo, String content, String title){
		Bulletin bull = new Bulletin();
		bull.setActive(true);
		//bull.setBulletinAttachments(bulletinAttachments);
		//bull.setBulletinUsers(bulletinUsers);
		//bull.setCountries(countries);
		bull.setCreateDate(new Date());
		//bull.setDealers(dealers);
		//bull.setEmailContacts(emailContacts);
		//bull.setGeoAreas(geoAreas);
		bull.setContentIt(content);
		bull.setTitleIt(title);
		//bull.setMailingLists(mailingLists);
		bull.setPriority("1");
		//bull.setRegions(regions);
		bull.setStatus("created");
		//bull.setTags(tags);
		//bull.setTechAreaDept(techAreaDept);
		//bull.setUpdate(update);
		//bull.setUserCreated(userCreated);
		//bull.setUserUpdate(userUpdate);
		
		try {
			bullRepo.insert(bull, "gb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertThings(int num){
		BulletinRepositoryImpl bullRepo = new BulletinRepositoryImpl();
		
		for(int i = 0; i < num; i++){
			String content = "contenuto" + i;
			String title = "title" + i;
			insert1thing(bullRepo, content, title);
		}
	}
	
	public static void insert1000things(){
		Attachment attach = new Attachment();
		Dealers dealer = new Dealers();
		Tag tag = new Tag();
		Bulletin bull;
		List<Attachment> attachList = new ArrayList<Attachment>();
		List<Dealers> dealerList = new ArrayList<Dealers>();
		List<Tag> tagList;
		BulletinRepositoryImpl bullRepo = new BulletinRepositoryImpl();

		for(int i = 0; i < 1000; i++){
			bull = new Bulletin();
			bull.setCreateDate(new Date());
			bull.setTitleIt("titolo"+i);
			bull.setContentIt("contenuto della comunicazione n:"+i);
			bull.setPriority((i%50)+"");
			tagList = new ArrayList<Tag>();
			int maxIndex = 10;
			if(i % 2 == 0){
				maxIndex = 20;
			}
			for(int t = 0; t < maxIndex; t++){
				tag = new Tag();

				tag.setCreateDate(new Date());
				tag.setUserCreated("gb");
				tag.setWord("TAG"+t);
				tag.setActive(true);

				tagList.add(tag);
			}

			dealer = new Dealers();
			dealer.setName("dealer"+i);
			dealer.setDateIns(new Date());
			dealer.setUserIns("gb");
			dealerList = new ArrayList<Dealers>();
			dealerList.add(dealer);
			bull.setDealers(dealerList);

			attach = new Attachment();
			attach.setFileName("file"+i+".png");
			attach.setCreateDate(new Date());
			attach.setUserCreated("gb");
			attachList = new ArrayList<Attachment>();
			attachList.add(attach);
			bull.setBulletinAttachments(attachList);

			bull.setTags(tagList);
			bull.setUserCreated("gb");

			try {
				bullRepo.insert(bull, "user");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
