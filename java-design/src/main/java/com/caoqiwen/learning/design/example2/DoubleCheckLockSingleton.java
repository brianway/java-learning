package com.caoqiwen.learning.design.example2;

/**
 * Created by caoqiwen on 2017/12/13.
 */
public class DoubleCheckLockSingleton {
    private volatile  static  DoubleCheckLockSingleton instance=null;
//    private  static  Object object=new Object();

    private DoubleCheckLockSingleton(){

    }

    /**
     * 线程安全的单例
     * @return
     */
    public  static  DoubleCheckLockSingleton getInstance(){
        if (instance==null){
            synchronized (DoubleCheckLockSingleton.class){
                if (instance==null){
                    instance=new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }

    public  void get(){
        synchronized (this){
            System.out.println("hello world");
        }
    }

}
