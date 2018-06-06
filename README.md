# spring-boot-2


**spring boot 2.x + mybatis 整合**



#### mysql drive
1. JDBC 连接 mysql 5.0
```
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false
username=root
password=
```
2. JDBC 连接 mysql 6.0 以上

注意：

<font color="#FF7F00">连接mysql 8.0需要使用新的驱动，否则会出现异常</font>
```
新：com.mysql.cj.jdbc.Driver
旧：com.mysql.jdbc.Driver
```
异常信息：
> Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.


<font color="#FF7F00">需要设置时区等信息</font>

```
jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false
```
异常信息：
> java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.



##### maven
```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.11</version>
        </dependency>
```

