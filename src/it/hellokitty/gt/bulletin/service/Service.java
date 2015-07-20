package it.hellokitty.gt.bulletin.service;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.entity.MailingList;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.entity.Tag;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface Service {
	/*
	 * GET BY ID
	 */
	
	AttachmentHistory getAttachmentHistoryById(Object id) throws IllegalArgumentException, Exception;
	Attachment 		  getAttachmentById(Object id) 		  throws IllegalArgumentException, Exception;
	Bulletin 		  getBulletinById(Object id) 		  throws IllegalArgumentException, Exception;
	BulletinUser 	  getBulletinUserById(Object id) 	  throws IllegalArgumentException, Exception;
	RolesAction 	  getRolesActionById(Object id) 	  throws IllegalArgumentException, Exception;
	Tag 			  getTagById(Object id) 			  throws IllegalArgumentException, Exception;
	EmailContact 	  getEmailContactById(Object id) 	  throws IllegalArgumentException, Exception;
	MailingList 	  getMailingListById(Object id) 	  throws IllegalArgumentException, Exception;
	
	/*
	 * GET ALL 
	 */
	
	List<AttachmentHistory> getAttachmentHistoryAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	List<Attachment> 		getAttachmentAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		 throws IllegalArgumentException, Exception;
	List<Bulletin> 			getBulletinAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		 throws IllegalArgumentException, Exception;
	List<BulletinUser> 		getBulletinUserAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	 throws IllegalArgumentException, Exception;
	List<RolesAction> 		getRolesActionAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	 	 throws IllegalArgumentException, Exception;
	List<Tag> 				getTagAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 				 throws IllegalArgumentException, Exception;
	List<EmailContact> 		getEmailContactAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 	 throws IllegalArgumentException, Exception;
	List<MailingList> 		getMailingListAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) 		 throws IllegalArgumentException, Exception;
	
	/*
	 * COUNT
	 */
	
	Long countAttachmentHistory() throws Exception;
	Long countAttachment() 		  throws Exception;
	Long countBulletin() 		  throws Exception;
	Long countBulletinUser() 	  throws Exception;
	Long countRolesAction() 	  throws Exception;
	Long countTag() 			  throws Exception;
	Long countEmailContact() 	  throws Exception;
	Long countMailingList() 	  throws Exception;
	
	Long countAttachmentHistory	(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countAttachment		(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countBulletin			(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countBulletinUser		(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countRolesAction		(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countTag				(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countEmailContact		(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	Long countMailingList		(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;

	/*
	 * SEARCH
	 */
	
	List<AttachmentHistory> searchAttachmentHistory (Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<Attachment> 		searchAttachment		(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<Bulletin> 			searchBulletin			(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<BulletinUser> 		searchBulletinUser		(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<RolesAction> 		searchRolesAction		(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<Tag> 				searchTag				(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	List<EmailContact> 		searchEmailContact		(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;	
	List<MailingList> 		searchMailingList		(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;

	/*
	 *  INSERT
	 */
	void insertAttachment		(Attachment elem, String user)  	 throws IllegalArgumentException, Exception;
	void insertAttachmentHistory(AttachmentHistory elem, String user)throws IllegalArgumentException, Exception;
	void insertBulletin			(Bulletin elem, String user) 		 throws IllegalArgumentException, Exception;
	void insertBulletinUser		(BulletinUser elem, String user) 	 throws IllegalArgumentException, Exception;
	void insertRolesAction		(RolesAction elem, String user) 	 throws IllegalArgumentException, Exception;
	void insertTag				(Tag elem, String user) 			 throws IllegalArgumentException, Exception;
	void insertEmailContact		(EmailContact elem, String user) 	 throws IllegalArgumentException, Exception;
	void insertMailingList  	(MailingList elem, String user)  	 throws IllegalArgumentException, Exception;
	
	/*
	 *  MERGE
	 */
	Attachment 		  mergeAttachment		(Attachment elem, String user) 		 throws Exception;
	AttachmentHistory mergeAttachmentHistory(AttachmentHistory elem, String user)throws Exception;
	Bulletin 		  mergeBulletin			(Bulletin elem, String user) 		 throws Exception;
	BulletinUser 	  mergeBulletinUser		(BulletinUser elem, String user) 	 throws Exception;
	RolesAction 	  mergeRolesAction		(RolesAction elem, String user)  	 throws Exception;
	Tag 			  mergeTag				(Tag elem, String user) 		 	 throws Exception;
	EmailContact 	  mergeEmailContact 	(EmailContact elem, String user) 	 throws Exception;
	MailingList 	  mergeMailingList  	(MailingList elem, String user)  	 throws Exception;
	
	/*
	 *  DELETE
	 */
	void deleteAttachment		(Attachment elem, String user) 		 throws IllegalArgumentException, Exception;
	void deleteAttachmentHistory(AttachmentHistory elem, String user)throws IllegalArgumentException, Exception;
	void deleteBulletin			(Bulletin elem, String user) 		 throws IllegalArgumentException, Exception;
	void deleteBulletinUser		(BulletinUser elem, String user) 	 throws IllegalArgumentException, Exception;
	void deleteRolesAction		(RolesAction elem, String user) 	 throws IllegalArgumentException, Exception;
	void deleteTag				(Tag elem, String user) 			 throws IllegalArgumentException, Exception;
	void deleteEmailContact		(EmailContact elem, String user) 	 throws IllegalArgumentException, Exception;
	void deleteMailingList  	(MailingList elem, String user)  	 throws IllegalArgumentException, Exception;
}