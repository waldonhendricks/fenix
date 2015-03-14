package com.uk.security.main;

import org.springframework.data.mongodb.core.MongoOperations;

import com.uk.security.dao.User;

/**
 * Class UserTestDALImpl.
 * @author PAULO
 */
public class UserTestDALImpl implements UserTestDAL {

	private MongoOperations mongoOps;
	private static final String USER_COLLECTION = "user";

	public UserTestDALImpl(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}
	
	@Override
	public void createUser(User user) {
		this.mongoOps.insert(user, USER_COLLECTION);
	}
}
