package com;

public class GreetingService {
	public String greeting ;
	public String greeting2 ;
	public BeyService bs;//�������Ҫ����get��set��������ʹ�ã�����Ȼ�ᱨbs����д�Ĵ��󣡣�

	public String getGreeting2() {
		return greeting2;
	}
	

	public void setGreeting2(String greeting2) {
		this.greeting2 = greeting2;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public void sayGreeting(){
		System.out.println(greeting);
	}
	public void sayGreeting2(){
		System.out.println(greeting2);
	}
	public BeyService getBs() {
		return bs;
	}


	public void setBs(BeyService bs) {
		this.bs = bs;
	}


	public void sayGreeting3(){
		bs.sayByeing();
	}

}
