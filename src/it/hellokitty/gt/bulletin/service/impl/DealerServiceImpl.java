package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.Dealers;
import it.hellokitty.gt.bulletin.repository.DealerRepository;
import it.hellokitty.gt.bulletin.repository.impl.DealerRepositoryImpl;
import it.hellokitty.gt.bulletin.service.DealerService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DealerServiceImpl implements DealerService {
	DealerRepository dealerRepository = new DealerRepositoryImpl();

	public DealerServiceImpl(){
		super();
	}
	
	@Override
	public Long count() throws Exception {
		return dealerRepository.count();
	}

	@Override
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
		
		return dealerRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Dealers> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return dealerRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public Dealers fetchById(Object id) throws Exception {
		return dealerRepository.fetchById(id);
	}

	@Override
	public List<Dealers> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return dealerRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}