package com.study;

import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.study.model.User;

public class Tests {


	public static void main(String[] args) throws JsonSyntaxException, InstantiationException, IllegalAccessException {

		String json = 
				"{"
				+ "    \"username\": \"joaquim\","
				+ "    \"name\": \"Joaquim\","
				+ "    \"password\": \"senha123\","
				+ "    \"listRole\": ["
				+ "        {"
				+ "            \"name\": \"NORMAL\""
				+ "        }"
				+ "    ]"
				+ "}"
			;
		
		User user = Gson.class.newInstance().fromJson(json, User.class);
		System.out.println(user.getUsername());
		
	}
	
}
