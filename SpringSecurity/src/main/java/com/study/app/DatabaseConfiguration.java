package com.study.app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.model.Role;
import com.study.model.User;
import com.study.role.UserRole;
import com.study.service.RoleService;
import com.study.service.UserService;

@Configuration
public class DatabaseConfiguration {

	
	private static final Logger log = LoggerFactory.getLogger( DatabaseConfiguration.class );
	
	
	@Bean
	public CommandLineRunner initDatabase ( UserService userService, RoleService roleService ) {
		
		return args -> {
			
			log.info( "-------------------------" );
			
			log.info( "Preloading Roles STARTED" );
				Role admin 	= roleService.doSave( UserRole.ADMIN );
				List<Role> listRoleAdmin = new ArrayList<>(0);
				listRoleAdmin.add(admin);
				
				Role normal = roleService.doSave( UserRole.NORMAL );
				List<Role> listRoleNormal = new ArrayList<>(0);
				listRoleNormal.add(admin);
				listRoleNormal.add(normal);
			log.info( "Preloading Roles ENDED" );
			
			
			log.info( "-------------------------" );
			
			
			log.info( "Preloading Users STARTED" );
				
				userService.saveOrUpdate( 
						new User(UUID.randomUUID(), "duschindler", "senha123", "Eduardo Luiz Schindler", 1, listRoleAdmin) 
					);
				
				userService.saveOrUpdate( 
						new User(UUID.randomUUID(), "joaquim", "senha123", "Joaquim", 1, listRoleNormal) 
					);
			log.info( "Preloading Users ENDED" );
			
			log.info( "-------------------------" );
			
		};
	}
	
}
