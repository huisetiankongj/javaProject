package com.czx.keys.statics;

/**
 * static 用法
 * 被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问
 * 非静态成员方法中是可以访问静态成员方法/变量
 * 即使没有显示地声明为static，类的构造器实际上也是静态方法
 * 
 * 1、static变量
 * 	静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。
 * 	而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。
 * 	静态变量被所有对象共享的
 * 2、static代码块
 * 	static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。
 * 	static块可以置于类中的任何地方，类中可以有多个static块。
 * 	在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次
 * @author Administrator
 *
 */
public class Statics {

}
