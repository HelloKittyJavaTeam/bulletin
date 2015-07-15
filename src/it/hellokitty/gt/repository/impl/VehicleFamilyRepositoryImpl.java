package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.VehicleFamily;
import it.hellokitty.gt.repository.VehicleFamilyRepository;

public class VehicleFamilyRepositoryImpl extends RepositoryUtilsExt<VehicleFamily> implements VehicleFamilyRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleFamily.class;
	}
	
	public VehicleFamilyRepositoryImpl(){
		super();
	}
}
