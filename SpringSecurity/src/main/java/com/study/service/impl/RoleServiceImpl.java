package com.study.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.study.exception.NoDataFoundException;
import com.study.model.Role;
import com.study.repository.RoleRepository;
import com.study.role.UserRole;
import com.study.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository repository;
	
	@Override
	public Role doSave(UserRole role) throws Exception {
		return repository.save( new Role(UUID.randomUUID(), role) );
	}

	@Override
	public Role find(UserRole role) throws NoDataFoundException {
		return repository.findOne( Example.of( new Role(role) ) ).orElseThrow();
	}
	
}
