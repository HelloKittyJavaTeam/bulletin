package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.BulletinUser;
import it.hellokitty.gt.repository.BulletinUserRepository;

public class BulletinUserRepositoryImpl extends RepositoryUtils<BulletinUser> implements BulletinUserRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = BulletinUser.class;
	}
	
	public BulletinUserRepositoryImpl(){
		super();
	}
}