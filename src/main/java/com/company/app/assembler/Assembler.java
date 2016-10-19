package com.company.app.assembler;

import com.company.app.dao.MemberDao;
import com.company.app.service.ChangePasswordService;
import com.company.app.service.MemberRegisterService;

import lombok.Data;
import lombok.Getter;

@Data
public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	public Assembler() {
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);
		changePasswordService = new ChangePasswordService(memberDao);
	}
	
	
}
