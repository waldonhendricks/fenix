package com.uk.security.repositories.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uk.security.dao.User;
import com.uk.security.repositories.UserRepository;

/**
 * Class UserRepositoryImpl.
 * @author PAULO
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired(required = true)
	private MongoTemplate mongoTemplate;

	public final String USER_COLLECTION = "user";
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public <S extends User> S save(S entity) {
		getMongoTemplate().save(entity, USER_COLLECTION);
		return entity;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		Iterator<S> it = entities.iterator();
		MongoOperations mongoOps = getMongoTemplate();
		while(it.hasNext()) {
			mongoOps.save(it.next(), USER_COLLECTION);
		}
		return entities;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public User findOne(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return getMongoTemplate().findOne(query, User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public boolean exists(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return getMongoTemplate().exists(query, User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public Iterable<User> findAll() {
		return getMongoTemplate().findAll(User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public Iterable<User> findAll(Iterable<String> ids) {
		Query query = new Query(Criteria.where("_id").all(ids));
		return getMongoTemplate().find(query, User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public long count() {
		Query query = new Query(Criteria.where("_id"));
		return getMongoTemplate().count(query, User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void delete(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		getMongoTemplate().remove(query, User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void delete(User entity) {
		getMongoTemplate().remove(entity, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void delete(Iterable<? extends User> entities) {
		Iterator<? extends User> it = entities.iterator();
		MongoOperations mongoOps = getMongoTemplate();
		while(it.hasNext()) {
			mongoOps.remove(it.next(), USER_COLLECTION);
		}
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@Override
	public void deleteAll() {
		Query query = new Query(Criteria.where("_id"));
		getMongoTemplate().remove(query, User.class, USER_COLLECTION);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public User findByUsername(String username) {
		Query query = new Query(Criteria.where("username").is(username));
		return getMongoTemplate().findOne(query, User.class, USER_COLLECTION);
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
