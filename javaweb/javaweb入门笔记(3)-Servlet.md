# javaweb入门笔记(3)-Servlet

标签： javaweb

----

**Contents**

- [javaweb入门笔记(3)-Servlet](#javaweb入门笔记3-servlet)
  - [servlet入门](#servlet入门)
  - [手动编写第一个servlet](#手动编写第一个servlet)
  - [servlet的调用过程和生命周期](#servlet的调用过程和生命周期)
  - [servlet开发的一些细节](#servlet开发的一些细节)
  - [ServletContext](#servletcontext)
  - [参考链接](#参考链接)



----

## servlet入门

开发步骤：

- 编写一个java类，实现servlet接口
- 把开发好的java类部署到web服务器

API文档

> [Servlet API Documentation](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html)


生命周期相关方法(life-cycle methods)

Servlet的生命周期通过`java.servlet.Servlet`接口中的`init()`、`service()`、和`destroy()`方法表示。Servlet的生命周期有四个阶段：加载并实例化、初始化、请求处理、销毁。（见文末【参考链接】）







## 手动编写第一个servlet
1.在tomcat中新建一个web应用`hello`，在web应用中新建一个`WEB-INF/classes`目录

2.在`classes`目录新建一个`FirstServlet`

```java
package org.iot;

import java.io.*;
import javax.servlet.*;

public class FirstServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,java.io.IOException{
		OutputStream out = res.getOutputStream();
		out.write("hello servlet!!!".getBytes());
	}
}
```

3.编译，`javac -cp %CATALINA_HOME%/lib/servlet-api.jar  -d . FirstServlet.java`,命令行手动编译参考[这里](http://www.iitshare.com/under-the-cmd-compile-the-java.html)

4.在`WEB-INF`目录中新建一个`web.xml`文件，配置servlet的对外访问路径

5.启动tomcat访问

## servlet的调用过程和生命周期

时序图

![servlet的调用过程和生命周期](http://7xph6d.com1.z0.glb.clouddn.com/javaweb_servlet-lifecycle.png)


## servlet开发的一些细节

- **标签**:`<servlet>`包含`<servlet-name>`和`<servlet-class>`；`<servlet-mapping>`包含`<servlet-name>`和`<url-pattern>`
- **映射**:`web.xml`中一个`<servlet>`可对应多个`<servlet-mapping>`
- **通配符**:`<servlet-mapping>`的`<url-pattern>`可以使用通配符，两种固定格式：`*.扩展名`；以`/`开头，以`/*`结尾


![javaweb_servlet-url匹配.png](http://7xph6d.com1.z0.glb.clouddn.com/javaweb_servlet-url%E5%8C%B9%E9%85%8D.png)

- **对象**:servlet由servlet引擎调用，不能独立运行。客户端多次请求，服务器只创建一个servlet实例，之后驻留内存中继续服务直至web容器退出才销毁它。
- **请求**:服务器针对客户端的每一次请求都会创建新的`request`和`response`对象(它们的生命周期很短)，传给`service`方法。
- **加载**:servlet实例的创建和`init`方法的调用是在第一次请求时，而非服务器启动时，除非在`<servlet>`标签配置`<load-on-start-up>`,数字越小优先级越高
- **缺省**:映射路径为正斜杠`/`，则为当前web应用的缺省servlet,不匹配的都交给缺省
- **线程安全**:访问同一资源会引发线程安全问题; `SingleThreadModel`标记接口(已弃用)
- **ServletConfig**:在`<servlet>`标签配置`<init-param>`，通过`getServletConfig`方法获得配置。可配置输出字符集，读哪个配置文件等等。
- **ServletContext**:代表当前web应用，含有一些web应用全局性方法，实现web资源共享、servlet转发等。通过`ServletConfig.getServletContext`方法获得，在`<context-param>`标签配置。



## ServletContext

API:[Interface ServletContext](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html?javax/servlet/ServletContext.html)

概念

一个web应用所有servlet共享同一个ServletContext对象，可实现数据共享。ServletContext被称为context**域**对象。

域：作用范围；context域：整个应用程序范围。

ServletContext域：
1. 这是一个容器
2. 说明了这个容器的作用范围，也就是应用程序范围

转发:客户机一次请求；重定向：客户机两次请求

作用

- 获取web应用的初始化参数
- 实现servlet转发
- 利用ServletContext对象读取资源文件
    - 获得文件路径
    - 读取资源文件的三种方式
    - .properties文件（属性文件）


配置文件：properties文件和xml文件；数据有关系使用xml文件，没有关系则使用properties文件。

1.通过`ServletContext`的`getResourceAsStream`方法，读取properties文件

模板代码(注意文件位置不同写路径会不同)：

```java
InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/org/iot/servlet/db.properties");
Properties properties = new Properties();//map
properties.load(in);
```

2.通过`servletContext`的`getRealPath`方法得到资源的绝对路径，再通过传统方式(`FileInputStream`)读取

3.通过类装载器去读，`ClassLoader`的`getResourceAsStream`(如果读取资源文件的程序不是servlet)，文件不能太大。**只装载一次**，所以如要读到更新后的数据，通过类装载的方式得到资源文件的位置，再通过传统方式读取资源文件的数据（用`getResource`得到path，再用`FileInputStream`）


## 参考链接

> [servlet和Jsp生命周期解读](http://blog.csdn.net/evankaka/article/details/46673051)






-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

