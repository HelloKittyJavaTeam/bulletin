package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.entity.VehicleGroup;
import it.hellokitty.gt.repository.VehicleGroupRepository;

public class VehicleGroupRepositoryImpl extends RepositoryUtilsExt<VehicleGroup> implements VehicleGroupRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleGroup.class;
	}
}