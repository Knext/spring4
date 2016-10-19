package com.company.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.app.dao.Member;
import com.company.app.dao.MemberDao;
import com.company.app.dao.exception.MemberNotFoundExeption;

public class ChangePasswordService {

	private MemberDao memberDao;
	
	@Autowired
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.slelctByEmail(email);
		if (member == null) {
			throw new MemberNotFoundExeption();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
