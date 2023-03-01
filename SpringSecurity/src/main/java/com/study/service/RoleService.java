package com.study.service;

import com.study.model.Role;
import com.study.role.UserRole;

public interface RoleService {

	Role doSave	( UserRole role ) throws Exception;
	Role find	( UserRole role ) throws Exception;
	
}
