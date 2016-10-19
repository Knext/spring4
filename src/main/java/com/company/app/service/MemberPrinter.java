package com.company.app.service;

import com.company.app.dao.Member;

public class MemberPrinter {

	public void print(Member member) {
		System.out.println(member.toString());
	}
}
