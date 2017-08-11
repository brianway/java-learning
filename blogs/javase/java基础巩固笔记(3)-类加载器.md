# java基础巩固笔记(3)-类加载器

标签： java

---

**Contents**

- [java基础巩固笔记(3)-类加载器](#java基础巩固笔记3-类加载器)
  - [默认类加载器](#默认类加载器)
  - [类加载器的委托机制](#类加载器的委托机制)
  - [自定义类加载器的编写原理](#自定义类加载器的编写原理)
  - [参考资料](#参考资料)



---


java类加载器就是在运行时在JVM中动态地加载所需的类，java类加载器基于三个机制：委托，可见，单一。

把 classpath 下的那些 `.class` 文件加载进内存，处理后形成可以被虚拟机直接使用的 Java 类型，这些工作是类加载器做的。

- **委托机制**指的是将加载类的请求传递给父加载器，如果父加载器找不到或者不能加载这个类，那么再加载他。
- **可见性机制**指的是父加载器加载的类都能被子加载器看见，但是子加载器加载的类父加载器是看不见的。
- **单一性机制**指的是一个类只能被同一种加载器加载一次。


## 默认类加载器
系统默认三个类加载器:

- `BootStrap`
- `ExtClassLoader`
- `AppClassLoader`

*类加载器也是java类，而BootStrap不是。*
验证代码：

```java
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(System.class.getClassLoader());
    }
}
```
输出：`null`

如果使用`System.out.println(System.class.getClassLoader().toString);`，则报空指针异常:

```
Exception in thread "main" java.lang.NullPointerException
	at com.iot.classloader.ClassLoaderTest.main(ClassLoaderTest.java:10)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
```

可见，System类是由BootStrap类加载器加载。

## 类加载器的委托机制
类加载器的树状图

![类加载器](http://7xph6d.com1.z0.glb.clouddn.com/javaSE_%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E7%BB%93%E6%9E%84%E5%9B%BE.png)


一般加载类的顺序：

- 首先当前线程的类加载器去加载线程中的第一个类
- 如果类A应用了类B，java虚拟机将使用加载类A的类加载器来加载类B
- 还可以直接调用ClassLoader.loadClass()方法来指定某个类加载器去加载某个类

-------------------

## 自定义类加载器的编写原理

API:

> [Class ClassLoader](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/ClassLoader.html)

模板方法设计模式

父类:

- `loadClass`(类加载的流程，模板)
- `findClass`供子类覆盖的、被`loadClass`方法调用的类加载逻辑
- `defineClass`得到class文件转换成字节码

子类:覆盖`findClass`方法

例子：

`loadClass`方法的源码

```java
protected Class<?> loadClass(String name, boolean resolve)
    throws ClassNotFoundException
{
    synchronized (getClassLoadingLock(name)) {
        // First, check if the class has already been loaded
        Class<?> c = findLoadedClass(name);
        if (c == null) {
            long t0 = System.nanoTime();
            try {
                if (parent != null) {
                    c = parent.loadClass(name, false);
                } else {
                    c = findBootstrapClassOrNull(name);
                }
            } catch (ClassNotFoundException e) {
                // ClassNotFoundException thrown if class not found
                // from the non-null parent class loader
            }

            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                c = findClass(name);

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
        }
        if (resolve) {
            resolveClass(c);
        }
        return c;
    }
}
```

API文档中的例子:

```java
class NetworkClassLoader extends ClassLoader {
     String host;
     int port;

     public Class findClass(String name) {
         byte[] b = loadClassData(name);
         return defineClass(name, b, 0, b.length);
     }

     private byte[] loadClassData(String name) {
         // load the class data from the connection
          . . .
     }
 }
```



## 参考资料

>* [java类加载机制工作原理](http://ju.outofmemory.cn/entry/142486)
>* [Java类加载器总结 - 寂静大海 - 博客频道 - CSDN.NET](http://blog.csdn.net/gjanyanlig/article/details/6818655)


---------

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)
