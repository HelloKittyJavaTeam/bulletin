package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.GeoCountries;
import it.hellokitty.gt.repository.GeoCountriesRepository;

public class GeoCountriesRepositoryImpl extends RepositoryUtilsExt<GeoCountries> implements GeoCountriesRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = GeoCountries.class;
	}
}
