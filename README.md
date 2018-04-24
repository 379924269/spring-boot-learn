# springboot-learn

## 1、实现功能：
* 表基本的curd操作、swaggerUI文档、shiro安全认证、alibaba数据库的监、集成测试、简单的自动生成代码

## 2、环境
* 系统环境：windows
* 工具：idea2017.15 + maven3.0.5 + jdk1.7 + tomcat8 + mysql5.1.28

## 3、结构
* 该项目由 springboot + swaggerUI + mybaits-plus + shiro
    * 用springboot基本上不用写配置，大大的简化了项目配置，让我们更专注业务，抛弃了传统的spring.xml配置
* 后端
    * SpringBoot 1.5.3.RELEASE
    * MyBatis-Plus 2.0.8
    * MyBatis 3.4.4
    * Spring 4.3.8.RELEASE
    * Shiro 1.4.0
    * Druid 1.0.31
    * kaptcha(com.github.penggle, 生成验证码)

## 4、项目启动3中方式
* 在IDE里运行GunsApplication类中的main方法启动（注意pom.xml中取消tomcat的注解，用springboot自带服务器）
* 执行如下maven命令:
    * clean package -Dmaven.test.skip=true,并从target目录中找到guns-1.0.0-SNAPSHOT.jar,并在jar包的目录下执行如下java命令,java -jar guns-1.0.0-SNAPSHOT.jar
* 如果是jar包。修改pom.xml中如下片段:
    * ````<packaging>jar</packaging>改为<packaging>war</packaging>````,（注意启动向的修改）并打包放入到tomcat中执行

## 3、灵活的打包配置profile，打包一般分为（测试、开发、发布）
参考地址：https://blog.csdn.net/lihe2008125/article/details/50443491

## 4、项目测试接口（controllerTest、serviceTest）：
* 测试其实是分两步：
    * 运行测试mvn test -Dmaven.surefire.debug
    * 运行远程配置，远程配置是debug模式开启的
    
* 测试配置参考地址：http://ningg.top/tool-personal-intellij-idea-debug-for-mvn-test/

## 5、日志lockback：
* lockback.xml 日志生成位置(windows,unix没测)，生成路径如下：
    * 如果log.dir = ../logs/项目名称/logs/日志名称，会生成到tomcat下面的logs里面
    * 如果log.dir = logs/日志名称,会生成到tomcat/bin下面
    * 如果log.dir=/log/日志名称,会生成到项目跟目录下面
   
## 6、SpringBoot-Cache(EhCache):
* 参考地址（https://blog.csdn.net/tony308001970/article/details/75005231）
    * 1、在项目启动类中开启缓存
    * 2、通过缓存注解操作缓存
        * 我用了shiro，所以存在缓存冲突，我度娘了一下，方法之一就是共享cache，解决方法和简单使用参考地址
        （http://weiqingfei.iteye.com/blog/2311564）

## 7、shiro的一些注意事项
* 参考文档地址[张开涛]：http://jinnianshilongnian.iteye.com/blog/2018936
    * 配置权限有3种方法：
        * 注解
        * 直接在需要配置权限的地方写代码（不推荐）
        * 动态配置（可以是写到数据库里面，也可以写到配置文件里面）（推荐）

## 一些注意事项
* springboot项目最低支持jdk1.7、tomcat8 

* 在springboot项目部署到tomcat下的时候遇到的问题：
    * springboot要求tomcat版本为8.0即以上，其他的解决思路参考：http://www.jb51.net/article/123206.htm


## 学习文档：
* https://github.com/dyc87112/SpringBoot-Learning