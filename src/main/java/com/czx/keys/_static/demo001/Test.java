package com.czx.keys._static.demo001;

/**
 * 执行过程:
 * 	首先加载Test类，执行Test类中的static块。
 * 	接着执行new MyClass(),而MyClass类还没被加载，则需要加载MyClass类。
 * 	在加载MyClass类的时候，发现MyClass类继承Test类，但是由于Test类已经被加载了，
 * 	所以只需要加载MyClass类，那么就会执行MyClass类的static块。在加载完后，
 * 	就通过构造器来生成对象，而在生成对象的过程中，必须先初始化类的成员变量，因此会执行Test
 * 	中的Person person = new Person(),而Person类还没有被加载过，因此会先加载
 * 	Person类并执行static块。并执行父类的构造器，完成父类的初始化，然后就可以初始化自身了。
 * 	因此会接着执行MyClass中的Person person = new Person()，最后执行MyClass的构造器
 * @author Administrator
 *
 */
public class Test {
	Person person = new Person("Test");
	static{
		System.out.println("test static");
	}
	public Test(){
		System.out.println("test constructor");
	}
	public static void main(String[] args) {
		new MyClass();
	}
}
class Person {
	static{
		System.out.println("person static");
	}
	public Person(String str){
		System.out.println("person "+str);
	}
	
}
class MyClass extends Test{
	Person person = new Person("myClass");
	static{
		System.out.println("myClass static");
	}
	
	public MyClass(){
		System.out.println("myClass constructor");
	}
}