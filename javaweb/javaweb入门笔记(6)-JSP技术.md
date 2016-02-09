# javaweb入门笔记(6)-JSP技术

标签： javaweb

----

**Contents**

- [javaweb入门笔记(6)-JSP技术](#javaweb入门笔记6-jsp技术)
  - [调用和运行原理](#调用和运行原理)
  - [JSP语法](#jsp语法)
  - [九大隐式对象](#九大隐式对象)
    - [out隐式对象](#out隐式对象)
    - [pageContext对象](#pagecontext对象)
  - [jsp映射和查错](#jsp映射和查错)
  - [jsp与JavaBean](#jsp与javabean)



----

JSP：Java Server Pages，一种动态web资源的开发技术

API文档

> [JSP 2.3 API - Apache Tomcat 8.0.30](https://tomcat.apache.org/tomcat-8.0-doc/jspapi/index.html)

## 调用和运行原理

JSP本质是一个servlet.

每个JSP页面在第一次被访问时，WEB容器会把请求交给JSP引擎(即一个JAVA程序)处理。JSP引擎先将JSP翻译成一个`_jspServlet`(实质也是一个servlet)，然后按照servlet的调用方式进行调用。

- 服务器会将jsp先翻译成servlet，这个servlet位于tomcat服务器`work`目录，这jsp类的父类是`org.apache.jasper.runtime.HttpJspBase`,这个`HttpJspBase`类继承自`HttpServlet`
- 向服务器发请求会调用servlet的service方法;同样地，访问jsp会调用这个JSP类的`_jspService`方法。
- JSP中的标签语言会在`_jspService`方法中通过`out.write()`写出来；JSP中的Java代码会原封不动的搬到`_jspService`方法中。
- 在`_jspService`方法中提前准备好了一些对象供JSP调用，如：`out,page,application,request,response`等等。
- 由于第一次访问时会翻译成servlet，所以第一次访问较慢。

下面以`demo1.jsp`为例，展示对应的类`%CATALINA_HOME%\work\Catalina\localhost\hello\org\apache\jsp\demo1_jsp.java`中的部分代码

示例1:`demo1.jsp`

```JSP
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/27
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo1</title>
</head>
<body>
当前时间时：
<%
    Date date = new Date();
    out.write(date.toGMTString());
%>
</body>
</html>

```


示例2：`_jspService`方法中代码片段

```java
out.write("\r\n");
out.write("\r\n");
out.write("<html>\r\n");
out.write("<head>\r\n");
out.write("    <title>demo1</title>\r\n");
out.write("</head>\r\n");
out.write("<body>\r\n");
out.write("当前时间时：\r\n");

Date date = new Date();
out.write(date.toGMTString());

out.write("\r\n");
out.write("</body>\r\n");
out.write("</html>\r\n");
```

示例3:`_jspService`方法中一些定义的对象

```java
final javax.servlet.jsp.PageContext pageContext;
final javax.servlet.ServletContext application;
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
javax.servlet.jsp.JspWriter _jspx_out = null;
javax.servlet.jsp.PageContext _jspx_page_context = null;
```

-------

## JSP语法

- **JSP模板元素**:JSP页面中的HTML内容。定义了网页的基本骨架，即结构和外观。
- **JSP表达式**:用于将程序数据输出到客户端。如，`<%=变量或表达式 %>`脚本表达式(无分号)，用于输出数据。
- **JSP脚本片段**:用于在JSP页面中编写多行java代码,严格遵循java语法。一个JSP页面可有多个脚本片段，它们可以相互访问(和放在一对`<% %>`中一样),单个片段可不完整。
- **JSP声明**:JSP中代码默认翻译到servlet的service方法中，而JSP声明中的代码被翻译到`_jspService`方法外。语法：`<%! java代码 %>`。
- **JSP注释**:格式`<%-- 注释  --%>`，注释的内容不会发给浏览器。
- **JSP指令**:是为JSP引擎设计的，定义了三个指令:page指令，include指令，taglib指令。语法:`<%@ 指令 属性名="值" %>`。
  - page指令:定义各种属性，作用于整个JSP页面。
  - include指令:用于包含JSP文件(页头、页脚)。属于静态包含(编译时包含)，它包含的所有JSP会编译成一个servlet。
  - taglib指令:用于在JSP页面导入标签库。
- **JSP标签**:也称为jsp Action元素，用于在jsp页面中提供业务逻辑功能，避免在jsp页面中直接写java代码而难以维护
- **JSP内置对象**:九大隐式对象，`request,response,session,application,config,page,exception,out,pageContext`

----

关于上述语法的一些说明

page指令语法：

```JSP
<%@ page
[ language="java" ]
[ extends="package.class" ]
[ import="{package.class | package.*}, ..." ]
[ session="true | false" ]
[ buffer="none | 8kb | sizekb" ]
[ autoFlush="true | false" ]
[ isThreadSafe="true | false" ]
[ info="text" ]
[ errorPage="relativeURL" ]
[ contentType="mimeType [ ;charset=characterSet ]" | "text/html ; charset=ISO-8859-1" ]
[ isErrorPage="true | false" ]
%>
```

- `errorPage`:错误提示页面。也可在`web.xml`的`<error-page>`标签配置，异常处理页面。在page指令设置的优先级高于在`web.xml`配置。
- `pageEncoding`:JSP引擎以何种码表翻译JSP,该值需和JSP文件的保存编码一致，且若要在浏览器正确显示，还要和`contentType`一致。


动态包含(运行时包含):`request.getRequestDispatcher("/public/head.jsp").include(request,response)`,涉及到的jsp会生成单独的servlet，即有多个servlet，在浏览器访问时包含。静态包含性能优于动态包含


JSP常用标签

- `<jsp:include>`:pageContext.include(),动态包含
- `<jsp:forward>`
- `<jsp:param>`

-------

## 九大隐式对象

JSP引擎在调用JSP对应的`_jspServlet`时，会传递和创建9个web开发相关的对象供使用。后两者(`out`和`pageContext`)为JSP独有

- request
- response
- session
- application
- config
- page
- exception
- out
- pageContext

### out隐式对象

**out隐式对象**:用于向客户端发送文本数据。通过调用`pageContext`对象的`getOut`方法返回，类型为`JspWriter`，作用和`ServletResponse.getWriter`返回的`PrintWriter`对象相似。

`JspWriter`相当于自带缓存功能的`PrintWriter`,设置page指令的buffer属性课调整缓存大小。满足如下条件之一，out对象才调用`ServletResponse.getWriter`方法，并通过返回的`PrintWriter`对象将out对象的缓冲区的内容真正写入到servlet引擎提供的缓冲区中：

- 设置page指令的buffer属性关闭的out对象的缓存功能
- out对象的缓冲区已满
- 整个JSP页面结束

例子：

```JSP
<%
    out.write("out.write<br/>");
	response.getWriter().write("response.getWriter.write<br/>");
%>
```

浏览器显示：

```
response.getWriter.write
out.write
```

可见，由于out有缓冲，所以后显示。

### pageContext对象

**pageContext对象**:是JSP技术中最重要的一个对象，它代表JSP页面的运行环境

- 封装了对其他8大隐式对象的引用(主要用于自定义标签开发)
- 自身是一个域对象，可用来保存数据(page域存的东西只能在页面范围内拿得出来)
- 封装了web开发中的一些常用操作(提供管理所有域的入口)，如：引入和跳转其他资源、检索其他域对象中的属性等

Class PageContext的API文档

> [javax.servlet.jsp:Class PageContext](https://tomcat.apache.org/tomcat-8.0-doc/jspapi/index.html?javax/servlet/jsp/PageContext.html)

javaweb中的四个域:

- application域:应用程序范围,servletContext,对应的常量`PageContext.APPLICATION_SCOPE`
- session域:会话范围,session,对应的常量`PageContext.SESSION_SCOPE`
- resquet域:请求范围,request,对应的常量`PageContext.REQUEST_SCOPE`
- page域:页面范围,pageContext,对应的常量`PageContext.PAGE_SCOPE`

**`findAttribute(java.lang.String name)`**查找各个域中的属性，是`PageContext`从父类`javax.servlet.jsp.JspContext`继承的，实现了父类的抽象方法。会**依次**从`page,request,session,application`域中寻找相应的属性，找到为止。

## jsp映射和查错

jsp映射

在`webxml`的`<servlet>`标签中加`<jsp-file>`标签，其他的和servlet映射一样

查找jsp页面中的错误

- JSP页面中的语法格式有问题，导致不能翻译成servlet源文件，JSP引擎将提示这类错误在JSP页面中的位置以及相关信息
- JSP页面中的语法格式没有问题，但翻译承德servlet源文件出现java语法问题导致源文件编译不通过，JSP引擎将提示这类错误在JSP页面中的位置以及相关信息
- JSP页面翻译成的servlet程序运行时出现异常，这和普通java程序运行时错误完全一样，java虚拟机将提示错误在servlet源文件中的位置以及相关信息

## jsp与JavaBean

JavaBean是一个遵循特定写法的java类，JavaBean常用于封装数据，具有如下热点：

- 该java类必须有一个无参的构造函数
- 属性必须私有化
- 私有化的属性必须通过public类型的方法暴露给其他程序，并且方法的命名也必须遵循一定的命名规范。

JSP中提供了三个关于JavaBean的标签：

- `<jsp:useBean>`:用于在JSP页面中查找或实例化一个JavaBean组件
- `<jsp:setProperty>`:用于在JSP页面中设置一个JavaBean组件的属性
- `<jsp:getProperty>`:用于在JSP页面中获取一个JavaBean组件的属性

一些细节

- `<jsp:useBean>`标签的标签体只在实例化bean时才执行
- `<jsp:setProperty>`可用请求参数给bean属性赋值，支持8种基本数据类型的转换(把客户机提交的字符串转成相应的8种基本类型赋到bean的属性上)
- 在标签中将`property="*"`，用所有请求参数为bean赋值，请求参数名称和bean属性名称必须要一致
- 如果JavaBean实例对象的某个属性值为null,那么使用`<jsp:getProperty>`标签输出结果为**"null"字符串**


-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

