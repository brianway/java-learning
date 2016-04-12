# javaweb入门笔记(2)-http入门

标签： javaweb http

----

**Contents**

- [javaweb入门笔记(2)-http入门](#javaweb入门笔记2-http入门)
  - [请求(Request)](#请求request)
    - [请求头字段](#请求头字段)
  - [响应(Response)](#响应response)
    - [响应状态行](#响应状态行)
    - [响应头字段](#响应头字段)



----

对HTTP协议早有了解，最近在看javaweb，视频中讲到了这部分，就把视频的内容整理归纳下



## 请求(Request)

一个完整的HTTP请求包括：一个请求行、若干请求头、以及实体内容

### 请求头字段

- Accept:用于告诉服务器，客户机支持的数据类型
- Accept-Charset:用于告诉服务器，客户机采用的编码
- Accept-Encoding:用于告诉服务器，客户机支持数据压缩格式
- Accept-Language:客户机的语言环境
- Host:客户机通过这个头告诉服务器，想访问的主机名
- If-Modified-Since:客户机通过这个头告诉服务器，资源的缓存时间
- Refer:客户机通过这个头告诉服务器，它是从哪个资源访问服务器的(防盗链)
- User-Agent:客户机通过这个头告诉服务器，客户机的软件环境
- Cookie:客户机通过这个头向服务器带数据
- Connection:这个请求完了，是保持连接还是关闭
- Range:断点下载
  - `bytes=n1-n2`,传输范围n1到n2字节
  - `bytes=n-`，传输web资源中第n个字节以后的所有内容
  - `bytes=n`,传输最后n个字节

## 响应(Response)

一个HTTP响应代表服务器向客户端回送的数据，包括：一个状态行、若干消息头、以及实体内容

### 响应状态行

![HTTP响应状态码简表](http://7xph6d.com1.z0.glb.clouddn.com/javaweb_HttpResponseStatus.png)

详情可参考

> [HTTP 状态消息](http://www.w3school.com.cn/tags/html_ref_httpmessages.asp)

### 响应头字段

- Location:这个头配合302状态码使用，用于告诉客户机找谁(location和302实现请求重定向)
- Server:服务器通过这个头，告诉浏览器服务器的类型
- Content-Encoding:服务器通过这个头，数据的压缩格式
  (相关java知识:`GZIPOutputStream`,包装流/底层流)
- Content-Length:服务器通过这个头，告诉浏览器回送数据的长度
- Content-Type:服务器通过这个头，告诉浏览器回送数据的类型
- Last-Modified:服务器通过这个头，告诉浏览器当前资源的缓存时间
- Refresh:服务器通过这个头，告诉浏览器隔多长时间刷新一次
- Content-Disposition:服务器通过这个头，告诉浏览器以下载方式打开
- Transfer-Encoding:服务器通过这个头，告诉浏览器数据的传送格式
- Etag:缓存相关的头部，用于实时性要求高的系统
- Expires:服务器通过这个头，告诉浏览器把回送的资源缓存多长时间，-1或0则不缓存
- Cache-Control和Pragma:no-cache,服务器通过这两个头，也是控制浏览器不要缓存数据
- Connection:断开连接/保持连接
- Date:当前时间
- Accept-Ranges:用来说明web服务器是否支持range。支持返回bytes;不支持返回none
- Content-Range:制定了返回web资源的字节范围，格式：`n1-n2/n_total`



-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

