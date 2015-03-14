package com.uk.security.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uk.security.dao.User;

/**
 * Class SpringMongoDBXMLMain.
 * @author PAULO
 */
public class SpringMongoDBXMLMain {
	
	public static final String DB_NAME = "local";
	public static final String PERSON_COLLECTION = "user";
	public static final String MONGO_HOST = "localhost";
	public static final int MONGO_PORT = 27017;

	public static void main(String[] args) {
			
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("mongodb-applicationContext.xml");
		
		UserTestDAL personDAO = ctx.getBean("userTestDAL", UserTestDAL.class);
		
		User newUser = new User("paulo", "lancao", 39, "paulo.lancao", "$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.", 0);
		
		personDAO.createUser(newUser);
		
		ctx.close();
	}
}
