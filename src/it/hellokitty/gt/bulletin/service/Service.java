package it.hellokitty.gt.bulletin.service;

import it.hellokitty.gt.bulletin.entity.AdUsers;
import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.entity.BaseObject;

public interface Service<T> extends ServiceExt{
	/*
	 *  INSERT
	 */
	
//	void insertAdUsers(Class<? extends BaseObject> elem, String user) throws IllegalArgumentException, Exception;
	void insertAdUsers(AdUsers elem, String user) throws IllegalArgumentException, Exception;
	
	void insertAttachment(Attachment elem, String user) throws IllegalArgumentException, Exception;
	
	void insertAttachmentHistory(AttachmentHistory elem, String user) throws IllegalArgumentException, Exception;
	
	void insertBulletin(Bulletin elem, String user) throws IllegalArgumentException, Exception;
	
}
