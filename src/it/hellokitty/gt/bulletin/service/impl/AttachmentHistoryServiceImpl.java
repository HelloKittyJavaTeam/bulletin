package it.hellokitty.gt.bulletin.service.impl;

import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.bulletin.repository.AttachmentHistoryRepository;
import it.hellokitty.gt.bulletin.repository.impl.AttachmentHistoryRepositoryImpl;
import it.hellokitty.gt.entity.BaseObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AttachmentHistoryServiceImpl{
	AttachmentHistoryRepository attachmentHistoryRepository = new AttachmentHistoryRepositoryImpl();
	private static AttachmentHistoryServiceImpl attachmentHistoryServiceImpl;

	private AttachmentHistoryServiceImpl() {
		super();
	}
	
	public static AttachmentHistoryServiceImpl getInstance(){
		if(attachmentHistoryServiceImpl == null){
			attachmentHistoryServiceImpl = new AttachmentHistoryServiceImpl();
		}
		return attachmentHistoryServiceImpl;
	}
	
	public List<AttachmentHistory> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		if(start == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be null.");
		}
		
		if(start < 0){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - start parameter can't be < 0. Current value:"+start+".");
		}
		
		if(limit == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be null.");
		}
		
		if(limit <= 0){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - limit parameter can't be <= 0. Current value:"+limit+".");
		}
		
		if(cdList == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - cdList parameter can't be null.");
		}
		
		return attachmentHistoryRepository.fetchAll(start, limit, cdList, user);
	}

	
	public void insert(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		attachmentHistoryRepository.insert(elem, user);
	}

	
	public void delete(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
		}
		
		attachmentHistoryRepository.delete(elem, user);
	}

	
	public BaseObject merge(BaseObject elem, String user) throws IllegalArgumentException, Exception {
		if(elem == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - elem parameter can't be null.");
		}
		
		if(user == null){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be null.");
		}
		
		if(user.equals("")){
			throw new IllegalArgumentException(this.getClass().getPackage()+" - "+this.getClass()+" - user parameter can't be empty.");
			
		}
		
		return attachmentHistoryRepository.merge(elem, user);
	}

	
	public Long count() throws Exception {
		return attachmentHistoryRepository.count();
	}

	
	public Long count(HashMap<String, Object> arg0,
			HashMap<String, Object> arg1, HashMap<String, Object> arg2,
			HashMap<String, Object> arg3) throws Exception {
		return attachmentHistoryRepository.count(arg0, arg1, arg2, arg3);
	}

	
	public List<AttachmentHistory> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2) throws Exception {
		return attachmentHistoryRepository.fetchAll(arg0, arg1, arg2);
	}

	
	public AttachmentHistory fetchById(Object id) throws Exception {
		if(id == null){
			throw new IllegalArgumentException(this+" - "+this.getClass()+" - id parameter cannot be null.");
		}
		return attachmentHistoryRepository.fetchById(id);
	}

	
	public List<AttachmentHistory> search(Integer start, Integer limit,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return attachmentHistoryRepository.search(start, limit, arg2, arg3, arg4, arg5, arg6);
	}

}