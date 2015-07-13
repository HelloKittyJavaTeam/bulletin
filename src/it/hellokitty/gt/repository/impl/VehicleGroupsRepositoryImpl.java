package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.VehicleGroups;
import it.hellokitty.gt.repository.VehicleGroupsRepository;

public class VehicleGroupsRepositoryImpl extends RepositoryUtilsExt<VehicleGroups> implements VehicleGroupsRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleGroups.class;
	}
}