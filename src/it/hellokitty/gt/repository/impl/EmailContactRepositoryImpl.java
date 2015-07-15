package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.EmailContact;
import it.hellokitty.gt.repository.EmailContactRepository;

public class EmailContactRepositoryImpl extends RepositoryUtils<EmailContact> implements EmailContactRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = EmailContact.class;
	}
	
	public EmailContactRepositoryImpl(){
		super();
	}
}