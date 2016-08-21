package com.brianway.learning.java.multithread.communication.example6;

/**
 * Created by Brian on 2016/4/14.
 */

/**
 * P155
 * wait等待条件变化
 */
public class Run6_waitOld {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract sub = new Subtract(lock);
        ThreadSubtract subtract1 = new ThreadSubtract("sub1", sub);
        subtract1.start();
        ThreadSubtract subtract2 = new ThreadSubtract("sub2", sub);
        subtract2.start();
        Thread.sleep(1000);
        ThreadAdd addThread = new ThreadAdd("add1", add);
        addThread.start();

    }
}

/*
输出：
begin wait(),ThreadName=sub1
begin wait(),ThreadName=sub2
end wait(),  ThreadName=sub2
list size = 0
end wait(),  ThreadName=sub1
Exception in thread "sub1" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:653)
	at java.util.ArrayList.remove(ArrayList.java:492)
	at com.brianway.learning.java.multithread.communication.example6.Subtract.subtract(Subtract.java:22)
	at com.brianway.learning.java.multithread.communication.example6.ThreadSubtract.run(ThreadSubtract.java:16)

----------------------------
Subtract类使用while而不是if的话
while(ValueObject.list.size() == 0){
//if(ValueObject.list.size() == 0){

输出：
begin wait(),ThreadName=sub1
begin wait(),ThreadName=sub2
end wait(),  ThreadName=sub2
list size = 0
end wait(),  ThreadName=sub1
begin wait(),ThreadName=sub1
 */