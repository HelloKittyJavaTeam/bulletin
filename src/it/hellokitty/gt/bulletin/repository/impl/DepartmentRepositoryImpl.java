package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.bulletin.entity.Department;
import it.hellokitty.gt.bulletin.repository.DepartmentRepository;

public class DepartmentRepositoryImpl extends RepositoryUtils<Department> implements DepartmentRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Department.class;
	}
	
	public DepartmentRepositoryImpl(){
		super();
	}
}
