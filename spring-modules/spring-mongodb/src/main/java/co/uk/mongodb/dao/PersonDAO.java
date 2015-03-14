package co.uk.mongodb.dao;

import co.uk.mongodb.model.Person;

/**
 * Person DAO.
 * @author PAULO
 */
public interface PersonDAO {
	public void create(Person p);
	public Person readById(String id);
	public void update(Person p);
	public int deleteById(String id);
}
