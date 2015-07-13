package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.AttachmentHistory;
import it.hellokitty.gt.repository.AttachmentHistoryRepository;

public class AttachmentHistoryRepositoryImpl extends RepositoryUtils<AttachmentHistory> implements AttachmentHistoryRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = AttachmentHistory.class;
	}
}
