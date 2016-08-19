package com.czx.application.xstream.demo01;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {

	public static void main(String[] args) {
	
		PhoneNumber tel = new PhoneNumber();
		tel.setCode(1);
		tel.setNumber("15859444540");
		
		Friends f = new Friends();
		List<String> nameList = new ArrayList<String>();
		nameList.add("g1");
		nameList.add("zx");
		nameList.add("ms");
		f.setName(nameList);
		
		Person person = new Person();
		person.setFirstName("zhixiong");
		person.setLastName("chen");
		person.setTel(tel);
		person.setFriend(f);
		
		XStream xstream=new XStream(new DomDriver("utf-8")); //ָ�����������
		xstream.processAnnotations(Person.class);//���û����䣬xml�еĸ�Ԫ�ػ���<��.����>������˵��ע�������û��Ч�����Ե�Ԫ���������������
		xstream.aliasSystemAttribute(null, "class");
		String xmlString=xstream.toXML(person);
		
		System.out.println(xmlString);
	}
}
