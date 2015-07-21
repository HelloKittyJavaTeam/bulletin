package it.hellokitty.gt.bulletin.repository.impl;

import it.ferrari.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.bulletin.entity.MailingList;
import it.hellokitty.gt.bulletin.repository.MailingListRepository;

public class MailingListRepositoryImpl extends RepositoryUtils<MailingList> implements MailingListRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = MailingList.class;
	}
	
	public MailingListRepositoryImpl(){
		super();
	}
}