package it.hellokitty.gt.bulletin.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.repository.RolesActionRepository;

public class RolesActionRepositoryImpl extends RepositoryUtils<RolesAction> implements RolesActionRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = RolesAction.class;
	}
	
	public RolesActionRepositoryImpl(){
		super();
	}
}
