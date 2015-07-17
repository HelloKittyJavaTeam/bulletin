package it.hellokitty.gt.bulletin.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.entity.MailingList;
import it.hellokitty.gt.bulletin.repository.impl.EmailContactRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.MailingListRepositoryImpl;
import it.hellokitty.gt.bulletin.service.EmailService;

public class EmailServiceImpl implements EmailService{
	private EmailContactRepositoryImpl emailContactRepository = new EmailContactRepositoryImpl();
	private MailingListRepositoryImpl mailingListRepository   = new MailingListRepositoryImpl();
	
	private static EmailServiceImpl emailServiceImpl = null;
	
	private EmailServiceImpl(){}
	
	public EmailServiceImpl getInstance(){
		if(emailServiceImpl == null){
			emailServiceImpl = new EmailServiceImpl();
		}
		return emailServiceImpl;
	}

	/*
	 * GET BY ID
	 */
	
	@Override
	public EmailContact getEmailContactById(Object id)throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return emailContactRepository.getById(id);
	}

	@Override
	public MailingList getMailingListById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return mailingListRepository.getById(id);
	}

	/*
	 * GET ALL
	 */
	
	@Override
	public List<EmailContact> getEmailContactAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return emailContactRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<MailingList> getMailingListAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return mailingListRepository.getAll(start, limit, orderColumn);
	}
	
	/*
	 * COUNT
	 */

	@Override
	public Long countEmailContact() throws Exception {
		return emailContactRepository.count();
	}

	@Override
	public Long countMailingList() throws Exception {
		return mailingListRepository.count();
	}

	@Override
	public Long countEmailContact(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return emailContactRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countMailingList(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return mailingListRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	/*
	 * SEARCH 
	 */
	
	@Override
	public List<EmailContact> searchEmailContact(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return emailContactRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<MailingList> searchMailingList(Integer start, Integer limit,
			LinkedHashMap<String, String> orderColumn,
			HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws IllegalArgumentException,
			Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return mailingListRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

}
