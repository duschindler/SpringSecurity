package com.study.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.exception.NoDataFoundException;
import com.study.exception.ParameterException;
import com.study.exception.UserRoleException;
import com.study.model.User;
import com.study.model.dto.UserDTO;
import com.study.repository.UserRepository;
import com.study.role.UserRole;
import com.study.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;

	@Transactional
	@Override
	public UserDTO saveOrUpdate(User user)  throws Exception{
		
		User userDB = getReferenceByUsername(user.getUsername());
		if( userDB != null ) {
			userDB.setName		( user.getName() );
			userDB.setListRole	( user.getListRole() );
			
			if( user.getActive() != null )
				userDB.setActive	( user.getActive() );
			
			user = userDB;
		}
		
		user = repository.save(user);
		
		return new UserDTO(user);
	}

	@Override
	public UserDTO getReference(UUID id) throws Exception {
		
		if( id == null )
			throw new ParameterException();
		
		User reference = getReferenceById(id);
		if( reference == null )
			throw new NoDataFoundException();
		
		return new UserDTO( reference );
	}
	
	@Override
	public List<UserDTO> getList() throws Exception{
			
		List<UserDTO> listDTO 	= new ArrayList<>(0);
		
		List<User> list 		= repository.findAll();
		for (User user : list) {
			listDTO.add( new UserDTO(user) );
		}
		
		return listDTO;
	}

	@Override
	public List<UserDTO> getList(User user) throws Exception{
		
		if( user == null || user.getId() == null && (user.getUsername() == null || user.getUsername().isBlank()) )
			throw new ParameterException();
		
		List<UserDTO> list = new ArrayList<>(0);
		List<User> findAll = repository.findAll( Example.of(user) );
		for (User u : findAll) {
			list.add( new UserDTO(u) );
		}
		
		return list;
	}

	@Transactional
	@Override
	public void delete(UUID id)  throws Exception{
		
		User user = getReferenceById(id);
		if( user == null )
			throw new NoDataFoundException();
		
		repository.delete(user);
	}
	
	private User getReferenceById(UUID id) throws Exception {
		
		if( id == null )
			return null;
		
		return repository.findOne( Example.of( new User(id) ) ).orElse(null);
	}
	
	@Override
	public User getReferenceByUsername(String username) throws Exception {
		
		if( username == null || username.isBlank() )
			return null;
		
		User userDB = new User();
		userDB.setUsername(username);
		
		return repository.findOne( Example.of(userDB) ).orElse(null);
	}

	@Override
	public void deactivate(UUID id, UUID userAction) throws Exception {
		activeOrDeactivateUser(id, userAction, 0);
	}

	@Override
	public void activate(UUID id, UUID userAction) throws Exception {
		activeOrDeactivateUser(id, userAction, 1);
	}
	
	private void activeOrDeactivateUser( UUID id, UUID userAction, Integer active ) throws Exception {

		verifyAdminRole(userAction);
		
		User reference = getReferenceById(id);
		if( reference == null )
			throw new NoDataFoundException();

		reference.setActive(active);
		saveOrUpdate(reference);
	}
	
	private void verifyAdminRole( UUID id ) throws Exception {
		
		UserDTO reference = getReference(id);
		if( !reference.getListRole().contains( UserRole.ADMIN ) )
			throw new UserRoleException();
		
	}
	
}
