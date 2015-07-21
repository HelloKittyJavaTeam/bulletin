package it.hellokitty.gt.bulletin.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.bulletin.entity.TechAreaDept;
import it.hellokitty.gt.bulletin.repository.TechAreaDeptRepository;

public class TechAreaDeptRepositoryImpl extends RepositoryUtils<TechAreaDept> implements TechAreaDeptRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = TechAreaDept.class;
	}
	
	public TechAreaDeptRepositoryImpl(){
		super();
	}
}
