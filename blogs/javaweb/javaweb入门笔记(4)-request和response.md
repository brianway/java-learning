# javaweb入门笔记(4)-request和response

标签： javaweb

----

**Contents**

- [javaweb入门笔记(4)-request和response](#javaweb入门笔记4-request和response)
  - [response](#response)
    - [输出数据](#输出数据)
    - [文件下载](#文件下载)
    - [随机图片](#随机图片)
    - [刷新和缓存](#刷新和缓存)
    - [请求重定向](#请求重定向)
  - [request](#request)
    - [中文乱码](#中文乱码)
    - [请求转发](#请求转发)
    - [地址的写法](#地址的写法)
    - [防盗链](#防盗链)



----

API:

>* [Interface HttpServletResponse](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html?javax/servlet/http/HttpServletResponse.html)
>* [Interface HttpServletRequest](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html?javax/servlet/http/HttpServletRequest.html)


## response

### 输出数据

程序以什么码表输出，就一定要控制浏览器以什么码表打开。可有如下两种写法：

- `response.setHeader("Content-type","text/html;charset=UTF-8")`
- `response.setContentType("text/html;charset=UTF-8")`(默认调用`setHeader`和`setCharacterEncoding`)

把分号`;`错写成逗号`,`，浏览器会提示下载

用html技术的`<meta>`标签可以模拟一个http响应头，`  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>`

response可用`setCharacterEncoding`方法设置码表。字符流输出：`PrintWritet->response->浏览器`,`response->浏览器`默认使用`iso-8859`编码

### 文件下载

使用`ServerContext`的`getRealPath`方法,再`InputStream`和`OutputStream`

如果下载文件是中文名为中文，则文件名需要经过url编码`URLEncoder.encode`


### 随机图片

使用[`BufferedImage`](https://docs.oracle.com/javase/8/docs/api/index.html?java/awt/image/BufferedImage.html)在内存生成图片，再使用[`ImageIO`](https://docs.oracle.com/javase/8/docs/api/index.html?javax/imageio/ImageIO.html)输出。

画图使用[`Graphics`](https://docs.oracle.com/javase/8/docs/api/index.html?java/awt/Graphics.html),旋转使用[`Graphics2D`](https://docs.oracle.com/javase/8/docs/api/index.html?java/awt/Graphics2D.html)

汉字的区间：`\u4e00`-`\u9fa5`

### 刷新和缓存

- 刷新：一般不在servlet里加`refresh`头，而是在jsp加入`<meta>`头模拟。
- 缓存：加入`expires`头,当前时间+要缓存的时长

### 请求重定向

**重定向**：设置状态码和`location`头即可，或者直接使用`response`的`sendRedirect`方法。向服务器两次请求。浏览器会改变地址栏，一般适用于登录、购物等场景。

**转发**:则是调用`ServletContex`对象的`getRequestDispatcher`方法，再调用`forward`方法。向服务器一次请求，浏览器地址栏不变。

一些细节：

- `getOutputStream`和`getWriter`方法跟别用于输出二进制数据、输出文本数据的`ServletOutputStream`、`Printwriter`对象，这两个方法相互排斥，只能调用其中一个，否则抛`IllegalStateException`异常。
- response的输出流会自己关闭。`Servlet`的`service`方法结束后，Servlet引擎会检查并调用`close`方法关闭该输出流对象。


## request

- URI:标识某个资源
- URL:标识互联网上某个资源

一些方法

- `getRequestURI`用于权限拦截，访问统计
- `getRemoteAddr`用于得到客户机IP地址
- `getMethod`得到客户机请求方式

requst对象获取数据的四种方式

- `getParameter`
- `getParameterNames`
- `getParameterValues`
- `getParameterMap`(可结合JavaBean使用)

(`getInputStream`用于文件上传)


### 中文乱码
url后面如果有中文数据，需要编码后再提交

表单提交的数据使用的码表和该页面的码表一致，而`getParameter`方法默认使用`ISO-8859`码表。

解决：

- 对于post提交的数据，在获取数据前要使用`request`对象的`setCharacterEncoding`设置码表。
- 对于get提交的数据，只能手工解决。先对数据调用`getBytes("ISO-8859-1")`获取二进制字节，再用特定码表构建字符串。
- 超链提交的中文，解决办法同get提交的数据。

*也可以通过改服务器配置来解决乱码问题，但一般**不建议**使用。*

- `URIEncoding`:改tomcat的配置文件`conf/server.xml`的连接器`<Connector>`中的`URIEncoding`属性
- `useBodyEncodingForURI`:将`conf/server.xml`的连接器`<Connector>`中的`useBodyEncodingForURI`置为`true`

### 请求转发

应用场景：MVC设计模式

- model : javabean;
- view : jsp;
- controller : servlet

使用request域对象把数据带给转发资源。调用`request`对象的`getRequestDispatcher`方法，再调用`forward`方法。一次请求，浏览器地址栏不变。

`forward`一些细节

- 不能在关闭输出流后再调用转发，也不能调用两次，否则会抛出异常。
- 跳转之前会清空response中的数据。即数据只是写入到缓冲区而没真正输出到客户端，则可调用`forward`方法，原来写入到缓冲区的内容被清空，但响应头字段信息保持。

`include`方法可以用于包含一些公共页面(一般不在servlet中包含)

### 地址的写法

以斜杠`/`开头。如果是给服务器用，则`/`代表当前web应用；如果给浏览器用，则`/`代表网站。 

例子:目录结构如下

```
mail---------------------------Web应用所在目录
           |----form1.html
           |----WEB-INF目录
                    |---------classes目录
                    |---------lib目录
                    |---------web.xml
```

1. `request.getRequestDispatcher("/form1.html")`
2. `response.sendRedirect("mail/form1.html")`
3. `this.getServletContext().getRealPath("/form1.html")`
4. `this.getServletContext().getResourceAsStream("/form1.html")`
5. `<a href="/mail/form1.html">`
6. `<form action="/mail/form1.html">`

其中，1,3,4是给服务器用;2,5,6是浏览器用 

### 防盗链

读取`referer`请求头，不合要求则重定向。

-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

