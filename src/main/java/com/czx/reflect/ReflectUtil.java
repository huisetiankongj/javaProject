package com.czx.reflect;

import java.lang.reflect.Field;


public class ReflectUtil {

	public static <T> void reflectTest01(T test) throws Exception{
		Class<?> classType = test.getClass();
		Field[] fs = classType.getDeclaredFields();
		//访问私有变量一旦要设置这个
		Field.setAccessible(fs,true); 
		for(int j=0,fsLen=fs.length;j<fsLen;j++){
			System.out.println(fs[j].get(test));
		}
	}
	
	public static void main(String[] args) throws Exception {
		Person p = new Person(11,"侧很","男","高管");
		ReflectUtil.reflectTest01(p);
	}
	
}
