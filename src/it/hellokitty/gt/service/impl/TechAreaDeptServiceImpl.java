package it.hellokitty.gt.service.impl;

import it.hellokitty.gt.entity.TechAreaDept;
import it.hellokitty.gt.repository.TechAreaDeptRepository;
import it.hellokitty.gt.repository.impl.TechAreaDeptRepositoryImpl;
import it.hellokitty.gt.service.TechAreaDeptService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class TechAreaDeptServiceImpl implements TechAreaDeptService {
	TechAreaDeptRepository techAreaDeptRepository = new TechAreaDeptRepositoryImpl();

	@Override
	public Long count() throws Exception {
		return techAreaDeptRepository.count();
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
		
		return techAreaDeptRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<TechAreaDept> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return techAreaDeptRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public TechAreaDept fetchById(Object id) throws Exception {
		return techAreaDeptRepository.fetchById(id);
	}

	@Override
	public List<TechAreaDept> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return techAreaDeptRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
