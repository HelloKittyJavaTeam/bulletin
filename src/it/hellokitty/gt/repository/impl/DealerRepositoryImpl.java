package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.Dealers;
import it.hellokitty.gt.repository.DealerRepository;

public class DealerRepositoryImpl extends RepositoryUtilsExt<Dealers> implements DealerRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Dealers.class;
	}
}