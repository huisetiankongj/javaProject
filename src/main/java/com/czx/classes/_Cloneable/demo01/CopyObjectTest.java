package com.czx.classes._Cloneable.demo01;

import org.junit.Test;

public class CopyObjectTest {

	//简单对象拷贝
	@Test
	public void singleCopy() throws Exception{
		Student s1 = new Student();
		s1.setName("czx");
		s1.setAge(20);
		System.out.println(s1.getName()+"========="+s1.getAge());
		Student s2 = (Student) s1.clone();
		s2.setAge(25);
		System.out.println(s2.getName()+"========="+s2.getAge());
	}
	
	/**
	 * 浅、深拷贝
	 * @throws Exception 
	 */
	@Test
	public void lightAndDeepCopy() throws Exception{
		Teacher t1 = new Teacher();
		t1.setName("t1");
		t1.setAge(35);
		Address address = new Address();
		address.setAddress("福建省");
		t1.setAdd(address);
		Teacher t2 = (Teacher) t1.clone();
		
		System.out.println(t2.getAdd().getAddress()+"======"+t1.getAdd().getAddress());
	
		address.setAddress("湖南省");
		System.out.println(t2.getAdd().getAddress()+"======"+t1.getAdd().getAddress());
	}
}

class Student implements Cloneable{
	private int age;
	private String name;
	
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
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student stu = null;
		try{ 
            stu = (Student)super.clone(); 
        }catch(CloneNotSupportedException e) { 
            e.printStackTrace(); 
        } 
        return stu; 
	}
	
	
}

class Teacher implements Cloneable{
	private int age;
	private String name;
	private Address add;
	
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
	
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Teacher teacher = null;
		try{ 
            teacher = (Teacher)super.clone(); //浅复制
            teacher.add = (Address)add.clone();//深度复制
        }catch(CloneNotSupportedException e) { 
            e.printStackTrace(); 
        } 
        return teacher; 
	}
	
	
}

class Address implements Cloneable{
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Address add = null;
		add = (Address)super.clone();
		return add;
	}
	
}