# java基础巩固笔记(5)-多线程之传统多线程

标签： java

---

**Contents**

- [java基础巩固笔记(5)-多线程之传统多线程](#java基础巩固笔记5-多线程之传统多线程)
- [传统线程技术](#传统线程技术)
  - [传统创建线程方式](#传统创建线程方式)
  - [传统定时器技术](#传统定时器技术)
  - [互斥](#互斥)
  - [同步](#同步)



---



# 传统线程技术


## 传统创建线程方式

1.继承Thread类，覆盖run方法

```java
Thread t = new Thread();
t.start();
```

2.实现Runnable接口

Runnable不是线程，是线程要运行的代码的宿主。

1.看看Thread类源码，捋清Runnable，target,run,start关系

- `Runnable`是一个接口
- `target`是`Thread`类中类型为`Runnable`，名为`target`的属性
- `run`是`Thread`类实现了`Runnable`的接口，重写的方法。
- `start`是启动线程的方法
- **在`Thread`类中，调用关系为：`start`->`start0`->`run`->`target.run`**

`Thread`类的`run`方法源码

```java
public void run() {
    if (target != null) {
        target.run();
    }
}
```

`Thread`类的`target`属性

```java
/* What will be run. */
private Runnable target;
```

`target`属性由`private void init(ThreadGroup g, Runnable target, String name,long stackSize, AccessControlContext acc)`方法初始化。`init`方法在`Thread`类的构造方法里被调用




2.匿名内部类对象的构造方法如何调用父类的非默认构造方法



## 传统定时器技术

API：

>[java.util:Class Timer](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Timer.html)

例子：一个定时器实现交替2秒、3秒打印

```java
static int count = 0;
public static void main(String[] args) {

    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            System.out.println(Thread.currentThread()+" bomb!");
            new Timer().schedule(new MyTimerTask(), 2000+1000*(count++%2));
        }
    }
    //3s后开启定时器
    new Timer().schedule(new MyTimerTask(),3000);
}
```

可以使用`quarlz`开源工具




## 互斥

关键字:`synchronized`，检查锁对象

- `synchronized(this)`
- `synchronized void function(){}`
- `synchronized(A.class)`

## 同步

经验：

>* 要用到共同数据(包括同步锁)或共同算法的若干个方法应该归在同一个类身上，这种设计体现了高聚类和程序的健壮性。
>* 同步互斥不是在线程上实现，而是在线程访问的资源上实现，线程调用资源。

例子: 子线程循环5次，主线程循环10次，如此交替50次

设计：

使用一个Business类来包含子线程和主线程要运行的代码，从而，该类的对象成为加锁的对象。同步互斥在该类实现，由线程调用该类的方法，即调用了资源。

代码：

```java
/**
 * Created by brian on 2016/2/4.
 */
public class TraditionalThreadCommunication {
    public static void main(String[] args) {
        Business business = new Business();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=1;i<=50;i++){
                            business.sub(i);
                        }
                    }
                }
        ).start();

        for(int i=1;i<=50;i++){
            business.main(i);
        }

    }
}

class Business{
    private boolean bShouldSub = true;

    public synchronized void sub(int i){
        while(!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1;j<=5;j++){
            System.out.println("sub thread count "+j+","+i+"/50");
        }
        bShouldSub = false;
        this.notify();
    }
    public synchronized void main(int i){
        while(bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1;j<=10;j++){
            System.out.println("main thread count "+j+","+i+"/50");
        }
        bShouldSub = true;
        this.notify();
    }
}
```

判断条件时，while与if的区别:while防止伪唤醒


------------------

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)
