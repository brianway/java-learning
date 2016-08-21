package com.brianway.learning.java.multithread.synchronize.example12;

/**
 * Created by Brian on 2016/4/13.
 */

/**
 * P107
 * 死锁测试
 * jstack命令
 */
public class Run12_deadLock {
    public static void main(String[] args) {
        try {
            DealThread t1 = new DealThread();
            t1.setFlag("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


/*
输出：
username = a
username = b

---------------------------


G:\mygit\java-learning>jps
4752
7524 Jps
8936 Launcher

(启动Run12_deadLock的main方法)

G:\mygit\java-learning>
G:\mygit\java-learning>jps
4752
8948 AppMain
6344 Jps
8732 Launcher

G:\mygit\java-learning>jstack -l 8948
2016-04-13 15:04:01
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.25-b02 mixed mode):

"DestroyJavaVM" #13 prio=5 os_prio=0 tid=0x00000000022df000 nid=0x18dc waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Thread-1" #12 prio=5 os_prio=0 tid=0x0000000058773800 nid=0x20f0 waiting for monitor entry [0x0000000059c1f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.brianway.learning.java.multithread.synchronize.example12.DealThread.run(DealThread.java:41)
        - waiting to lock <0x00000000d61411d0> (a java.lang.Object)
        - locked <0x00000000d61411e0> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
        - None

"Thread-0" #11 prio=5 os_prio=0 tid=0x000000005875a000 nid=0x1de8 waiting for monitor entry [0x00000000599bf000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.brianway.learning.java.multithread.synchronize.example12.DealThread.run(DealThread.java:27)
        - waiting to lock <0x00000000d61411e0> (a java.lang.Object)
        - locked <0x00000000d61411d0> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
        - None

"Monitor Ctrl-Break" #10 daemon prio=5 os_prio=0 tid=0x000000005876e800 nid=0x1f50 runnable [0x000000005969f000]
   java.lang.Thread.State: RUNNABLE
        at java.net.DualStackPlainSocketImpl.accept0(Native Method)
        at java.net.DualStackPlainSocketImpl.socketAccept(DualStackPlainSocketImpl.java:131)
        at java.net.AbstractPlainSocketImpl.accept(AbstractPlainSocketImpl.java:404)
        at java.net.PlainSocketImpl.accept(PlainSocketImpl.java:199)
        - locked <0x00000000d621bce8> (a java.net.SocksSocketImpl)
        at java.net.ServerSocket.implAccept(ServerSocket.java:545)
        at java.net.ServerSocket.accept(ServerSocket.java:513)
        at com.intellij.rt.execution.application.AppMain$1.run(AppMain.java:90)
        at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
        - None

"Service Thread" #9 daemon prio=9 os_prio=0 tid=0x000000005736f800 nid=0x2194 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C1 CompilerThread2" #8 daemon prio=9 os_prio=2 tid=0x0000000058698800 nid=0x2330 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread1" #7 daemon prio=9 os_prio=2 tid=0x0000000058697800 nid=0x96c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread0" #6 daemon prio=9 os_prio=2 tid=0x0000000058646800 nid=0x1fac waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000005863a800 nid=0x2268 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000005735d000 nid=0x1e2c runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x0000000057306800 nid=0x62c in Object.wait() [0x000000005836f000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d5f86280> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:142)
        - locked <0x00000000d5f86280> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:158)
        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

   Locked ownable synchronizers:
        - None

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x00000000572fd800 nid=0x2254 in Object.wait() [0x000000005862f000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000000d5f85cf0> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Object.java:502)
        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:157)
        - locked <0x00000000d5f85cf0> (a java.lang.ref.Reference$Lock)

   Locked ownable synchronizers:
        - None

"VM Thread" os_prio=2 tid=0x00000000572f7000 nid=0x1ba8 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x000000000214d000 nid=0x2274 runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x000000000214e800 nid=0x1a74 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002150000 nid=0xad8 runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002151800 nid=0x668 runnable

"VM Periodic Task Thread" os_prio=2 tid=0x00000000586b0800 nid=0x2150 waiting on condition

JNI global references: 20


Found one Java-level deadlock:
=============================
"Thread-1":
  waiting to lock monitor 0x0000000057304218 (object 0x00000000d61411d0, a java.lang.Object),
  which is held by "Thread-0"
"Thread-0":
  waiting to lock monitor 0x0000000057300228 (object 0x00000000d61411e0, a java.lang.Object),
  which is held by "Thread-1"

Java stack information for the threads listed above:
===================================================
"Thread-1":
        at com.brianway.learning.java.multithread.synchronize.example12.DealThread.run(DealThread.java:41)
        - waiting to lock <0x00000000d61411d0> (a java.lang.Object)
        - locked <0x00000000d61411e0> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)
"Thread-0":
        at com.brianway.learning.java.multithread.synchronize.example12.DealThread.run(DealThread.java:27)
        - waiting to lock <0x00000000d61411e0> (a java.lang.Object)
        - locked <0x00000000d61411d0> (a java.lang.Object)
        at java.lang.Thread.run(Thread.java:745)

Found 1 deadlock.



 */