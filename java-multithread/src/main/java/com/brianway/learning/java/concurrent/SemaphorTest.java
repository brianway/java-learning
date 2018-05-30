package com.brianway.learning.java.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by caoqiwen on 2017/11/29.
 */
public class SemaphorTest {

    public static void main(String [] args){
        final Semaphore semaphore=new Semaphore(5,false);
          Runnable runnable=new Runnable() {
              @Override
              public void run() {
                  try {
                      semaphore.acquire();
                      System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
                      Thread.sleep(2000);
                      System.out.println(Thread.currentThread().getName() + "释放了信号量,时间为" + System.currentTimeMillis());
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  finally {
                      semaphore.release();
                  }
              }
          };
        Thread[] threads=new Thread[10];
        for (int i=0;i<10;i++){
             threads[i]=new Thread(runnable);
        }
        for (int i=0;i<10;i++){
            threads[i].start();
        }
    }
}
