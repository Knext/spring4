package com.company.app;

import org.springframework.cache.annotation.AnnotationCacheOperationSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.company.app.config.JavaConfig;
import com.company.app.config.JavaConfig2;
import com.company.app.config.JavaConfig3;
import com.company.app.dao.RegisterRequest;
import com.company.app.service.MemberInfoPrinter;
import com.company.app.service.MemberRegisterService;

public class Main {
	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
//		Greeter g = ctx.getBean("greeter", Greeter.class);
//		Greeter g1 = ctx.getBean("greeter", Greeter.class);
//		String msg = g.greet("spring");
//		System.out.println(g.hashCode());
//		System.out.println(g1.hashCode());
//		System.out.println(msg);
//		ctx.close();
//
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig3.class);
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("aaa@lll.com");
		regReq.setName("kkk");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.register(regReq);
		
		infoPrinter.printMemberInfo("aaa@lll.com");
	}

}
