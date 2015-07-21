package it.hellokitty.gt.bulletin.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.GeoCountries;
import it.hellokitty.gt.bulletin.repository.GeoCountriesRepository;

public class GeoCountriesRepositoryImpl extends RepositoryUtilsExt<GeoCountries> implements GeoCountriesRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = GeoCountries.class;
	}
	
	public GeoCountriesRepositoryImpl(){
		super();
	}
}
