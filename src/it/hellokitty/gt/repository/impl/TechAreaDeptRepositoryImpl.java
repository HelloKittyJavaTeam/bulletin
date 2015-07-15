package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.TechAreaDept;
import it.hellokitty.gt.repository.TechAreaDeptRepository;

public class TechAreaDeptRepositoryImpl extends RepositoryUtils<TechAreaDept> implements TechAreaDeptRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = TechAreaDept.class;
	}
	
	public TechAreaDeptRepositoryImpl(){
		super();
	}
}
