# online-mall-cake

## 介绍 🎧

长沙大学软件工程大三上学期JavaWeb课程设计作业

- Java Web程序设计任务教程 / 黑马程序员编著. -- 2版. -- 北京 ： 人民邮电出版社，2021.9  
- 工业和信息化精品系列教材
- ISBN 978-7-115-56685-0

与书上不同的是MySQL多建了一个ShoppingCart表，各表中的详情信息查看common模块下的com.wu.common.domain包

- github：https://github.com/1262917629/online-mall-cake/tree/master/omc-common/src/main/java/com/wu/common/domain

- gitee：https://gitee.com/GiteeOfMasker/online-mall-cake/tree/master/omc-common/src/main/java/com/wu/common/domain

## 使用技术

### 后端

- 选用语言：Java
- 应用框架：Spring Boot
- 分布式服务框架：Dubbo
- 持久层框架：Mybatis
- 注册中心：Zookeeper
- 身份权限认证：Spring Security
- 缓存：Redis
- 代理：Nginx

## 安装教程

### 后端

1. 下载Zookeeper(https://zookeeper.apache.org/releases.html)

2. 下载Redis(https://redis.io/)

3. 配置各模块下的application.yml，本次实验是集群配置，相应配置如下

   ```
     redis:
       sentinel:
         nodes: ip1:port1,ip2:port2,ip3:port3 // redis集群
         master: // 主机名
         password: pwd1 // 集群通讯密码
       password: pwd2 //连接集群密码
   ```

   ```
   dubbo:
     #应用名称
     application:
       name: // 服务名
     #配置注册中心
     registry:
       address: zookeeper:ip1:port1,ip2:port2,ip3:port3 // zookeeper注册中心集群
   ```

4. 先启动goods和user模块，再启动auth模块即可
