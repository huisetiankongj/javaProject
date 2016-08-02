package com.czx.pattern.singleton.demo01;

/**
 * 懒汉式单例实现
 * @author admin
 *
 */
public class LazySingleton {

	private static LazySingleton instance = null;
	
	public static synchronized LazySingleton getInstance(){
		 if(instance==null){
               instance=new LazySingleton();
         }
         return instance;
	}
}
