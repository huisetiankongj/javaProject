package com.czx.application.xstream.demo01;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("person")
public class Person {

	@XStreamAlias("firstName")
	private String firstName;
	@XStreamAlias("lastName")
	private String lastName;

	private String l1="≤‚ ‘";
	
	@XStreamAlias("telphone")
	private PhoneNumber tel;
	@XStreamAlias("faxphone")
	private PhoneNumber fax;
	@XStreamAlias("friend")
	private Friends friend;
	@XStreamAlias("pet")
	private Pets pet;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public PhoneNumber getTel() {
		return tel;
	}
	public void setTel(PhoneNumber tel) {
		this.tel = tel;
	}
	public String getL1() {
		return l1;
	}
	public void setL1(String l1) {
		this.l1 = l1;
	}
	public PhoneNumber getFax() {
		return fax;
	}
	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}
	public Friends getFriend() {
		return friend;
	}
	public void setFriend(Friends friend) {
		this.friend = friend;
	}
	public Pets getPet() {
		return pet;
	}
	public void setPet(Pets pet) {
		this.pet = pet;
	}
	
	
	
	
}
