package com.brianway.learning.java.multithread.meet;

/**
 * Created by brian on 2016/4/11.
 */

/**
 * P18
 * isAlive()
 */
class MyThread4 extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}

public class Run4_isAlive01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread4 myThread4 = new MyThread4();
        System.out.println("begin == " + myThread4.isAlive());
        myThread4.start();
        //Thread.sleep(1000);
        System.out.println("end == " + myThread4.isAlive());
    }

}

/*
输出：
begin == false
end == true
run=true

--------------
Thread.sleep(1000);

输出：
begin == false
run=true
end == false

*/

