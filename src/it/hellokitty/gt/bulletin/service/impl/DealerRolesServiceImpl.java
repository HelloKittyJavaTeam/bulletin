package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.DealerRoles;
import it.hellokitty.gt.bulletin.repository.DealerRolesRepository;
import it.hellokitty.gt.bulletin.repository.impl.DealerRolesRepositoryImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DealerRolesServiceImpl{
	DealerRolesRepository dealerRolesRepository = new DealerRolesRepositoryImpl();
	private static DealerRolesServiceImpl dealerRolesServiceImpl;

	private DealerRolesServiceImpl() {
		super();
	}
	
	public static DealerRolesServiceImpl getInstance(){
		if(dealerRolesServiceImpl == null){
			dealerRolesServiceImpl = new DealerRolesServiceImpl();
		}
		return dealerRolesServiceImpl;
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
		
		return dealerRolesRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<DealerRoles> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return dealerRolesRepository.fetchAll(start, limit, orderColumn);
	}

	
	public DealerRoles fetchById(Object id) throws Exception {
		return dealerRolesRepository.fetchById(id);
	}

	
	public List<DealerRoles> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return dealerRolesRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}