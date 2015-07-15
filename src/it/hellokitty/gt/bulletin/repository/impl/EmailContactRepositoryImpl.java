package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.repository.EmailContactRepository;

public class EmailContactRepositoryImpl extends RepositoryUtils<EmailContact> implements EmailContactRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = EmailContact.class;
	}
	
	public EmailContactRepositoryImpl(){
		super();
	}
}