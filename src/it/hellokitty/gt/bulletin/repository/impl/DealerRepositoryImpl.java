package it.hellokitty.gt.bulletin.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.Dealers;
import it.hellokitty.gt.bulletin.repository.DealerRepository;

public class DealerRepositoryImpl extends RepositoryUtilsExt<Dealers> implements DealerRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Dealers.class;
	}
	
	public DealerRepositoryImpl(){
		super();
	}
}