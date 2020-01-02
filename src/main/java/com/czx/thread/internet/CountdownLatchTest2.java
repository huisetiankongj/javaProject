package com.czx.thread.internet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountdownLatchTest2 implements Runnable{

    final AtomicInteger number = new AtomicInteger();
    private volatile boolean bool = true;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountdownLatchTest2 test = new CountdownLatchTest2();
        for (int i=0;i<10;i++) {
            pool.execute(test);
        }
    }

    public void run() {
        synchronized (this){
            try {
                if(!bool) {
                    System.out.println(bool);
                    bool = true;
                    Thread.sleep(10000);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("并发数量为" + number.intValue());
        }
    }


}
