package com.brianway.learning.java.multithread.singleton.example3;

/**
 * Created by Brian on 2016/4/16.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * p273
 * 序列化与反序列化的单例模式实现
 */
public class Run3_singleton2 {
    public static void main(String[] args) {
        try {
            MyObject2 myObject = MyObject2.getInstance();
            FileOutputStream fos = new FileOutputStream(new File("myObject.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myObject);
            oos.close();
            fos.close();
            System.out.println(myObject.hashCode() + " " + myObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(new File("myObject.txt"));
            ObjectInputStream ios = new ObjectInputStream(fis);
            MyObject2 myObject = (MyObject2) ios.readObject();
            ios.close();
            fis.close();
            System.out.println(myObject.hashCode() + " " + myObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


/*
输出:
325040804 com.brianway.learning.java.multithread.singleton.example3.MyObject2@135fbaa4
1173230247 com.brianway.learning.java.multithread.singleton.example3.MyObject2@45ee12a7

------------------------
取消MyObject2中protected Object readResolve()的注释
输出:
325040804 com.brianway.learning.java.multithread.singleton.example3.MyObject2@135fbaa4
调用了readResolve方法
325040804 com.brianway.learning.java.multithread.singleton.example3.MyObject2@135fbaa4

 */