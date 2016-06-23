package com.czx.reflect;

public class Person {

	private int age;
	private String name;
	private String sex;
	private String position;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public Person() {
		super();
	}
	public Person(int age, String name, String sex, String position) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
		this.position = position;
	}
	
	
}
