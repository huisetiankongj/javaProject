package com.czx.pattern.singleton.demo01;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 实现原理：我们不让线程每次都加锁，而只是在实例未被创建的时候再加锁。
 * 同时也能保证多线程的安全，对于instance存在的情况就直接返回；
 * 当instance不存在，并且同时有两个线程调用getInstance()方法时，
 * 它们都可以通过第一重instance == null判断，
 * 然后由于synchronizd锁机制，两个线程只有一个能进入，另一个在外排队等候，
 * 必须要其中的一个进入并出来之后另一个才能进入。
 * 如果没有了第二重的instance == null的判断，则第一个线程创建了实例，
 * 第二个线程还是可以载继续创建实例的
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能;
 * @author admin
 *
 */
public class DoubleCheckedSingleton {

	private static volatile  DoubleCheckedSingleton dcSingleton= null; 
	
	public static DoubleCheckedSingleton getInstance(){
		if(dcSingleton==null){
			synchronized (DoubleCheckedSingleton.class) {
				if(dcSingleton==null)
					dcSingleton = new DoubleCheckedSingleton();	
			}
		}
		return dcSingleton;
	}
}
