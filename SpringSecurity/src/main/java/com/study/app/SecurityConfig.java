package com.study.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.study.role.UserRoleEnum;
import com.study.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableGlobalAuthentication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	final UserDetailsServiceImpl service;
	
	public SecurityConfig(UserDetailsServiceImpl service) {
		this.service = service;
	}
	
	@Bean
	public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		http
				.httpBasic()
				.and()
				.authorizeHttpRequests()
//				.requestMatchers(HttpMethod.GET, "/user/").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.userDetailsService(service)
				.csrf().disable()
			;
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
