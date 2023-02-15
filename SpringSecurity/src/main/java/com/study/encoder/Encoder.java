package com.study.encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Encoder {

	private static final String ALGORITHM_SHA256 = "SHA-256";
	
	public static String encode( String string ) {
		
		if( string == null || string.isBlank() )
			return null;
		
		String encoded = null;
		try {
			
			encoded = new StringBuilder().append(encodeSHA256(string)).toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encoded;
	}
	
	private static byte[] encodeSHA256( String string ) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance( ALGORITHM_SHA256 ).digest( 
				string.getBytes()
			);
	} 
	
}
