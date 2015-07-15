package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.GeoRegions;
import it.hellokitty.gt.bulletin.repository.GeoRegionsRepository;

public class GeoRegionsRepositoryImpl extends RepositoryUtilsExt<GeoRegions> implements GeoRegionsRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = GeoRegions.class;
	}
	
	public GeoRegionsRepositoryImpl(){
		super();
	}
}
