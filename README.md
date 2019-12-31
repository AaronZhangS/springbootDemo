# springbootDemo
springboot的入门和深入

## 初步搭建springboot
<!-- spring boot起步依赖 -->
  ### spring boot起步依赖（必要）
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.1.RELEASE</version>
	</parent>
<!-- web功能的起步依赖 -->
  ### web功能的起步依赖（必要）
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
<!-- 热部署 -->
  ### 热部署
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
	</dependency>
  ### 创建Application入口和测试Controller
  >一定要特别注意两个类的目录等级
  
## 使用minIO对象存储库
  >完成文件放入对象存储库putObject
