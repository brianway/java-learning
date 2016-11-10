package com.brianway.learning.java.base.innerclass;

/**
 * Created by brian on 16/11/10.
 *
 * 创建内部类的测试类
 */
public class ClassCreator {
    public static void main(String[] args) {
        //在其他类里创建非静态内部类和静态内部类
        EnclosingOne eo = new EnclosingOne();
        EnclosingOne.InsideOne io = eo.new InsideOne();
        EnclosingOne.InsideTwo it = new EnclosingOne.InsideTwo();
    }

}
