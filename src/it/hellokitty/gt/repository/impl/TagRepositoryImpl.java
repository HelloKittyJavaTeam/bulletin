package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.Tag;
import it.hellokitty.gt.repository.TagRepository;

public class TagRepositoryImpl extends RepositoryUtils<Tag> implements TagRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Tag.class;
	}
	
	public TagRepositoryImpl(){
		super();
	}
}