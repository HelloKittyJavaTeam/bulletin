package it.hellokitty.gt.bulletin.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.EmailContact;
import it.hellokitty.gt.bulletin.entity.MailingList;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.entity.Tag;
import it.hellokitty.gt.bulletin.repository.impl.AttachmentHistoryRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.AttachmentRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.BulletinRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.BulletinUserRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.EmailContactRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.MailingListRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.RolesActionRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.TagRepositoryImpl;
import it.hellokitty.gt.bulletin.service.Service;

public class ServiceImpl implements Service{
	private AttachmentHistoryRepositoryImpl attachmentHistoryRepository = new AttachmentHistoryRepositoryImpl();
	private AttachmentRepositoryImpl 		attachmentRepository		= new AttachmentRepositoryImpl();
	private BulletinRepositoryImpl			bulletinRepository			= new BulletinRepositoryImpl();
	private BulletinUserRepositoryImpl		bulletinUserRepository		= new BulletinUserRepositoryImpl();
	private EmailContactRepositoryImpl		emailContactRepository  	= new EmailContactRepositoryImpl();
	private MailingListRepositoryImpl		mailingListRepository		= new MailingListRepositoryImpl();
	private RolesActionRepositoryImpl		rolesActionRepository		= new RolesActionRepositoryImpl();
	private TagRepositoryImpl				tagRepository				= new TagRepositoryImpl();
	
	private static ServiceImpl bulletinServiceImpl;
	
	private ServiceImpl(){}
	
	public static ServiceImpl getInstance(){
		if(bulletinServiceImpl == null){
			bulletinServiceImpl = new ServiceImpl();
		}
		return bulletinServiceImpl;
	}

	/*
	 * GET BY ID
	 */
	
