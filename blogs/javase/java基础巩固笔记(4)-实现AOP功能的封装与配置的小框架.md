# java基础巩固笔记(4)-实现AOP功能的封装与配置的小框架

标签： java

---

**Contents**

- [java基础巩固笔记(4)-实现AOP功能的封装与配置的小框架](#java基础巩固笔记4-实现aop功能的封装与配置的小框架)
  - [设计](#设计)
- [xxx=java.util.ArrayList](#xxxjavautilarraylist)
  - [代码](#代码)
    - [`Advice`接口](#advice接口)
    - [`MyAdvice`类](#myadvice类)
    - [`BeanFactory`类](#beanfactory类)
    - [`ProxyFactoryBean`类](#proxyfactorybean类)
    - [`AopFrameWorkTest`类](#aopframeworktest类)
  - [输出](#输出)



---

本文通过是动态代理实现的AOP功能的封装与配置的小框架.加深对动态代理和AOP编程的理解

## 设计

根据配置文件的键`xxx`对应的值(类全名)创建相应类的对象。

当且仅当`xxx`对应的值为`com.iot.proxy.aopframework.ProxyFactoryBean`时，则生成相应的动态代理类对象。代理对象的目标类和通知实现类分别由`xxx.target`和`xxx.advice`配置

配置文件

`config.propertiest`位于`aopframework`包下

- `xxx`代表要加载的类
- `xxx.advice`代表通知接口的某个实现类
- `xxx.target`代表委托类

```
#xxx=java.util.ArrayList
xxx=com.iot.proxy.aopframework.ProxyFactoryBean
xxx.advice=com.iot.proxy.MyAdvice
xxx.target=java.util.ArrayList
```

包:`com.iot.proxy.aopframework`,有如下几个类/接口：

- `BeanFactory`,用于读取配置文件，根据配置创建相应的对象
- `ProxyFactoryBean`,用于生成代理对象，含有两个私有属性:目标和通知
- `Advice`,通知接口，用于把切面的代码以**对象**的形式传递给InvocationHandler的的invoke方法
- `MyAdvice`,`Advice`接口的一个实现类，打印执行方法前的时间及执行耗时
- `AopFrameWorkTest`，测试效果





## 代码

### `Advice`接口

```java
package com.iot.proxy.aopframework;

import java.lang.reflect.Method;
/**
 * Created by brian on 2016/2/2.
 */
public interface Advice {
    void beforeMethod(Method method);
    void aftereMethod(Method method);
}
```

### `MyAdvice`类

```java
package com.iot.proxy.aopframework;

import java.lang.reflect.Method;

/**
 * Created by brian on 2016/2/2.
 */
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


### `BeanFactory`类

```java
package com.iot.proxy.aopframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by brian on 2016/2/2.
 */
public class BeanFactory {
    Properties properties = new Properties();
    public BeanFactory(InputStream inputStream){
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  Object getBean(String name){
        String className = properties.getProperty(name);
        Object bean = null;
        try {
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (bean instanceof ProxyFactoryBean){
            ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean)bean;
            Advice advice = null;
            Object target = null;
            try {
                advice = (Advice) Class.forName(properties.getProperty(name+".advice")).newInstance();
                target = Class.forName(properties.getProperty(name+".target")).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            proxyFactoryBean.setAdvice(advice);
            proxyFactoryBean.setTarget(target);
            Object proxy = ((ProxyFactoryBean) bean).getProxy();
            return proxy;
        }
        return bean;
    }
}
```

### `ProxyFactoryBean`类

```java
package com.iot.proxy.aopframework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by brian on 2016/2/3.
 */
public class ProxyFactoryBean {
    private Object target;
    private Advice advice;

    public Object getProxy(){
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

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
```


### `AopFrameWorkTest`类

```java
package com.iot.proxy.aopframework;

import java.io.InputStream;
import java.util.Collection;

/**
 * Created by brian on 2016/2/3.
 */
public class AopFrameWorkTest {
    public static void main(String[] args) {
        InputStream inputStream = AopFrameWorkTest.class.getResourceAsStream("config.properties");
        Object bean = new BeanFactory(inputStream).getBean("xxx");
        System.out.println(bean.getClass().getName());
        ((Collection) bean).clear();
    }
}
```

## 输出

- 配置`xxx=com.iot.proxy.aopframework.ProxyFactoryBean`

输出为：

```
com.sun.proxy.$Proxy0
clear before at 0
clear cost total 0
```

- 配置`xxx=java.util.ArrayList`

输出为：

```
java.util.ArrayList
```


可以看出，只改变配置文件，就可改变代码的运行结果，从而达到灵活的效果



------

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)
