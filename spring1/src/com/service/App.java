package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.BeyService;
import com.GreetingService;

public class App {

	public static void main(String[] args) {
		//从类路径这里找这个xml文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");//容器
		GreetingService gs=(GreetingService) ac.getBean("greetingService");
		gs.sayGreeting();
		
		gs.sayGreeting3();
		
		gs.sayGreeting2();
		
		BeyService bs=(BeyService) ac.getBean("beyService");
		bs.sayByeing();
	
	}

}
