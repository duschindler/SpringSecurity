package com.study.service;

import com.study.model.Role;
import com.study.role.UserRoleEnum;

public interface RoleService {

	Role doSave	( UserRoleEnum role ) throws Exception;
	Role find	( UserRoleEnum role ) throws Exception;
	
}
