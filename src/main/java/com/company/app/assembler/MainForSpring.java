package com.company.app.assembler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.company.app.dao.RegisterRequest;
import com.company.app.dao.exception.AlreadyExistingMemberException;
import com.company.app.dao.exception.IdPassworkdNotMatchingException;
import com.company.app.dao.exception.MemberNotFoundExeption;
import com.company.app.service.ChangePasswordService;
import com.company.app.service.MemberInfoPrinter;
import com.company.app.service.MemberListPrinter;
import com.company.app.service.MemberRegisterService;
import com.company.app.service.VersionPrinter;

public class MainForSpring {
//	private static Assembler assembler = new Assembler();
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("input");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("exit");
				break;
			}
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if(command.startsWith("list")) {
				processListCommand();
				continue;
			} else if(command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			} else if(command.startsWith("ver")) {
				processVerCommand();
				continue;
			}

			printHelp();
		}

	}

	private static void processVerCommand() {
		// TODO Auto-generated method stub
		VersionPrinter printer = ctx.getBean("versionPrinter",VersionPrinter.class);
		printer.print();
	}

	private static void processInfoCommand(String[] arg) {
		// TODO Auto-generated method stub
		if (arg.length !=2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}

	private static void processListCommand() {
		// TODO Auto-generated method stub
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}

	private static void printHelp() {
		// TODO Auto-generated method stub
		System.out.println("what's up");
		
	}

	private static void processNewCommand(String[] arg) {
		// TODO Auto-generated method stub
		if (arg.length !=5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("wrong password.");
			return;
		}
		
		try {
			regSvc.register(req);
			System.out.println("register");
		} catch (AlreadyExistingMemberException ae) {
			System.out.println("exist email");
		}
	}

	private static void processChangeCommand(String[] arg) {
		// TODO Auto-generated method stub
		if (arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("register");
		} catch (MemberNotFoundExeption me) {
			System.out.println("not found");
		} catch (IdPassworkdNotMatchingException ie) {
			System.out.println("wrong email or password");
		}
	
	}
}
