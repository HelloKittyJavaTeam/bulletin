package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.repository.BulletinUserRepository;
import it.hellokitty.gt.bulletin.repository.impl.BulletinUserRepositoryImpl;
import it.hellokitty.gt.entity.BaseObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class BulletinUserServiceImpl{
	BulletinUserRepository bulletinUserRepository = new BulletinUserRepositoryImpl();
	private static BulletinUserServiceImpl bulletinUserServiceImpl;

	private BulletinUserServiceImpl() {
		super();
	}
	
	public static BulletinUserServiceImpl getInstance(){
		if(bulletinUserServiceImpl == null){
			bulletinUserServiceImpl = new BulletinUserServiceImpl();
		}
		return bulletinUserServiceImpl;
	}
	
	public List<BulletinUser> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(start < 0){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be < 0. Current value:"+start+".");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		if(limit <= 0){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be <= 0. Current value:"+limit+".");
		}
		
		if(cdList == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - cdList parameter can't be null.");
		}
		
		return bulletinUserRepository.fetchAll(start, limit, cdList, user);
	}

	
	public void insert(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		bulletinUserRepository.insert(elem, user);
	}

	
	public void delete(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		bulletinUserRepository.delete(elem, user);
	}

	
	public BaseObject merge(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
			
		}
		
		return bulletinUserRepository.merge(elem, user);
	}

	
	public Long count() throws Exception {
		return bulletinUserRepository.count();
	}

	
	public Long count(HashMap<String,Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception {
		return bulletinUserRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<BulletinUser> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		return bulletinUserRepository.fetchAll(start, limit, orderColumn);
	}

	
	public BulletinUser fetchById(Object id) throws Exception {
		return bulletinUserRepository.fetchById(id);
	}

	
	public List<BulletinUser> search(Integer start, Integer limit, 
			LinkedHashMap<String,String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE) {
		return bulletinUserRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}
