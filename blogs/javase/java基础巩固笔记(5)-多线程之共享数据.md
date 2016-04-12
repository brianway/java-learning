# java基础巩固笔记(5)-多线程之共享数据

标签： java

---

**Contents**

- [java基础巩固笔记(5)-多线程之共享数据](#java基础巩固笔记5-多线程之共享数据)
  - [线程范围内共享数据](#线程范围内共享数据)
    - [ThreadLocal类](#threadlocal类)
  - [多线程访问共享数据](#多线程访问共享数据)
    - [几种方式](#几种方式)



---


本文主要总结线程共享数据的相关知识，主要包括两方面:一是某个线程内如何共享数据，保证各个线程的数据不交叉；一是多个线程间如何共享数据，保证数据的一致性。


## 线程范围内共享数据

自己实现的话，是定义一个Map,线程为键，数据为值,表中的每一项即是为每个线程准备的数据,这样在一个线程中数据是一致的。

例子

```java
package com.iot.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by brian on 2016/2/4.
 */
public class ThreadScopeShareData {
    //准备一个哈希表，为每个线程准备数据
    private  static Map<Thread,Integer> threadData = new HashMap<>();
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    threadData.put(Thread.currentThread(),data);
                    System.out.println(Thread.currentThread()+" put data："+data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
   static  class A{
        public void get(){
            int data = threadData.get(Thread.currentThread());
            System.out.println("A from "+Thread.currentThread()+" get data "+data);
        }
    }

    static  class B{
        public void get(){
            int data = threadData.get(Thread.currentThread());
            System.out.println("B from "+Thread.currentThread()+" get data "+data);
        }
    }
}


```


上述代码偶尔会报异常：

```
Exception in thread "Thread-0" java.lang.NullPointerException
	at com.iot.thread.ThreadScopeShareData$A.get(ThreadScopeShareData.java:29)
	at com.iot.thread.ThreadScopeShareData$1.run(ThreadScopeShareData.java:21)
	at java.lang.Thread.run(Thread.java:745)

```

具体原因还不知道


### ThreadLocal类

API:

> [`java.lang:Class ThreadLocal<T>`](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/ThreadLocal.html)

- 单变量

使用`ThreadLocal`类型的对象代替上面的`Map`即可

- 多变量

定义一个对象来封装多个变量，然后在ThreadLocal中存储整个对象

多变量时，最好将ThreadLocal类放在数据类的内部，数据类采用单例模式，这样，新建对象和获取对象都会更方便，同时封装性更强。

示例代码:

```java
package com.iot.thread;

import java.util.Random;

/**
 * Created by brian on 2016/2/4.
 */
public class ThreadLocalTest {
    private  static ThreadLocal<Integer> threadInger = new ThreadLocal<>();
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(100);
                    threadInger.set(data);
                    System.out.println(Thread.currentThread()+" put data："+data);
                    MyThreadScopeData.getThreadInstance().setName(Thread.currentThread().toString());
                    MyThreadScopeData.getThreadInstance().setAge(data%10);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    static  class A{
        public void get(){
            int data = threadInger.get();
            System.out.println("A from "+Thread.currentThread()+" get data "+data);
            MyThreadScopeData myThreadScopeData = MyThreadScopeData.getThreadInstance();
            System.out.println("A from "+myThreadScopeData);

        }
    }

    static  class B{
        public void get(){
            int data = threadInger.get();
            System.out.println("B from "+Thread.currentThread()+" get data "+data);
            MyThreadScopeData myThreadScopeData = MyThreadScopeData.getThreadInstance();
            System.out.println("B from "+myThreadScopeData);
        }
    }
}

/**
 * 将多变量封装起来的数据类
 * 单例模式，内置ThreadLocal类型变量
 */
class MyThreadScopeData{

    private MyThreadScopeData(){}

    private static ThreadLocal<MyThreadScopeData> data = new ThreadLocal<>();

    public static  MyThreadScopeData getThreadInstance(){
        MyThreadScopeData instance = data.get();
        if(instance == null){
            instance = new MyThreadScopeData();
            data.set(instance);
        }
        return instance;
    }



    private String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String reVal = super.toString()+"-{name,age}"+":{"+getName()+","+getAge()+"}";
        return reVal;
    }
}
```


## 多线程访问共享数据

### 几种方式

- 线程执行代码相同，使用同一Runnable对象，Runnable对象中有共享数据
- 线程执行代码不同，将共享数据封装在另一对象中（操作数据的方法也在该对象完成），将这个对象逐一传递给各个Runnable对象。[**本质：共享数据的对象作为参数传入Runnable对象**]
- 线程执行代码不同，将Runnable对象作为某一个类的内部类，共享数据作为这个外部类的成员变量（操作数据的方法放在外部类）。[**本质:不同内部类共享外部类数据**]
- 结合上两种方式，将共享数据封装在另一对象中（操作数据的方法也在该对象完成），该对象作为这个外部类的成员变量，将Runnable对象作为内部类


最后一种方式的示例:

设计5个线程，其中三个线程每次对j增加1，另外两个线程对j每次减少1

```java
package com.iot.thread;

/**
 * Created by brian on 2016/2/4.
 */
public class MutiThreadShareData {

    private static MutiShareData mutiShareData = new MutiShareData();

    public static void main(String[] args) {
        
        for(int i=0;i<3;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread()+":{j from "+ mutiShareData.getJ()+" + to: "+mutiShareData.increment()+"}");
                        }
                    }
            ).start();
        }

        for(int i=0;i<2;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread()+":{j from "+ mutiShareData.getJ()+" - to: "+mutiShareData.decrement()+"}");
                        }
                    }
            ).start();
        }
    }

}

/**
 * 将共享数据封装在另一对象中（操作数据的方法也在该对象完成）
 */
class MutiShareData{
    private int j = 0;
    public synchronized  int increment(){
        return  ++j;
    }
    public synchronized int  decrement(){
        return --j;
    }

    public synchronized int getJ() {
        return j;
    }

    public synchronized void setJ(int j) {
        this.j = j;
    }
}
```


-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)







