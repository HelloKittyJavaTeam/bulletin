package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.entity.RolesAction;
import it.hellokitty.gt.repository.RolesActionRepository;
import it.hellokitty.gt.repository.utils.RepositoryUtils;

public class RolesActionRepositoryImpl extends RepositoryUtils<RolesAction> implements RolesActionRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = RolesAction.class;
	}
	
	public RolesActionRepositoryImpl(){
		super();
	}
}
