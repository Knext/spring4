package com.company.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.app.dao.Member;
import com.company.app.dao.MemberDao;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;

//	@Autowired
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for (Member member : members) {
			printer.print(member);
		}
	}
}
