# javaweb入门笔记(1)-Tomcat

标签： javaweb

----

**Contents**

- [javaweb入门笔记(1)-Tomcat](#javaweb入门笔记1-tomcat)
  - [Tomcat目录层次结构](#tomcat目录层次结构)
  - [启动Tomcat](#启动tomcat)
  - [官当配置文档](#官当配置文档)
  - [web应用](#web应用)
  - [Tomcat体系结构](#tomcat体系结构)
  - [相关小知识](#相关小知识)
  - [参考链接](#参考链接)



----




下载链接

>* [Apache Jakarta Project](http://jakarta.apache.org)
>* [Tomcat官网](http://tomcat.apache.org/)


## Tomcat目录层次结构

- bin:存放启动和关闭Tomcat的脚本文件
- conf:存放Tomcat服务器的配置文件
- lib:存放Tomcat服务器的支撑jar包
- logs:存放Tomcat的日志文件
- temp:存放Tomcat运行时产生的临时文件
- webapps:web应用所在的目录，即供外接访问的web资源的存放目录
- work:Tomcat的工作目录

上面的内容直接可在[Tomcat Doc-Directories and Files](http://tomcat.apache.org/tomcat-8.0-doc/introduction.html#Terminology)找到答案

## 启动Tomcat

`%CATALINA_HOME%/RUNNING.txt`有详细步骤，简单来说，已经配置好JDK环境的话，windows下直接双击`bin/startyp.bat`就行了

默认端口是8080，改端口：tomcat的`conf/server.xml`的`Connector`标签

常见启动问题

- JAVA_HOME环境变量
- 端口占用问题
- Catalina_home环境变量的设置问题

## 官当配置文档
多种配置方式

- `/META-INF/context.xml`
- `$CATALINA_BASE/conf/[enginename]/[hostname]/`
- `conf/server.xml`

> 具体参考[Context配置](http://tomcat.apache.org/tomcat-8.0-doc/config/context.html#Defining_a_context)

## web应用

1.web应用与web应用所在的目录
一个**web应用**由多个静态web资源和动态web资源组成；组成web应用的这些文件会由一个目录组织起来，这个目录称为**web应用所在目录**


2.虚拟目录的映射
把主机上的资源映射到服务器对外提供的访问路径上

3.例子

tomcat的`conf/server.xml`:`<Host>`元素->`<Context>`,一个`<Context>`对应一个web应用。

`<Context path="/virtual-path" docBase="webapps-path" />`,重启web服务器

4.web应用的组成结构

```
mail---------------------------Web应用所在目录
           |----html、jsp、css、js等文件，根目录下的文件外界可以直接访问
           |----WEB-INF目录
                    |---------classes目录(java类)
                    |---------lib目录(java类运行所需的jar包)
                    |---------web.xml(web应用的配置文件)
             WEB-INF 这个目录下的文件外界无法直接访问，由web服务器负责调用
```


## Tomcat体系结构

![Tomcat体系结构](http://7xph6d.com1.z0.glb.clouddn.com/javaweb_tomcat%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84.png)



- tomcat的https连接器

`keytool -genkey alias tomcat -keyalg RSA`得到`.keystore`文件


- Tomcat管理平台
主页->Tomcat Manager

相关权限和用户配置在`conf/tomcat-users.xml`




## 相关小知识

1.域名和主机名的区别

| 域名  |     sina.com  |
| -------:  | :----:  | :----:  |
| 主机名  |     www.sina.com  |


2.url中主机名的作用：

- 用于访问DNS服务器获取IP
- 用于告诉代理服务器要访问哪个主机名


## 参考链接

> [Tomcat安装、配置、优化及负载均衡详解
](http://www.cnblogs.com/rocomp/p/4802396.html)


-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

