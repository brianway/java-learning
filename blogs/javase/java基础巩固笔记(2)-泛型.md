# java基础巩固笔记(2)-泛型

标签： java

---

**Contents**

- [java基础巩固笔记(2)-泛型](#java基础巩固笔记2-泛型)
  - [术语](#术语)
  - ["?"通配符](#通配符)
    - [通配符的扩展](#通配符的扩展)
  - [自定义泛型方法](#自定义泛型方法)
    - ["擦除"实例](#擦除实例)
    - [类型参数的类型推断](#类型参数的类型推断)
  - [自定义泛型类](#自定义泛型类)
    - [泛型方法和泛型类的比较](#泛型方法和泛型类的比较)
  - [泛型和反射](#泛型和反射)
    - [通过反射获得泛型的实际类型参数](#通过反射获得泛型的实际类型参数)



---

本文对泛型的基本知识进行较为全面的总结，并附上简短的代码实例，加深记忆。


泛型：将集合中的元素限定为一个特定的类型。

## 术语

- `ArrayList<E>` -- 泛型类型
- `ArrayList` -- 原始类型
- `E` -- 类型参数
- `<>` -- 读作"typeof"
- `ArrayList<Integer>` -- 参数化的类型
- `Integer` -- 实际类型参数

几点注意：

- 参数化类型和原始类型相互兼容

```java
ArrayList  collection1 = new ArrayList<Integer>();//通过,无warning
ArrayList<Integer> collection2 = new ArrayList();//通过,有warning
```

- 参数化类型不考虑类型参数的继承关系

```java
ArrayList<String> collection3 = new ArrayList<Object>();//编译不通过
ArrayList<Object> collection4 = new ArrayList<String>();//编译不通过
```

但是

```java
ArrayList collection5 = new ArrayList<Integer>();
ArrayList<String> collection6 = collection5;//编译通过
```

---

## "?"通配符
"?"表示任意类型，使用"?"通配符可以引用各种参数化的类型，可以调用与参数化无关的方法(如size()方法)，不能调用与参数化有关的方法(如add()方法)
    
### 通配符的扩展

- 限定通配符的上边界

```java
ArrayList<? extends Number > collection1= new ArrayList<Integer >();//编译通过
ArrayList<? extends Number > collection2= new ArrayList<String>();//编译不通过
```

- 限定通配符的下边界

```java
ArrayList<? super Integer > collection3= new ArrayList<Number >();//编译通过
ArrayList<? super Integer > collection4= new ArrayList<String>();//编译不通过
```

---

## 自定义泛型方法
C++模板函数

```cpp
template <class T> T add(T x, T y){
    return (T)(x+y);
}
```
    
而java的泛型基本上完全在编译器中实现，用于编译器执行类型检查和类型判断，然后生成普通的**非泛型**的字节码，这种实现技术为“擦除”(erasure)。

### "擦除"实例
泛型是提供给javac编译器使用的，限定集合的输入类型，编译器编译带类型说明的集合时会去掉“类型”信息。

```java
public class GenericTest {
    public static void main(String[] args) {
        new GenericTest().testType();
    }

    public void testType(){
        ArrayList<Integer> collection1 = new ArrayList<Integer>();
        ArrayList<String> collection2= new ArrayList<String>();
        
        System.out.println(collection1.getClass()==collection2.getClass());
        //两者class类型一样,即字节码一致
        
        System.out.println(collection2.getClass().getName());
        //class均为java.util.ArrayList,并无实际类型参数信息
    }
}
```

输出

```
true
java.util.ArrayList
```

*使用反射可跳过编译器，往某个泛型集合加入其它类型数据。*

只有引用类型才能作为泛型方法的实际参数
例子：

```java
public class GenericTest {
    public static void main(String[] args) {
        swap(new String[]{"111","222"},0,1);//编译通过
        
        //swap(new int[]{1,2},0,1);
        //编译不通过,因为int不是引用类型
        
        swap(new Integer[]{1,2},0,1);//编译通过
    }
    
    /*交换数组a 的第i个和第j个元素*/
    public static <T> void swap(T[]a,int i,int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

但注意基本类型**有时**可以作为实参，因为有**自动装箱**和**拆箱**。
例子(编译通过了)：

```java
public class GenericTest {
    public static void main(String[] args) {
        new GenericTest().testType();
        int a = biggerOne(3,5);
        //int 和 double,取交为Number
        Number b = biggerOne(3,5.5);
        //String和int 取交为Object
        Object c = biggerOne("1",2);
    }
    //从x,y中返回y
    public static <T> T biggerOne(T x,T y){
        return y;
    }
}
```

同时，该例还表明，**当实参不一致时，T取交集，即第一个共同的父类。**
另外，如果用`Number b = biggerOne(3,5.5);`改为`String c = biggerOne(3,5.5);`则编译报错:

```
Error:(17, 29) java: 不兼容的类型: 推断类型不符合上限
    推断: java.lang.Number&java.lang.Comparable<? extends java.lang.Number&java.lang.Comparable<?>>
    上限: java.lang.String,java.lang.Object
```

但是有一点没搞清楚，我在IDEA里面单步调试，发现结果如下图：
![泛型调试截图-1](http://7xph6d.com1.z0.glb.clouddn.com/javaSE_%E6%B3%9B%E5%9E%8B%E8%B0%83%E8%AF%95%E6%88%AA%E5%9B%BE-1.png)
不知道b为什么是Double类型的（但直接`Double b`接收返回值会编译报错）。不知道跟IDE有没有关系，是不是IDE在debug时会显示这个对象最精确的类型？


### 类型参数的类型推断
编译器判断泛型方法的实际类型参数的过程称为类型推断。

- 当某个类型变量只在整个参数列表的所有参数和返回值中的**一处被应用**了，那么根据调用方法时该处的实际应用类型来确定。即直接根据调用方法时传递的参数类型或返回值来决定泛型参数的类型。
例如：

`swap(new String[3],1,2)` -> `static <E> void swap(E[]a,int i,int j)`

- 当某个类型变量在整个参数列表的所有参数和返回值中的**多处被应用**了，如果调用方法时这么多处的实际应用类型都 *对应同一种类型*，则泛型参数的类型就是该类型。
例如：

`add(3,5)` -> `static <T> T add(T a,T b)`

- 当某个类型变量在整个参数列表的所有参数和返回值中的***多处被应用**了，如果调用方法时这么多处的实际应用类型 *对应不同的类型,且没有返回值*，则取多个参数中的最大交集类型，即第一个公共父类。
例如：

`fill(new Integer[3],3.5)` -> `static <T> void fill(T a[],T v)`

该例子实际对应的类型就是Number,编译通过，运行出问题。

- 当某个类型变量在整个参数列表的所有参数和返回值中的**多处被应用**了，如果调用方法时这么多处的实际应用类型*对应不同的类型,且使用有返回值*，则**优先考虑返回值的类型**

例如：

`int x = add(3,3.5)` -> `static <T> T add(T a,T b)`

上例编译报错,x类型改为float也报错，改为Number成功。


- 参数类型的类型推断具有传递性

例子：

`copy(new Integer[5],new String[5])` -> `static <T> void copy(T []a,T []b)`

该例推断实际参数类型为Object,编译通过.

 `copy(new ArrayList<String>,new Integer[5])` -> `static <T> void copy(Collection<T>a,T[]b)`

该例则根据参数化的ArrayList类实例将类型变量直接确定为String类型，编译报错。

----

##  自定义泛型类
例子

```java
public class GenericDao<T>{
    public void add(T x){
    }
    
    public T findById(int id){
        return null;
    }
    
    public void delete(T obj){
    }
    
    public void delete(int id){
    }
    
    public void update(T obj){
    }
    
    public T findByUserName(String name){
        return null;
    }

    public <T> Set<T> findByConditions(String where){
        return null;
    }
    
}
```

注意：当一个变量被声明为泛型时，只能被实例变量和方法调用(还有内嵌类型)，而不能被静态变量和静态方法调用。*因为静态成员是被所参数化的类所共享的，所以静态成员不应该有类级别的类型参数*。

### 泛型方法和泛型类的比较
例子：

```java
public class A<T>(){
    //泛型类的成员方法，该T受A后面的T的限制
    public T memberFunc(){
        return null;
    }
    //泛型方法，这里的T和和类A的T是不同的
    public static <T> T genericFunc(T a){
        return null;
    }
    public static void main(String[] args) {
        //编译不通过
        //Integer i = A<String>().findByUserName("s");
        
        //编译通过
        Set<Integer> set=  A<String>().findByConditions("s");
    }
}
```

这里`Integer i = A<String>().findByUserName("s");`会编译报错：

`Error:(35, 61) java: 不兼容的类型: java.lang.String无法转换为java.lang.Integer`

由这个例子可知，泛型方法的T和和类A的T是不同的。

----

## 泛型和反射

### 通过反射获得泛型的实际类型参数
把泛型变量当成方法的参数，利用Method类的getGenericParameterTypes方法来获取泛型的实际类型参数
例子：

```java
public class GenericTest {
    public static void main(String[] args) throws Exception {
        getParamType();
    }
    
     /*利用反射获取方法参数的实际参数类型*/
    public static void getParamType() throws NoSuchMethodException{
        Method method = GenericTest.class.getMethod("applyMap",Map.class);
        //获取方法的泛型参数的类型
        Type[] types = method.getGenericParameterTypes();
        System.out.println(types[0]);
        //参数化的类型
        ParameterizedType pType  = (ParameterizedType)types[0];
        //原始类型
        System.out.println(pType.getRawType());
        //实际类型参数
        System.out.println(pType.getActualTypeArguments()[0]);
        System.out.println(pType.getActualTypeArguments()[1]);
    }

    /*供测试参数类型的方法*/
    public static void applyMap(Map<Integer,String> map){

    }

}
```

输出结果：

```
java.util.Map<java.lang.Integer, java.lang.String>
interface java.util.Map
class java.lang.Integer
class java.lang.String
```

作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)
    
