# springboot 学习
springboot学习整合springmvc + swaggerUI + mybaits-plus + shiro

springboot基本上不用写配置，大大的简化了项目配置，让我们更专注业务，抛弃了传统的spring.xml配置

### 如何启动项目
spring-boot-lean目前支持三种启动方式:
1. 在IDE里运行GunsApplication类中的main方法启动
2. 执行如下maven命令
```
clean package -Dmaven.test.skip=true
```
并从target目录中找到guns-1.0.0-SNAPSHOT.jar,并在jar包的目录下执行如下java命令
```
java -jar guns-1.0.0-SNAPSHOT.jar
```
3. 修改pom.xml中如下片段
```
<packaging>jar</packaging>
```
改为
```
<packaging>war</packaging>
```
并打包放入到tomcat中执行

### 注意
最新版项目最低支持jdk1.7

## 项目所用框架
### 后端
### 后端
1. SpringBoot 1.5.3.RELEASE
2. MyBatis-Plus 2.0.8
3. MyBatis 3.4.4
4. Spring 4.3.8.RELEASE
5. Shiro 1.4.0
6. Druid 1.0.31
7. kaptcha(com.github.penggle, 生成验证码)