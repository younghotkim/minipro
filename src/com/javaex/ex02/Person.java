package com.javaex.ex02;

public class Person {

	private String name;
	private String hp;
	private String company;
	
	public Person(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
	
	/////////////////////일반 메소드//////////////////
	
	public void showInfo() {
		
		System.out.println(this.name + this.hp + this.company);
		
	}
	
	


	
	
	
	
	
	
}
