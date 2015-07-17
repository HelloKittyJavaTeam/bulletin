package it.hellokitty.gt.bulletin.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.entity.MailingList;

public interface EmailService {
	/*
	 * GET BY ID
	 */
	
	EmailContact getEmailContactById(Object id) throws IllegalArgumentException, Exception;
	
	MailingList getMailingListById(Object id) throws IllegalArgumentException, Exception;
	
	/*
	 * GET ALL
	 */
	
	List<EmailContact> getEmailContactAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	List<MailingList> getMailingListAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws IllegalArgumentException, Exception;
	
	/*
	 * COUNT
	 */
	
	Long countEmailContact() throws Exception;
	
	Long countMailingList() throws Exception;
	
	Long countEmailContact(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;

	Long countMailingList(HashMap<String, Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception;

	/*
	 * SEARCH
	 */
	
	List<EmailContact> searchEmailContact(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;

	List<MailingList> searchMailingList(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn, HashMap<String, Object> paramEquals, HashMap<String, Object> paramLike, HashMap<String, Object> paramGE, HashMap<String, Object> paramLE) throws IllegalArgumentException, Exception;
}
