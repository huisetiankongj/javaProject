package com.czx.reflect;

import java.lang.reflect.Field;


public class ReflectUtil {

	public static <T> void reflectTest01(T test) throws Exception{
		Class<?> classType = test.getClass();
		Field[] fs = classType.getDeclaredFields();
		//����˽�б���һ��Ҫ�������
		Field.setAccessible(fs,true); 
		for(int j=0,fsLen=fs.length;j<fsLen;j++){
			System.out.println(fs[j].get(test));
		}
	}
	
	public static void main(String[] args) throws Exception {
		Person p = new Person(11,"���","��","�߹�");
		ReflectUtil.reflectTest01(p);
	}
	
}
