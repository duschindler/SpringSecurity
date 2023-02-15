package com.study.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.study.NoDataFoundException;
import com.study.ParameterException;
import com.study.entity.User;
import com.study.entity.dto.UserDTO;
import com.study.repository.UserRepository;
import com.study.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;

	@Override
	public UserDTO saveOrUpdate(User user) throws Exception {
		
		User userDB = getReferenceById(user.getId());
		if( userDB == null ) {
			
			user = repository.save(user);
			
		} else {
			
			userDB.setPassword	( user.getPassword() );
			userDB.setName		( user.getName() );
			user = userDB;
		}
		
		user = repository.save(user);
		
		return new UserDTO(user);
	}

	@Override
	public UserDTO getReference(Long id) throws Exception {
		
		if( id == null )
			throw new ParameterException();
		
		User reference = getReferenceById(id);
		if( reference == null )
			throw new NoDataFoundException();
		
		return new UserDTO( reference );
	}
	
	private User getReferenceById(Long id) throws Exception {
		
		if( id == null )
			return null;
		
		return repository.getReferenceById(id);
	}

	@Override
	public List<UserDTO> getList() throws Exception {
			
		List<UserDTO> listDTO 	= new ArrayList<>(0);
		
		List<User> list 		= repository.findAll();
		for (User user : list) {
			listDTO.add( new UserDTO(user) );
		}
		
		return listDTO;
	}

	@Override
	public List<UserDTO> getList(User user) throws Exception {
		
		if( user == null || user.getId() == null && (user.getUser() == null || user.getUser().isBlank()) )
			throw new ParameterException();
		
		List<UserDTO> list = new ArrayList<>(0);
		List<User> findAll = repository.findAll( Example.of(user) );
		for (User u : findAll) {
			list.add( new UserDTO(u) );
		}
		
		return list;
	}

	@Override
	public void delete(Long id) throws Exception {
		
		User user = getReferenceById(id);
		if( user == null )
			throw new NoDataFoundException();
		
		repository.delete(user);
	}
	
}
