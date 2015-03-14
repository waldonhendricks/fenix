package com.uk.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uk.security.dao.User;
import com.uk.security.dto.UserDTO;
import com.uk.security.repositories.UserRepository;
import com.uk.security.services.UserService;

/**
 * Class UserServiceImpl.
 * @author PAULO
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
		
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	@Override
	public UserDTO create(UserDTO user) {
		User userDao = new User(user.getName(), user.getSurname(), user.getAge(), user.getUsername(), user.getPassword(), user.getRole());
		userDao = userRepository.save(userDao);
		return convertToDTO(userDao);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	@Override
	public UserDTO delete(String id) {
		User deleted = userRepository.findOne(id);
		userRepository.delete(deleted);
        return convertToDTO(deleted);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly = true)
	@Override
	public List<UserDTO> findAll() {
		Iterable<User> userEntries = userRepository.findAll();
		return convertToDTOs(userEntries);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly = true)
	@Override
	public UserDTO findById(String id) {
		User result = userRepository.findOne(id);
		return convertToDTO(result);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	@Override
	public UserDTO update(UserDTO user) {
		User updated = userRepository.findOne(user.getId());
        updated = userRepository.save(updated);
        return convertToDTO(updated);
	}

	private List<UserDTO> convertToDTOs(Iterable<User> models) {
        List<UserDTO> listUsers = new ArrayList<UserDTO>();
        for(User user : models) {
        	listUsers.add(convertToDTO(user));
        }
        return listUsers;
    }
	
	private UserDTO convertToDTO(User model) {
		UserDTO dto = new UserDTO();
 
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setSurname(model.getSurname());
        dto.setAge(model.getAge());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
        dto.setRole(model.getRole());
        
        return dto;
    }
}
