package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.Department;
import it.hellokitty.gt.bulletin.repository.DepartmentRepository;
import it.hellokitty.gt.bulletin.repository.impl.DepartmentRepositoryImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DepartmentServiceImpl{

	DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
	private static DepartmentServiceImpl departmentServiceImpl;

	private DepartmentServiceImpl() {
		super();
	}
	
	public static DepartmentServiceImpl getInstance(){
		if(departmentServiceImpl == null){
			departmentServiceImpl = new DepartmentServiceImpl();
		}
		return departmentServiceImpl;
	}
	
	public Long count() throws Exception {
		return departmentRepository.count();
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
		
		return departmentRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	
	public List<Department> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception {
		return departmentRepository.fetchAll(start, limit, orderColumn);
	}

	
	public Department fetchById(Object id) throws Exception {
		return departmentRepository.fetchById(id);
	}

	
	public List<Department> search(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return departmentRepository.search(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}
}
