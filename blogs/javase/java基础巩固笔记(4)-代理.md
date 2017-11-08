# java基础巩固笔记(4)-代理

标签： java

---

**Contents**

- [java基础巩固笔记(4)-代理](#java基础巩固笔记4-代理)
  - [概念](#概念)
  - [动态代理](#动态代理)
    - [创建动态类](#创建动态类)
    - [动态代理的工作原理](#动态代理的工作原理)
    - [面向切面编程](#面向切面编程)
  - [参考资料](#参考资料)



---

代理是实现AOP(Aspect oriented program，面向切面编程)的核心和关键技术。

## 概念
代理是一种设计模式，其目的是为其他对象提供一个代理以控制对某个对象的访问，代理类负责为委托类预处理消息，过滤消息并转发消息以及进行消息被委托类执行后的后续处理。为了保持行为的一致性，代理类和委托类通常会实现相同的接口

- 静态代理：由程序员创建代理类或特定工具自动生成源代码再对其编译，也就是说在程序运行前代理类的.class文件就已经存在。
- 动态代理：在程序运行时运用反射机制动态创建生成。

![代理架构图](http://7xph6d.com1.z0.glb.clouddn.com/javaSE_%E4%BB%A3%E7%90%86%E6%9E%B6%E6%9E%84%E5%9B%BE.png)

*紫色箭头代表类的继承关系，红色连线表示调用关系*


## 动态代理

- JVM可以在运行期动态生成类的字节码，该类往往被用作动态代理类。
- JVM生成的动态类必须实现一个或多个接口，所以这种只能用作具有相同接口的目标类的代理。
- CGLIB库可以动态生成一个类的子类，一个类的子类也可作为该类的代理，这个可用来为没有实现接口的类生成动态代理类。
- 代理类可在*调用目标方法之前、之后、前后、以及处理目标方法异常的catch块中*添加系统功能代码。

### 创建动态类
API:

> [java.lang.reflect:Class Proxy](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/reflect/Proxy.html)
> [java.lang.reflect:Interface InvocationHandler](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/reflect/InvocationHandler.html)

- 查看代理类方法列表信息

```java
package com.iot.proxy;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by brian on 2015/12/27.
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazzProxy1);
        printConstructors(clazzProxy1);
        printMethods(clazzProxy1);

    }

    /**
     * 打印构造方法列表
     * @param clazz
     */
    public static void printConstructors(Class clazz){
        System.out.println("-------------constructors list-------------");
        Constructor[] constructors = clazz.getConstructors();
        System.out.print(getExecutableList(constructors));
    }

    /**
     * 打印成员方法列表
     * @param clazz
     */
    public static void printMethods(Class clazz) {
        System.out.println("-------------methods list-------------");
        Method[] methods = clazz.getMethods();
        System.out.print(getExecutableList(methods));
    }

    /**
     * 获取要打印的列表数据
     * 每行一个方法,按照func(arg1,arg2)的格式
     * @param executables
     * @return
     */
    public static String getExecutableList(Executable[] executables){
        StringBuilder stringBuilder = new StringBuilder();
        for (Executable executable : executables) {
            String name = executable.getName();
            stringBuilder.append(name);
            stringBuilder.append("(");
            Class[] clazzParams = executable.getParameterTypes();
            for (Class clazzParam : clazzParams) {
                stringBuilder.append(clazzParam.getName()).append(",");
            }
            if (clazzParams != null && clazzParams.length != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(")\n");
        }
        return stringBuilder.toString();
    }


}
```

输出结果：

```
class com.sun.proxy.$Proxy0
-------------constructors list-------------
com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler)
-------------methods list-------------
add(java.lang.Object)
remove(java.lang.Object)
equals(java.lang.Object)
toString()
hashCode()
clear()
contains(java.lang.Object)
isEmpty()
iterator()
size()
toArray([Ljava.lang.Object;)
toArray()
spliterator()
addAll(java.util.Collection)
stream()
forEach(java.util.function.Consumer)
containsAll(java.util.Collection)
removeAll(java.util.Collection)
removeIf(java.util.function.Predicate)
retainAll(java.util.Collection)
parallelStream()
isProxyClass(java.lang.Class)
getInvocationHandler(java.lang.Object)
getProxyClass(java.lang.ClassLoader,[Ljava.lang.Class;)
newProxyInstance(java.lang.ClassLoader,[Ljava.lang.Class;,java.lang.reflect.InvocationHandler)
wait()
wait(long,int)
wait(long)
getClass()
notify()
notifyAll()
```

- 创建实例对象

```java
/**
 * 测试创建实例对象
 * @throws NoSuchMethodException
 * @throws IllegalAccessException
 * @throws InvocationTargetException
 * @throws InstantiationException
 */
private static void createProxyInstance( ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    /**
     * 方法1：先创建代理类，再使用反射创建实例对象
     */
    Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
    Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
    Collection proxy1 = (Collection) constructor.newInstance(new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    });

    /**
     * 方法2：直接使用newProxyInstance方法创建实例对象
     */
    Collection proxy2 = (Collection)Proxy.newProxyInstance(
            Collection.class.getClassLoader(),
            new Class[]{Collection.class},
            new InvocationHandler() {
                ArrayList target = new ArrayList();
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //ArrayList targetTmp = new ArrayList();
            System.out.println("before invoke method: "+method.getName());
            return method.invoke(target,args);

        }
    });

    proxy2.add("aaa");
    proxy2.add("bbb");
    System.out.println(proxy2.size());
    System.out.println(proxy2);
    System.out.println(proxy2.getClass().getName());

}
```

输出结果：

```
before invoke method: add
before invoke method: add
before invoke method: size
2
before invoke method: toString
[aaa, bbb]
com.sun.proxy.$Proxy0
```

上述代码相关说明:

- 若将`method.invoke(target,args);`改为`method.invoke(proxy,args);`会出现死循环
- 从输出结果可知，每次调用代理类的方法，实际都是调用`invoke`方法
- 若将`method.invoke(target,args);`改为`method.invoke(targetTmp,args);`，则`proxy2.size()`为0。因为每次调用`invoke`方法时，`targetTmp`为新的局部变量
- `Object`类只有的`hashCode`, `equals`, or `toString`方法会被交到`InvocationHandler`，其他方法自己有实现，不交给handler,所以最后打印结果为`com.sun.proxy.$Proxy0`而不是`Collection`


- `InvocationHandler`对象的运行原理**

`InvocationHandler`接口只有一个`invoke`方法，每次调用代理类的方法，即调用了`InvocationHandler`对象的`invoke`方法

`invoke`方法涉及三个要素：

- 代理对象
- 代理对象调用的方法
- 方法接受的参数

注：Object类的`hashCode`,`equals`,`toString`方法交给invoke,其他的Object类的方法，Proxy有自己的实现。

> If a proxy interface contains a method with the same name and parameter signature as the hashCode, equals, or toString methods of java.lang.Object, when such a method is invoked on a proxy instance, the Method object passed to the invocation handler will have java.lang.Object as its declaring class. In other words, the public, non-final methods of java.lang.Object logically precede all of the proxy interfaces for the determination of which Method object to pass to the invocation handler.


### 动态代理的工作原理

代理类创建时需要传入一个InvocationHandler对象，client调用代理类，代理类的相应方法调用InvocationHandler的的invoke方法，InvocationHandler的invoke方法(可在其中加入日志记录、时间统计等附加功能)再找目标类的相应方法。

![动态代理的工作原理图](http://7xph6d.com1.z0.glb.clouddn.com/javaSE_%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E7%9A%84%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%9B%BE.jpg)

### 面向切面编程

把切面的代码以**对象**的形式传递给InvocationHandler的invoke方法，invoke方法中执行该对象的方法就执行了切面的代码。

所以需要传递两个参数：

1.目标(Object target)
2.通知(自定义的adviser类)

定义`Advice`接口

```java
public interface Advice {
    void beforeMethod(Method method);
    void aftereMethod(Method method);
}
```

一个实现`Advice`接口的类`MyAdvice`,用于打印执行方法前和执行后的时间

```java
import java.lang.reflect.Method;

public class MyAdvice implements Advice{
    long beginTime = 0 ;
    @Override
    public void beforeMethod(Method method) {
        System.out.println(method.getName()+" before at "+beginTime);
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void aftereMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName()+" cost total "+ (endTime-beginTime));
    }
}
```

定义一个`getProxy`方法创建实例对象,接收两个参数:目标和通知

```java
private static Object getProxy(final Object target,final Advice advice){
    Object proxy = Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    advice.beforeMethod(method);
                    Object retVal = method.invoke(target,args);
                    advice.aftereMethod(method);
                    return retVal;
                }
            }
    );
    return proxy;
}
```


调用：

```java
Collection proxy3 = (Collection) getProxy(new ArrayList(),new MyAdvice());
proxy3.add("111");
proxy3.add("222");
System.out.println(proxy3.size());
```

输出:

```
add before at 0
add cost total 0
add before at 1454433980839
add cost total 0
size before at 1454433980839
size cost total 0
2
```


## 参考资料

>* [Java动态代理的实现机制](http://developer.51cto.com/art/201509/492614.htm)
>* [Java基础加强总结(三)——代理(Proxy)](http://www.cnblogs.com/xdp-gacl/p/3971367.html)



---------

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)
