package com.czx.pattern.singleton.demo01;

/**
 * ����ʽ����ʵ��
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
