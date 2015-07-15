package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.entity.Attachment;
import it.hellokitty.gt.repository.AttachmentRepository;

public class AttachmentRepositoryImpl extends RepositoryUtils<Attachment> implements AttachmentRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Attachment.class;
	}
	
	public AttachmentRepositoryImpl(){
		super();
	}
}