	@Override
	public AttachmentHistory getAttachmentHistoryById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return attachmentHistoryRepository.getById(id);
	}

	@Override
	public Attachment getAttachmentById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return attachmentRepository.getById(id);
	}

	@Override
	public Bulletin getBulletinById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return bulletinRepository.getById(id);
	}

	@Override
	public BulletinUser getBulletinUserById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return bulletinUserRepository.getById(id);
	}

	@Override
	public RolesAction getRolesActionById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return rolesActionRepository.getById(id);
	}

	@Override
	public Tag getTagById(Object id) throws IllegalArgumentException, Exception {
		if(id == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - id parameter can't be null.");
		}
		return tagRepository.getById(id);
	}
	
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
	public List<AttachmentHistory> getAttachmentHistoryAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return attachmentHistoryRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Attachment> getAttachmentAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return attachmentRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Bulletin> getBulletinAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return bulletinRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<BulletinUser> getBulletinUserAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return bulletinUserRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<RolesAction> getRolesActionAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return rolesActionRepository.getAll(start, limit, orderColumn);
	}

	@Override
	public List<Tag> getTagAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		return tagRepository.getAll(start, limit, orderColumn);
	}
	
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
	public Long countAttachmentHistory() throws Exception {
		return attachmentHistoryRepository.count();
	}

	@Override
	public Long countAttachment() throws Exception {
		return attachmentRepository.count();
	}

	@Override
	public Long countBulletin() throws Exception {
		return bulletinRepository.count();
	}

	@Override
	public Long countBulletinUser() throws Exception {
		return bulletinUserRepository.count();
	}

	@Override
	public Long countRolesAction() throws Exception {
		return rolesActionRepository.count();
	}

	@Override
	public Long countTag() throws Exception {
		return tagRepository.count();
	}
	
	@Override
	public Long countEmailContact() throws Exception {
		return emailContactRepository.count();
	}

	@Override
	public Long countMailingList() throws Exception {
		return mailingListRepository.count();
	}

	@Override
	public Long countAttachmentHistory(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return attachmentHistoryRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countAttachment(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return attachmentRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countBulletin(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return bulletinRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countBulletinUser(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return bulletinUserRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countRolesAction(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return rolesActionRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public Long countTag(HashMap<String, Object> paramEquals,
			HashMap<String, Object> paramLike, HashMap<String, Object> paramGE,
			HashMap<String, Object> paramLE) throws Exception {
		return tagRepository.count(paramEquals, paramLike, paramGE, paramLE);
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

	@Override
	public List<AttachmentHistory> searchAttachmentHistory(Integer start,
			Integer limit, LinkedHashMap<String, String> orderColumn,
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
		
		return attachmentHistoryRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Attachment> searchAttachment(Integer start, Integer limit,
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
		
		return attachmentRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Bulletin> searchBulletin(Integer start, Integer limit,
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
		
		return bulletinRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<BulletinUser> searchBulletinUser(Integer start, Integer limit,
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
		
		return bulletinUserRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<RolesAction> searchRolesAction(Integer start, Integer limit,
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
		
		return rolesActionRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<Tag> searchTag(Integer start, Integer limit,
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
		
		return tagRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
	
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
		
	/*
	 *  INSERT
	 */
	@Override
	public void insertAttachment(Attachment elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		attachmentRepository.insert(elem, user);
		
	}

	@Override
	public void insertAttachmentHistory(AttachmentHistory elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		attachmentHistoryRepository.insert(elem, user);
	}

	@Override
	public void insertBulletin(Bulletin elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		bulletinRepository.insert(elem, user);
	}

	@Override
	public void insertBulletinUser(BulletinUser elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		bulletinUserRepository.insert(elem, user);
	}

	@Override
	public void insertRolesAction(RolesAction elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		rolesActionRepository.insert(elem, user);
	}

	@Override
	public void insertTag(Tag elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		tagRepository.insert(elem, user);
	}
	
	@Override
	public void insertEmailContact(EmailContact elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		emailContactRepository.insert(elem, user);
	}

	@Override
	public void insertMailingList(MailingList elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		mailingListRepository.insert(elem, user);
	}

	/*
	 *  MERGE
	 */
	@Override
	public Attachment mergeAttachment(Attachment elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (Attachment) attachmentRepository.merge(elem, user);
	}

	@Override
	public AttachmentHistory mergeAttachmentHistory(AttachmentHistory elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (AttachmentHistory) attachmentHistoryRepository.merge(elem, user);
	}

	@Override
	public Bulletin mergeBulletin(Bulletin elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (Bulletin) bulletinRepository.merge(elem, user);
	}

	@Override
	public BulletinUser mergeBulletinUser(BulletinUser elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (BulletinUser) bulletinUserRepository.merge(elem, user);
	}

	@Override
	public RolesAction mergeRolesAction(RolesAction elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (RolesAction) rolesActionRepository.merge(elem, user);
	}

	@Override
	public Tag mergeTag(Tag elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (Tag) tagRepository.merge(elem, user);
	}
	
	@Override
	public EmailContact mergeEmailContact(EmailContact elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (EmailContact) emailContactRepository.merge(elem, user);
	}

	@Override
	public MailingList mergeMailingList(MailingList elem, String user) throws Exception {
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		return (MailingList) mailingListRepository.merge(elem, user);
	}

	
	/*
	 *  DELETE
	 */
	@Override
	public void deleteAttachment(Attachment elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		attachmentRepository.delete(elem, user);
	}

	@Override
	public void deleteAttachmentHistory(AttachmentHistory elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		attachmentHistoryRepository.delete(elem, user);
	}

	@Override
	public void deleteBulletin(Bulletin elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		bulletinRepository.delete(elem, user);
	}

	@Override
	public void deleteBulletinUser(BulletinUser elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		bulletinUserRepository.delete(elem, user);
	}

	@Override
	public void deleteRolesAction(RolesAction elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		rolesActionRepository.delete(elem, user);
	}

	@Override
	public void deleteTag(Tag elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		tagRepository.delete(elem, user);
	}
	
	@Override
	public void deleteEmailContact(EmailContact elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		emailContactRepository.delete(elem, user);
	}

	@Override
	public void deleteMailingList(MailingList elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null || user.trim().equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null or empty");
		}
		
		mailingListRepository.delete(elem, user);
	}
}
