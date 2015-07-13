package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.Bulletin;
import it.hellokitty.gt.repository.BulletinRepository;

public class BulletinRepositoryImpl extends RepositoryUtils<Bulletin> implements BulletinRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Bulletin.class;
	}
}