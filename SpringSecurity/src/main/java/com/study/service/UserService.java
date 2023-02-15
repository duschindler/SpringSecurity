package com.study.service;

import java.util.List;

import com.study.entity.User;
import com.study.entity.dto.UserDTO;

public interface UserService {

	UserDTO saveOrUpdate	( User user ) throws Exception;
	UserDTO getReference	( Long id ) throws Exception;
	List<UserDTO> getList	(  ) throws Exception;
	List<UserDTO> getList	( User user ) throws Exception;
	void delete				( Long id ) throws Exception;
	
}
