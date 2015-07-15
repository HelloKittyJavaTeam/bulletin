package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.GeoAreas;
import it.hellokitty.gt.repository.GeoAreasRepository;

public class GeoAreasRepositoryImpl extends RepositoryUtilsExt<GeoAreas> implements GeoAreasRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = GeoAreas.class;
	}
	
	public GeoAreasRepositoryImpl(){
		super();
	}
}
