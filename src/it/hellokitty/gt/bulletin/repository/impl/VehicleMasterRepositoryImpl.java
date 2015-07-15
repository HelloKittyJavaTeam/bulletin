package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.VehicleMaster;
import it.hellokitty.gt.bulletin.repository.VehicleMasterRepository;

public class VehicleMasterRepositoryImpl extends RepositoryUtilsExt<VehicleMaster> implements VehicleMasterRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleMaster.class;
	}
	
	public VehicleMasterRepositoryImpl(){
		super();
	}
}
