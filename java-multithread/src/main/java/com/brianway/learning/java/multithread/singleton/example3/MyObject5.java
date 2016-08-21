package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */
public class MyObject5 {
    public enum MyEnumSingleton {
        ObjectFactory;
        private Object object;

        private MyEnumSingleton() {
            try {
                Thread.sleep(3000);//模拟初始化
                object = new Object();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Object getObject() {
            return object;
        }
    }

    public static Object getObject() {
        return MyEnumSingleton.ObjectFactory.getObject();
    }

}
