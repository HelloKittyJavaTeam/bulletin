package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.AdUsers;
import it.hellokitty.gt.repository.AdUsersRepository;

public class AdUsersRepositoryImpl extends RepositoryUtilsExt<AdUsers> implements AdUsersRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = AdUsers.class;
	}
	
	public AdUsersRepositoryImpl(){
		super();
	}
}
