package com.study.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.model.User;
import com.study.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	final UserServiceImpl service;
	
	public UserDetailsServiceImpl( UserServiceImpl service  ) {
		this.service = service;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User reference = null;
		
		try {
			reference = service.getReferenceByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if( reference == null )
			throw new UsernameNotFoundException( "Username not found!" );
		
		
		return reference;
	}

}
