package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.VehicleMaster;
import it.hellokitty.gt.repository.VehicleMasterRepository;

public class VehicleMasterRepositoryImpl extends RepositoryUtilsExt<VehicleMaster> implements VehicleMasterRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleMaster.class;
	}
}
