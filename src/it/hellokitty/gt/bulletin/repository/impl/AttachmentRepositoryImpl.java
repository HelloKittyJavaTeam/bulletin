package it.hellokitty.gt.bulletin.repository.impl;

import it.hellokitty.gt.repository.utils.RepositoryUtils;
import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.repository.AttachmentRepository;

public class AttachmentRepositoryImpl extends RepositoryUtils<Attachment> implements AttachmentRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Attachment.class;
	}
	
	public AttachmentRepositoryImpl(){
		super();
	}
}
