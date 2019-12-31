# springbootDemo
springboot的入门和深入

## 1.初步搭建springboot
  ### spring boot起步依赖（必要）
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.1.RELEASE</version>
	</parent>

  ### web功能的起步依赖（必要）
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>

  ### 热部署
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
	</dependency>

  ### 创建Application入口和测试Controller
  > 一定要特别注意两个类的目录等级
  
## 2.使用minIO对象存储库
  ### MinIO对象存储库依赖
   	<dependency>
		<groupId>io.minio</groupId>
		<artifactId>minio</artifactId>
		<version>6.0.11</version>
	</dependency>

  ### 完成文件放入对象存储库putObject
  > MinioObjectClient.getInstance().saveFile(objectName, file.getPath());

## 3.读取Yaml文件
  ### 读/写yaml文件依赖
  	<dependency>
        <groupId>org.jyaml</groupId>
        <artifactId>jyaml</artifactId>
        <version>1.3</version>
    </dependency>

  ### 完成读取并放入Map中
  > Map map =Yaml.loadType(file, HashMap.class);

## 4.集成MyBatis和MySql
  ### 添加 MyBatis依赖
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.2.0</version>
    </dependency>

  ### 添加 MySQL依赖
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.41</version>
    </dependency>
  
  > 创建一个model

  > 创建一个接口(用注解：@Mapper、@Select的方式)

  > 创建apllication.properites文件
  
  > 书写mysql驱动配置