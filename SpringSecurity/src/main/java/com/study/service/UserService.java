package com.study.service;

import java.util.List;
import java.util.UUID;

import com.study.model.User;
import com.study.model.dto.UserDTO;

public interface UserService {

	UserDTO saveOrUpdate		( User user ) throws Exception;
	UserDTO getReference		( UUID id ) throws Exception;
	User getReferenceByUsername	( String username ) throws Exception;
	List<UserDTO> getList		(  ) throws Exception;
	List<UserDTO> getList		( User user ) throws Exception;
	void delete					( UUID id ) throws Exception;
	void deactivate				( UUID id ) throws Exception;
	void activate				( UUID id ) throws Exception;
	
}
