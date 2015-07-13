package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.MailingList;
import it.hellokitty.gt.repository.MailingListRepository;

public class MailingListRepositoryImpl extends RepositoryUtils<MailingList> implements MailingListRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = MailingList.class;
	}
}