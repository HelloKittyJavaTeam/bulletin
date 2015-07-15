package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.UserDealerRoles;
import it.hellokitty.gt.bulletin.repository.UserDealerRolesRepository;

public class UserDealerRolesRepositoryImpl extends RepositoryUtilsExt<UserDealerRoles> implements UserDealerRolesRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = UserDealerRoles.class;
	}
	
	public UserDealerRolesRepositoryImpl(){
		super();
	}
}
