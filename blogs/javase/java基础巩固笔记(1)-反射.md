# java基础巩固笔记(1)-反射

标签： java

---

**Contents**

- [java基础巩固笔记(1)-反射](#java基础巩固笔记1-反射)
  - [反射基本使用](#反射基本使用)
  - [数组的反射](#数组的反射)
  - [配置文件加载](#配置文件加载)
  - [内省(Instropector) & JavaBean](#内省instropector--javabean)



---


**反射：将类的属性和方法映射成相应的类。**

## 反射基本使用

获取Class类的三种方法:

- 类名.class
- 对象名.getClass()
- Class.forName("要加载的类名")

根据API写就行了，大致流程就是:

- 用上述三种方式之一获取特定类的`Class`类，即该类对应的字节码
- 调用`Class`对象的`getConstructor(Class<?>... parameterTypes)`获取构造方法对象
- 调用是构造方法类`Constructor`的`newInstance(Object... initargs)`方法新建对象
- 调用`Class`对象的`getMethod(String name, Class<?>... parameterTypes)`获取方法对象
- 调用方法对象类`Method`的`invoke(Object obj, Object... args)`方法，调用对象上相应方法

*用方法的参数类型唯一标识一个方法,依据：方法的重载*


## 数组的反射
下面这个例子主要说明几点：

- 对于元素同类型的数组，同维数组，class一样
- 不同维，class不同
- 不同维的，父类都是Object,一样
- 基本类型一维数组不能直接转换为Object[]
- `java.util.Arrays`的`asList`方法API看看

```java
public class ReflectTest {
    public static void main(String[] args) {
        int [] a1 = new int[]{1,2,3};
        int [] a2 = new int[5];
        int [][] a3 = new int[2][3];
        System.out.println(a1.getClass() == a2.getClass());//true
        System.out.println(a1.getClass());//class [I
        System.out.println(a3.getClass());//class [[I
        System.out.println(a1.getClass().getSuperclass() == a3.getClass().getSuperclass());//true
        System.out.println(a2.getClass().getSuperclass());//class java.lang.Object

        //下句编译不通过：Error:(15, 42) java: 不可比较的类型: java.lang.Class<capture#1, 共 ? extends int[]>和java.lang.Class<capture#2, 共 ? extends int[][]>
        //System.out.println(a1.getClass() == a3.getClass());

        Object []b3 = a3;//通过
        //下句编译不通过   Error:(17, 24) java: 不兼容的类型: int[]无法转换为java.lang.Object[]
        //Object [] b1 = a1;

        String s1 = "abc";
        System.out.println(Arrays.asList(a1));//[[I@1540e19d]
        System.out.println(Arrays.asList(s1));//[abc]
    }
}
```



输出：

```
true
class [I
class [[I
true
class java.lang.Object
[[I@1540e19d]
[abc]
```

乱入：
hashcode与内存泄露问题
参考java api：

>* hashcode一旦生成，不要变
>* 对象equals方法返回true,则hashcode要一致
>* 反之，equals方法返回false,hashcode不一定互异

如果参与hashcode计算的成员变量中途发生变化，则后面remove时失败，造成内存泄露


----

## 配置文件加载

- 类加载器加载只读配置文件

`类名.class.getClassLoader().getResourceAsStream(str);`

- 类名.class.getResourceAsStream(str),实质还是调用类加载器。
源码截取(java.lang包下的Class.java)：

```java
 public InputStream getResourceAsStream(String name) {
    name = resolveName(name);
    ClassLoader cl = getClassLoader0();
    if (cl==null) {
        // A system class.
        return ClassLoader.getSystemResourceAsStream(name);
    }
    return cl.getResourceAsStream(name);
}
```

关于路径str，写法有点讲究。

- 不加斜杠，相对路径:
 `str = "config.properties";`
- 加斜杠，从classpath的根路径找:
 `str = "/org/iot/ui/config.properties";`

*以前编译java代码时，有些`conf/`文件夹还要添加进依赖或者标记成source文件夹，里面明明都是xml文件，没Java源码。从这里，我现在知道了，是使用反射加载配置文件的缘故*

---

## 内省(Introspector) & JavaBean
JavaBean读取属性x的值的流程：变大写、补前缀、获取方法。

```
"x"-->"X"-->"getX"-->"MethodGetX"
```

- 自己用内省操作

我目前没用上，所以不贴代码了，只附上核心类

简单实现：
使用`java.beans.PropertyDescriptor`类

麻烦实现:
使用`java.beans.Introspector`类,遍历`getBeanInfo`方法的返回值

**JavaBean必须有一个不带参数的构造函数**

- 使用BeanUtils工具包

    - 字符串和整数转换(对比(PropertyUtils)
    - 属性级联操作
    - 操作map
    
    
    
[作者更多文章：@brianway](http://brianway.github.io/)


















