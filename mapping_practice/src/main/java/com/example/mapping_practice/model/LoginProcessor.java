package com.example.mapping_practice.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.mapping_practice.services.LoginManager;

@Component
@RequestScope
public class LoginProcessor {
	
	private final LoginManager loginManager;
	
	private String username;
	private String password;
	
	public LoginProcessor(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	
	public boolean login() {
		String username = this.getUsername();
		String password = this.getPassword();
		
		boolean loginResult = false;
		
		if ("luckyseven".equals(username) && "password".equals(password)) {
			loginResult = true;
			loginManager.setUsername(username);
		}
		
		return loginResult;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
