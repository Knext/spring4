package com.company.app.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.app.dao.Member;
import com.company.app.dao.MemberDao;

public class MemberInfoPrinter {
//	@Resource(name="memberDao")
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
//	@Resource(name="memberPrinter")
	public void setMemberPrinter(MemberPrinter printer) {
		this.memberPrinter = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.slelctByEmail(email);
		if (member == null) {
			return;
		}
		memberPrinter.print(member);
	}
}
