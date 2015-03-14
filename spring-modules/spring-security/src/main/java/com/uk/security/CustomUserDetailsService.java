package com.uk.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.uk.security.repositories.impl.UserRepositoryImpl;

/**
 * Class CustomUserDetailsService.
 * 
 * @author PAULO
 */
public class CustomUserDetailsService implements UserDetailsService {

	private final Logger _log = Logger.getLogger(CustomUserDetailsService.class);

	@Autowired(required = true)
	private UserRepositoryImpl userRepositoryDao;

	private User userdetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			com.uk.security.dao.User user = getUserDetail(username);
			System.out.println(username);
			System.out.println(user.getPassword());
			System.out.println(user.getUsername());
			System.out.println(user.getRole());
	
			userdetails = new User(user.getUsername(), user.getPassword(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(user.getRole()));
		} catch(Exception ex) {
			_log.error(ex);
		}
		
		return userdetails;
	}

	public List<GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (role.intValue() == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		} else if (role.intValue() == 1) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		
		System.out.println(authList);
		return authList;
	}

	public com.uk.security.dao.User getUserDetail(String username) {
		com.uk.security.dao.User user = userRepositoryDao.findByUsername(username);
		return user;
	}
	
	public UserRepositoryImpl getUserRepositoryDao() {
		return userRepositoryDao;
	}

	public void setUserRepositoryDao(UserRepositoryImpl userRepositoryDao) {
		this.userRepositoryDao = userRepositoryDao;
	}
}
