package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.AdUsers;
import it.hellokitty.gt.bulletin.repository.AdUsersRepository;
import it.hellokitty.gt.bulletin.repository.impl.AdUsersRepositoryImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class AdUsersServiceImpl{
	AdUsersRepository adUsersRepository = new AdUsersRepositoryImpl();
	private static AdUsersServiceImpl adUsersServiceImpl;

	private AdUsersServiceImpl() {
		super();
	}
	
	public static AdUsersServiceImpl getInstance(){
		if(adUsersServiceImpl == null){
			adUsersServiceImpl = new AdUsersServiceImpl();
		}
		return adUsersServiceImpl;
	}
	
	
	public Long count() throws Exception {
		return adUsersRepository.count();
	}

	
	public Long count(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws IllegalArgumentException, Exception {
		if(paramEquals == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramEquals parameter cannot be null.");
		}
		
		if(paramLike == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramLike parameter cannot be null.");
		}
		
		if(paramGE == null){
			throw new IllegalArgumentException(this.getClass().getPackage() + " - "+ this.getClass()+" - paramGE parameter cannot be null.");
		}
		
		if(paramLE == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+ this.getClass()+" - paramLE parameter cannot be null.");
		}
		
		return adUsersRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<AdUsers> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return adUsersRepository.fetchAll(start, limit, orderColumn);
	}

	
	public AdUsers fetchById(Object id) throws Exception {
		return adUsersRepository.fetchById(id);
	}

	
	public List<AdUsers> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return adUsersRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
