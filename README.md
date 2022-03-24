# 关于EagleMap-sdk

EagleMap-sdk是基于EagleMap的restful接口实现的Java SDK的封装，实现了地图基础功能、轨迹服务、轨迹终端、轨迹、电子围栏等功能。EagleMap-sdk的依赖非常少，仅依赖了[hutool](https://www.hutool.cn/)工具包，尽可能的不对业务系统依赖环境产生困扰。

# 快速使用

EagleMap-sdk提供了两种方式与业务系统对接，分别是：

- java sdk方式
- Spring Boot集成方式

## java sdk方式

> **第一步，导入maven依赖**

~~~xml
<dependency>
    <groupId>cn.itcast.em</groupId>
    <artifactId>EagleMap-sdk</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
~~~

> **第二步，实例化EagleMapTemplate对象**

~~~java

String host = "127.0.0.1"; //EagleMap服务地址
int port = 8484; //EagleMap服务端口
int timeout = 1000; //http请求的超时时间

//实例化EagleMapTemplate对象
EagleMapTemplate eagleMapTemplate = new EagleMapTemplate(host, port, timeout);

//后续基于eagleMapTemplate可以调用EagleMap的各种服务
~~~



## Spring Boot集成方式

