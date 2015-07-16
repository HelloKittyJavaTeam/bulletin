package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.UserDealerRoles;
import it.hellokitty.gt.bulletin.repository.UserDealerRolesRepository;
import it.hellokitty.gt.bulletin.repository.impl.UserDealerRolesRepositoryImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class UserDealerRolesServiceImpl{
	UserDealerRolesRepository userDealerRolesRepository = new UserDealerRolesRepositoryImpl();
	private static UserDealerRolesServiceImpl userDealerRolesServiceImpl;

	private UserDealerRolesServiceImpl() {
		super();
	}
	
	public static UserDealerRolesServiceImpl getInstance(){
		if(userDealerRolesServiceImpl == null){
			userDealerRolesServiceImpl = new UserDealerRolesServiceImpl();
		}
		return userDealerRolesServiceImpl;
	}
	
	public Long count() throws Exception {
		return userDealerRolesRepository.count();
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
		
		return userDealerRolesRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<UserDealerRoles> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return userDealerRolesRepository.fetchAll(start, limit, orderColumn);
	}

	
	public UserDealerRoles fetchById(Object id) throws Exception {
		return userDealerRolesRepository.fetchById(id);
	}

	
	public List<UserDealerRoles> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return userDealerRolesRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
