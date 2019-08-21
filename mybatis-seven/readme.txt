mybatis集成spring
在前面的教程文章中，前面讲到有关 mybatis 连接数据库，然后进行进行数据增删改查，以及多表联合查询的例子，但很多的项目中，
通常会用 spring 这个粘合剂来管理 datasource 等。充分利用 spring 基于接口的编程，以及aop ,ioc 带来的方便。
用 spring 来管理 mybatis 与管理 hibernate 有很多类似的地方。在这一节中，我们重点介绍数据源管理以及 bean 的配置。
	整个Mybatis与Spring集成示例要完成的步骤如下：
	1、示例功能描述
	2、创建工程
	3、数据库表结构及数据记录
	4、实例对象
	5、配置文件
	6、测试执行，输出结果