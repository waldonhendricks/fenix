package com.uk.security.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uk.security.dao.User;

/**
 * Interface UserRepository.
 * @author PAULO
 */
public interface UserRepository extends CrudRepository<User, String> {
	public User findByUsername(String username);
}
