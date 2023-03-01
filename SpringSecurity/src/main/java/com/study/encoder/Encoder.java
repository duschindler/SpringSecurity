package com.study.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

	private static Encoder instance;
	private static BCryptPasswordEncoder encoder;
	
	public Encoder() {
		encoder = new BCryptPasswordEncoder();
	}
	
	public static final Encoder getInstance() {
		
		if( instance == null ) 
			instance 			= new Encoder();

		
		return instance;
	}
	
	public String encode( String rawPassword ) {
		return encoder.encode(rawPassword);
	}
	
	
}
