package com.company.app.service;

import java.util.Date;

import com.company.app.dao.Member;
import com.company.app.dao.MemberDao;
import com.company.app.dao.RegisterRequest;
import com.company.app.dao.exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register(RegisterRequest req) {
		Member member = memberDao.slelctByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
	
	

}
