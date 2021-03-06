 <img src="docs/images/itcast.png" style="zoom: 80%;" />  <img src="docs/images/logo.png" style="zoom: 80%;" />

# 关于EagleMap-sdk

EagleMap-sdk是基于EagleMap的restful接口实现的Java SDK的封装，实现了地图基础功能、轨迹服务、轨迹终端、轨迹、电子围栏等功能。EagleMap-sdk的依赖非常少，仅依赖了[hutool](https://www.hutool.cn/)工具包，尽可能的不对业务系统依赖环境产生困扰。

# 快速集成使用

EagleMap-sdk提供了两种方式与业务系统对接，分别是：

- java sdk方式
- Spring Boot集成方式

# 版本说明

> 建议使用稳定版。

| 项目                         | 最新稳定版 | 发布时间   |
| ---------------------------- | ---------- | ---------- |
| EagleMap-sdk                 | 1.0        | 2022-03-31 |
| eaglemap-spring-boot-starter | 1.0        | 2022-03-31 |

目前最新快照版为：1.1-SNAPSHOT

## java sdk方式

> **第一步，导入maven依赖**

~~~xml
<dependency>
    <groupId>com.itheima.em</groupId>
    <artifactId>EagleMap-sdk</artifactId>
    <version>{version}</version>
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
String ip = "114.242.26.45";
//根据ip地址查询对应的地区、经纬度坐标等信息
IpResult ipResult = eagleMapTemplate.opsForBase().queryIp(ip);
System.out.println(ipResult);
~~~

## Spring Boot集成方式

> eaglemap-spring-boot-starter源码：
>
> https://gitee.com/itcastopen/eaglemap-spring-boot-starter.git
>
> https://github.com/itcastopen/eaglemap-spring-boot-starter.git



> **第一步，导入maven依赖**

~~~xml
<dependency>
    <groupId>com.itheima.em</groupId>
    <artifactId>eaglemap-spring-boot-starter</artifactId>
    <version>{version}</version>
</dependency>

<!-- 如果是SNAPSHOT版本，如要在项目的pom.xml文件中引入快照版源 -->
<repositories>
    <repository>
        <id>sonatypeSnapshots</id>
        <name>Sonatype Snapshots</name>
        <releases>
            <enabled>false</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
</repositories>
~~~

> **第二步，配置application.yml文件**

~~~yml
eagle:
  host: 127.0.0.1 #EagleMap服务地址
  port: 8484 #EagleMap服务端口
  timeout: 10000 #http请求的超时时间
~~~

**第三步，测试用例**

~~~java
package cn.itcast.em.boot;

import EagleMapTemplate;
import IpResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EagleMapTest {

    @Autowired //自动注入
    private EagleMapTemplate eagleMapTemplate;

    @Test
    public void queryIp() {
        String ip = "114.242.26.45";
        //根据ip地址查询对应的地区、经纬度坐标等信息
        IpResult ipResult = this.eagleMapTemplate.opsForBase().queryIp(ip);
        System.out.println(ipResult);
    }

}
~~~



