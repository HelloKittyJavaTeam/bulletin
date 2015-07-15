package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.UserDealerRoles;
import it.hellokitty.gt.repository.UserDealerRolesRepository;

public class UserDealerRolesRepositoryImpl extends RepositoryUtilsExt<UserDealerRoles> implements UserDealerRolesRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = UserDealerRoles.class;
	}
	
	public UserDealerRolesRepositoryImpl(){
		super();
	}
}
