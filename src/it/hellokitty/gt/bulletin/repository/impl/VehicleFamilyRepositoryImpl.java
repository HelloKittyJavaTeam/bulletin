package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.VehicleFamily;
import it.hellokitty.gt.bulletin.repository.VehicleFamilyRepository;

public class VehicleFamilyRepositoryImpl extends RepositoryUtilsExt<VehicleFamily> implements VehicleFamilyRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleFamily.class;
	}
	
	public VehicleFamilyRepositoryImpl(){
		super();
	}
}
