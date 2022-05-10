package com.javaex.phonebook;

public class PhoneDB {
	
	//필드
	private int pno;
	private String name;
	private String hp;
	private String company;
	
	
	//생성자
	public PhoneDB() {
		super();
	}
	public PhoneDB(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	public PhoneDB(int pno, String name, String hp, String company) {
		super();
		this.pno = pno;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
		
	
	
	//메소드 gs
	public int getPno() {
		return pno;
	}
	public String getName() {
		return name;
	}
	public String getHp() {
		return hp;
	}
	public String getCompany() {
		return company;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	//메소드
	
	
	
}
