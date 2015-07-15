package it.hellokitty.gt.service.impl;

import it.hellokitty.gt.entity.BaseObject;
import it.hellokitty.gt.entity.EmailContact;
import it.hellokitty.gt.repository.EmailContactRepository;
import it.hellokitty.gt.repository.impl.EmailContactRepositoryImpl;
import it.hellokitty.gt.service.EmailContactService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class EmailContactServiceImpl implements EmailContactService {
	EmailContactRepository emailContactRepository = new EmailContactRepositoryImpl();

	public EmailContactServiceImpl(){
		super();
	}
	
	@Override
	public List<EmailContact> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> cdList, String user) throws IllegalArgumentException, Exception {
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
		
		return emailContactRepository.fetchAll(start, limit, cdList, user);
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
		
		emailContactRepository.insert(elem, user);
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
		
		emailContactRepository.delete(elem, user);
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
		
		return emailContactRepository.merge(elem, user);
	}

	@Override
	public Long count() throws Exception {
		return emailContactRepository.count();
	}

	@Override
	public Long count(HashMap<String,Object> paramEquals, HashMap<String,Object> paramLike, HashMap<String,Object> paramGE, HashMap<String,Object> paramLE) throws Exception {
		return emailContactRepository.count(paramEquals, paramLike, paramGE, paramLE);
	}

	@Override
	public List<EmailContact> fetchAll(Integer start, Integer limit, LinkedHashMap<String, String> orderColumn) throws Exception {
		return emailContactRepository.fetchAll(start, limit, orderColumn);
	}

	@Override
	public EmailContact fetchById(Object id) throws Exception {
		return emailContactRepository.fetchById(id);
	}

	@Override
	public List<EmailContact> search(Integer start, Integer limit, 
			LinkedHashMap<String,String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE) {
		return emailContactRepository.search(start, limit, orderColumn, paramEquals, paramLike, paramGE, paramLE);
	}
}
