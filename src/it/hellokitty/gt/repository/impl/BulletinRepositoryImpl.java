package it.hellokitty.gt.repository.impl;

import it.hellokitty.gt.entity.Bulletin;
import it.hellokitty.gt.entity.Tag;
import it.hellokitty.gt.repository.BulletinRepository;
import it.hellokitty.gt.repository.utils.RepositoryUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BulletinRepositoryImpl extends RepositoryUtils<Bulletin> implements BulletinRepository{
	{
		persistenceUnitName = "BULLETIN_PU";
		typeParameterClass = Bulletin.class;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	protected CriteriaQuery innerSearch(CriteriaBuilder cb, CriteriaQuery cq, Root<Bulletin> t, LinkedHashMap<String, String> orderColumn,
			HashMap<String,Object> paramEquals,
			HashMap<String,Object> paramLike,
			HashMap<String,Object> paramGE,
			HashMap<String,Object> paramLE){
		List<Predicate> listPred = new LinkedList<Predicate>();
		Join<Bulletin, Tag> tags = t.join("tags", JoinType.LEFT);
		Predicate pred;

		if(orderColumn != null){
			for(String ordCol: orderColumn.keySet()){
				if(orderColumn.get(ordCol).equalsIgnoreCase("asc")){
					cq.orderBy(cb.asc(t.get(ordCol)));
				} else {
					cq.orderBy(cb.desc(t.get(ordCol)));    
				}
			}
		}

		if(paramEquals != null){
			for(String column: paramEquals.keySet()){
				if(column.equals("tag")){
					pred = cb.equal(tags.get("word"), paramEquals.get(column));
				} else {
					pred = cb.equal(t.get(column), paramEquals.get(column));
				}
				listPred.add(pred);
			}
		}
		
		if(paramLike != null){
			for(String column: paramLike.keySet()){
				if(column.equals("tag")){
					pred = cb.like(tags.<String>get("word"), "%"+paramLike.get(column)+"%");
				} else {
					pred = cb.like(t.<String>get(column), "%"+paramLike.get(column).toString()+"%");
				}
				listPred.add(pred);
			}
		}
		
		if(paramGE != null){
			for(String column: paramLE.keySet()){
				pred = cb.le(t.<Number>get(column), (Number)paramGE.get(column));
				listPred.add(pred);
			}
		}
		
		if(paramLE != null){
			for(String column: paramGE.keySet()){
				pred = cb.ge(t.<Number>get(column), (Number)paramLE.get(column));
				listPred.add(pred);
			}
		}
		
		Predicate[] predArray = new Predicate[listPred.size()];
		listPred.toArray(predArray);
		cq.where(predArray);

		return cq;
	}
}