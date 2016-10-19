package com.company.app.service;

import com.company.app.dao.Member;
import com.company.app.dao.MemberDao;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
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
