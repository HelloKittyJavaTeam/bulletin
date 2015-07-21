package it.hellokitty.gt.bulletin.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.GeoAreas;
import it.hellokitty.gt.bulletin.repository.GeoAreasRepository;

public class GeoAreasRepositoryImpl extends RepositoryUtilsExt<GeoAreas> implements GeoAreasRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = GeoAreas.class;
	}
	
	public GeoAreasRepositoryImpl(){
		super();
	}
}
