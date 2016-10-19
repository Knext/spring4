package com.company.app.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.app.dao.Member;
import com.company.app.dao.MemberDao;
import com.company.app.dao.RegisterRequest;
import com.company.app.dao.exception.AlreadyExistingMemberException;

public class MemberRegisterService {
//	@Resource(name="memberDao")
	private MemberDao memberDao;

	public MemberRegisterService() {
		
	}
	//@Autowired
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
