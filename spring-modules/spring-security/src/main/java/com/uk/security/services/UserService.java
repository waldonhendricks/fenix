package com.uk.security.services;

import java.util.List;

import com.uk.security.dto.UserDTO;

/**
 * Interface UserService.
 * @author PAULO
 */
public interface UserService {
	UserDTO create(UserDTO todo);
	UserDTO delete(String id);
	List<UserDTO> findAll();
	UserDTO findById(String id);
	UserDTO update(UserDTO todo);
}
