package it.hellokitty.gt.bulletin.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.RolesAction;
import it.hellokitty.gt.bulletin.entity.Tag;
import it.hellokitty.gt.bulletin.repository.impl.AttachmentHistoryRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.AttachmentRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.BulletinRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.BulletinUserRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.RolesActionRepositoryImpl;
import it.hellokitty.gt.bulletin.repository.impl.TagRepositoryImpl;
import it.hellokitty.gt.bulletin.service.BulletinService;

public class BulletinServiceImpl implements BulletinService{
	private AttachmentHistoryRepositoryImpl attachmentHistoryRepository = new AttachmentHistoryRepositoryImpl();
	private AttachmentRepositoryImpl 		attachmentRepository		= new AttachmentRepositoryImpl();
	private BulletinRepositoryImpl			bulletinRepository			= new BulletinRepositoryImpl();
	private BulletinUserRepositoryImpl		bulletinUserRepository		= new BulletinUserRepositoryImpl();
	private RolesActionRepositoryImpl		rolesActionRepository		= new RolesActionRepositoryImpl();
	private TagRepositoryImpl				tagRepository				= new TagRepositoryImpl();
	
	private static BulletinServiceImpl bulletinServiceImpl;
	
	private BulletinServiceImpl(){}
	
	public static BulletinServiceImpl getInstance(){
		if(bulletinServiceImpl == null){
			bulletinServiceImpl = new BulletinServiceImpl();
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

}
