package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.GeoRegions;
import it.hellokitty.gt.repository.GeoRegionsRepository;

public class GeoRegionsRepositoryImpl extends RepositoryUtilsExt<GeoRegions> implements GeoRegionsRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = GeoRegions.class;
	}
}
