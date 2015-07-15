package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtilsExt;
import it.hellokitty.gt.bulletin.entity.VehicleGroups;
import it.hellokitty.gt.bulletin.repository.VehicleGroupsRepository;

public class VehicleGroupsRepositoryImpl extends RepositoryUtilsExt<VehicleGroups> implements VehicleGroupsRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = VehicleGroups.class;
	}
	
	public VehicleGroupsRepositoryImpl(){
		super();
	}
}