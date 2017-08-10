# java基础巩固笔记(6)-注解

标签： java

---

**Contents**

  - [注解的应用结构图](#注解的应用结构图)
  - [元注解](#元注解)
  - [自定义注解](#自定义注解)
  - [示例代码](#示例代码)
  - [参考资料](#参考资料)



---


注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。


API

> [Package java.lang.annotation](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/annotation/package-summary.html)

## 注解的应用结构图

调用/结构关系：**A<--B<--C**

A,B,C解释如下：

A:注解类

```java
@interface A{
}
```

B:应用了“注解类”的类

```java
@A
Class B{
}
```

C:对“应用了注解类的类”进行反射操作的类

```java
Class C{
   public void f(){
     B.class.isAnnotationPresent(A.class);
     A a = B.class.getAnnotion(A.class);
   }
}
```

## 元注解

元注解的作用就是负责注解其他注解。四个元注解分别是：`@Target,@Retention,@Documented,@Inherited`

- `@Retention`

表示在什么级别保存该注解信息。可选的参数值在枚举类型 `RetentionPolicy`中，包括`RetentionPolicy.SOURCE`,`RetentionPolicy.CLASS`(默认),`RetentionPolicy.RUNTIME`分别对应：java源文件-->class文件-->内存中的字节码

```
RetentionPolicy.SOURCE 注解将被编译器丢弃 
RetentionPolicy.CLASS 注解在class文件中可用，但会被VM丢弃
RetentionPolicy.RUNTIME VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息。 
```

- `@Target`

表示该注解用于什么地方，可能的值在枚举类`ElemenetType`中,包括

```
ElemenetType.CONSTRUCTOR 构造器声明 
ElemenetType.FIELD 域声明（包括 enum 实例） 
ElemenetType.LOCAL_VARIABLE 局部变量声明 
ElemenetType.METHOD 方法声明 
ElemenetType.PACKAGE 包声明 
ElemenetType.PARAMETER 参数声明 
ElemenetType.TYPE 类，接口（包括注解类型）或enum声明 
```

- `@Documented`

将此注解包含在javadoc中 ，它代表着此注解会被javadoc工具提取成文档。在doc文档中的内容会因为此注解的信息内容不同而不同。相当于`@see,@param`等



- `@Inherited`

允许子类继承父类中的注解


## 自定义注解

**使用`@interface`自定义注解时，自动继承了`java.lang.annotation.Annotation`接口，由编译程序自动完成其他细节。在定义注解时，不能继承其他的注解或接口。`@interface`用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。方法的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。可以通过default来声明参数的默认值。**


定义注解格式：

`public @interface 注解名 {定义体}`

注解参数的可支持数据类型：

1.所有基本数据类型(int,float,boolean,byte,double,char,long,short)
2.String类型
3.Class类型
4.enum类型
5.Annotation类型
6.以上所有类型的数组



## 示例代码

参考文末的[【参考资料】](#参考资料)中[《java 注解的几大作用及使用方法详解（完）》](http://blog.csdn.net/tigerdsh/article/details/8848890)

下面的示例，是上文提到的**A<--B<--C**的扩充版本。自定义了一个注解`@A`，然后在B类中使用了注解`@A`,最后在类C中利用反射读取`@A`中的信息

- `A.java`

```java
package com.iot.annotation;

import java.lang.annotation.*;

/**
 * Created by brian on 2016/2/20.
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
    String name();
    int id() default 0;
    Class<Long> gid();
}
```

- `B.java`

```java
package com.iot.annotation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 2016/2/20.
 */
@A(name="type",gid=Long.class)//类注解
public class B {
    @A(name="param",id=1,gid=Long.class) //类成员注解
    private Integer age;

    @A(name="construct",id=2,gid=Long.class) //构造方法注解
    public B(){}

    @A(name="public method",id=3,gid=Long.class) //类方法注解
    public void a(){

    }

    @A(name="protected method",id=4,gid=Long.class) //类方法注解
    protected void b(){
        Map<String,String> m = new HashMap<String,String>(0);
    }


    @A(name="private method",id=5,gid=Long.class) //类方法注解
    private void c(){
        Map<String,String> m = new HashMap<String,String>(0);
    }

    public void b(Integer a){

    }
}

```

- `C.java`

```java
package com.iot.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by brian on 2016/2/20.
 */
public class C {

    /**
     * 简单打印出B类中所使用到的类注解
     * 该方法只打印了 Type 类型的注解
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException{
        Class clazz = Class.forName("com.iot.annotation.B");

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation :annotations){
            A a = (A)annotation;
            System.out.println("id = "+a.id()+" ;name = "+a.name()+" ;gid = "+a.gid());
        }

    }

    /**
     * 简单打印出B类中所使用到的方法注解
     * 该方法只打印了 Method 类型的注解
     */
    public static void parseMethodAnnotation() {
        Method[] methods = B.class.getDeclaredMethods();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(A.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                A annotation = method.getAnnotation(A.class);
                System.out.println("method = " + method.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= " + annotation.gid());
            }
        }
    }

    /**
     * 简单打印出B类中所使用到的方法注解
     * 该方法只打印了 Method 类型的注解
     */
    public static void parseConstructAnnotation(){
        Constructor[] constructors = B.class.getConstructors();
        for (Constructor constructor : constructors) {
        	/*
             * 判断构造方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = constructor.isAnnotationPresent(A.class);
            if (hasAnnotation) {
                /*
                 * 根据注解类型返回方法的指定类型注解
                 */
                A annotation =(A) constructor.getAnnotation(A.class);
                System.out.println("constructor = " + constructor.getName()
                        + " ; id = " + annotation.id() + " ; description = "
                        + annotation.name() + "; gid= "+annotation.gid());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        parseTypeAnnotation();
        parseMethodAnnotation();
        parseConstructAnnotation();
    }

}

```

## 参考资料

>* [java 注解的几大作用及使用方法详解（完）](http://blog.csdn.net/tigerdsh/article/details/8848890)
>* [另类的package-info.java文件探讨](http://strong-life-126-com.iteye.com/blog/806246)
>* [深入理解Java：注解（Annotation）自定义注解入门](http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html)




------------


> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

