package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.DealerRoles;
import it.hellokitty.gt.repository.DealerRolesRepository;

public class DealerRolesRepositoryImpl extends RepositoryUtilsExt<DealerRoles> implements DealerRolesRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = DealerRoles.class;
	}
	
	public DealerRolesRepositoryImpl(){
		super();
	}
}
