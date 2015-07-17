package it.hellokitty.gt.bulletin.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.entity.Tag;

public interface BulletinService {
	/*
	 * GET BY ID
	 */
	
	AttachmentHistory getAttachmentHistoryById(Object id) throws IllegalArgumentException, Exception;

	Attachment getAttachmentById(Object id) throws IllegalArgumentException, Exception;
	
	Bulletin getBulletinById(Object id) throws IllegalArgumentException, Exception;
	
	BulletinUser getBulletinUserById(Object id) throws IllegalArgumentException, Exception;
	
	RolesAction getRolesActionById(Object id) throws IllegalArgumentException, Exception;
	
	Tag getTagById(Object id) throws IllegalArgumentException, Exception;
	
	/*
	 * GET ALL 
	 */
	
	List<AttachmentHistory> getAttachmentHistoryAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<Attachment> getAttachmentAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<Bulletin> getBulletinAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<BulletinUser> getBulletinUserAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<RolesAction> getRolesActionAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;

	List<Tag> getTagAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception;
	
	/*
	 * COUNT
	 */
	
	Long countAttachmentHistory() throws Exception;

	Long countAttachment() throws Exception;
	
	Long countBulletin() throws Exception;
	
	Long countBulletinUser() throws Exception;
	
	Long countRolesAction() throws Exception;
	
	Long countTag() throws Exception;
	
	Long countAttachmentHistory(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countAttachment(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countBulletin(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countBulletinUser(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;

	Long countRolesAction(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	Long countTag(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;
	
	/*
	 * SEARCH
	 */
	
	List<AttachmentHistory> searchAttachmentHistory(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Attachment> searchAttachment(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Bulletin> searchBulletin(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<BulletinUser> searchBulletinUser(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;

	List<RolesAction> searchRolesAction(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
	List<Tag> searchTag(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
	
}