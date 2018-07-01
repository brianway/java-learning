package com.brianway.learning.java.base.reflection;

import java.lang.reflect.Field;

/**
 * Created by caoqiwen on 2017/11/9.
 */
public class ReflectionClass {
    public static  void main(String []args) throws ClassNotFoundException {
      //  System.out.println("caoqwein");
        Class<?> c=Class.forName("com.brianway.learning.java.base.reflection.Reflection");
        Package p=c.getPackage();
//        System.out.println("Package.toString()：" + p.toString());
//        System.out.println("Package.getName()：" + p.getName());
        //field;
        Field[] fs0 = c.getFields();  //获取public权限的字段
        Field[] fs1=c.getDeclaredFields();   //获取所有权限的字段，包括public，protected，private的字段
        for (Field field:fs0){
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        for (Field field:fs1){
             field.setAccessible(true);
            System.out.println(field.getName());
        }


    }
}
