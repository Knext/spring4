package com.company.app;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Greeter g = ctx.getBean("greeter", Greeter.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("spring");
		System.out.println(g.hashCode());
		System.out.println(g1.hashCode());
		System.out.println(msg);
		ctx.close();
	}

}
