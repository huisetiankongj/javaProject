package com.czx.pattern.singleton.demo01;

/**
 * 恶汉式单例实现
 * @author admin
 *
 */
public class HungrySingleton {

	private static HungrySingleton singleton= new HungrySingleton();
	
    //这里提供了一个供外部访问本class的静态方法，可以直接访问
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
