package com.czx.thread.internet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(3);

        for(int i=0,len=3;i<len;i++){
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"正准备接受命令");
                        cdOrder.await();
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "已接受命令");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "回应命令处理结果");
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        cdAnswer.countDown(); //任务执行完毕，返回给指挥官，cdAnswer减1。
                    }
                }
            };
            service.execute(runnable);//为线程池添加任务
        }

        try {
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("线程" + Thread.currentThread().getName() +
                    "即将发布命令");
            cdOrder.countDown(); //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
            System.out.println("线程" + Thread.currentThread().getName() +
                    "已发送命令，正在等待结果");
            cdAnswer.await(); //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
            System.out.println("线程" + Thread.currentThread().getName() +
                    "已收到所有响应结果");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cdAnswer.countDown(); //任务执行完毕，返回给指挥官，cdAnswer减1。
        }

        service.shutdown(); //任务结束，停止线程池的所有线程
    }

}
