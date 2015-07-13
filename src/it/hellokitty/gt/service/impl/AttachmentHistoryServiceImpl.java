package it.hellokitty.gt.service.impl;

import it.hellokitty.gt.entity.AttachmentHistory;
import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.repository.AttachmentHistoryRepository;
import it.hellokitty.gt.repository.impl.AttachmentHistoryRepositoryImpl;
import it.hellokitty.gt.service.AttachmentHistoryService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AttachmentHistoryServiceImpl implements AttachmentHistoryService {
	AttachmentHistoryRepository attachmentHistoryRepository = new AttachmentHistoryRepositoryImpl();

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
	public Long count() throws Exception {
		return attachmentHistoryRepository.count();
	}

	@Override
	public Long count(HashMap<String, Object> arg0,
			HashMap<String, Object> arg1, HashMap<String, Object> arg2,
			HashMap<String, Object> arg3) throws Exception {
		return attachmentHistoryRepository.count(arg0, arg1, arg2, arg3);
	}

	@Override
	public List<AttachmentHistory> fetchAll(Integer arg0, Integer arg1,
			LinkedHashMap<String, String> arg2) throws Exception {
		return attachmentHistoryRepository.fetchAll(arg0, arg1, arg2);
	}

	@Override
	public AttachmentHistory fetchById(Object id) throws Exception {
		return attachmentHistoryRepository.fetchById(id);
	}

	@Override
	public List<AttachmentHistory> search(Integer start, Integer limit,
			LinkedHashMap<String, String> arg2, HashMap<String, Object> arg3,
			HashMap<String, Object> arg4, HashMap<String, Object> arg5,
			HashMap<String, Object> arg6) {
		return attachmentHistoryRepository.search(start, limit, arg2, arg3, arg4, arg5, arg6);
	}

}