package com.company.app.dao;

import java.util.Date;

import com.company.app.dao.exception.IdPassworkdNotMatchingException;

import lombok.Data;

@Data
public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;

	public Member(String email, String password, String name, Date registerDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new IdPassworkdNotMatchingException();
		}
		this.password = newPassword;
	}
}
