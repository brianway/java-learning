# javaweb入门笔记(5)-cookie和session

标签： javaweb

----

**Contents**

- [javaweb入门笔记(5)-cookie和session](#javaweb入门笔记5-cookie和session)
  - [cookie](#cookie)
  - [session](#session)
    - [实现原理](#实现原理)
    - [应用案例](#应用案例)
  - [三个域对象](#三个域对象)



----

Cookie是客户端技术；Session是服务器端技术。

API:

>* [javax.servlet.http:Class Cookie](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html?javax/servlet/http/Cookie.html)
>* [javax.servlet.http:Interface HttpSession](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html?javax/servlet/http/HttpSession.html)

## cookie

一些细节：

- 一个cookie只能标识一种信息，至少含有标识该信息的名称和值
- 浏览器一般只允许存放300个cookie，每个站点最多存放20个，每个cookie大小限制为4KB
- 默认是会话级别cookie(存储于浏览器内存)，浏览器进程关闭则删除。有效期通过`maxAge`设置，存于硬盘，0表示删除
- 删除cookie时，path必须一致，否则不会删除

## session

session对象由服务器创建,一个浏览器(会话)独占一个session对象

session对象由服务器创建生命周期

- 创建：调用`request`对象的`getSession`方法后才会创建session对象;`getSession(false)`只获取， 不创建
- 销毁：默认30分钟没人使用则自动销毁。失效时间可在`web.xml`的`<session-config>`标签中使用`<session-timeout>`，单位分钟；也可调用`session`对象的`invalidate`方法销毁

### 实现原理

session基于cookie实现，将`JSESSIONID`写回浏览器，这个cookie(`JSESSIONID`)默认没设置有效期,关浏览器即销毁。可以自行回写`JSESSIONID`覆盖原cookie值

示例代码片段：

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String sessionid = session.getId();
    Cookie cookie = new Cookie("JSESSIONID",sessionid);
    cookie.setPath("/s1");
    cookie.setMaxAge(30*60);
    resp.addCookie(cookie);
}
```

### 应用案例

- 用户登录
- 防止表单重复提交
- 一次性验证码的校验

**小Tips**

- 一般大型网站不用session,使用cookie,减小服务器压力
- 若浏览器禁用cookie,需使用url自带sessionid，相关方法:`encodeURL`和`encodeRedirectURL`
- 禁止表单重复提交：在javascript或者服务器实现。javascript防不死，用户可通过修改js、自建表单提交，刷新页面，后退等方法重复提交；服务器实现是给每个表单一个随机表单号
- 生成表单号使用“令牌发生器”，为保证唯一性(减小重复概率)，使用单例。
- base64编码，三字节变四字节，每6位变8位(一字节)，高位补零，每字节最大值为63，故得名。
- md5，常用于保存密码(可能为防止破解会加随机数)，校验数据完整性


防止表单重复提交之令牌例子：

```java
package org.iot.data;

import sun.misc.BASE64Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by brian on 2016/1/27.
 */
public class TokenProcessor {//令牌
    /**
     * 1.构造方法私有
     * 2.自己创建一个
     * 3.对外暴露一个方法，允许获取上面创建的对象
     */

    private TokenProcessor(){}

    private  static final TokenProcessor instance = new TokenProcessor();

    public static TokenProcessor getInstance(){
        return instance;
    }

    public String genetateToken(){
        String token = System.currentTimeMillis()+new Random().nextInt()+"";

        try {
            MessageDigest md =  MessageDigest.getInstance("md5");
            byte [] md5 =  md.digest(token.getBytes());
            //base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
```


## 三个域对象

- Session
- Request
- ServletContext

容器选用经验：

- 数据显示完了就没用了，则选用Request
- 数据除了显示外，稍后还会用，则选用Session
- 数据除了显示外，不仅稍后会用，还会给别人用，则选用`ServletContext`


-----

> 作者[@brianway](http://brianway.github.io/)更多文章：[个人网站](http://brianway.github.io/) | [CSDN](http://blog.csdn.net/h3243212/) | [oschina](http://my.oschina.net/brianway)

