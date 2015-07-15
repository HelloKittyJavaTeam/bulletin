package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.AdUsers;
import it.hellokitty.gt.bulletin.repository.AdUsersRepository;

public class AdUsersRepositoryImpl extends RepositoryUtilsExt<AdUsers> implements AdUsersRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = AdUsers.class;
	}
	
	public AdUsersRepositoryImpl(){
		super();
	}
}
