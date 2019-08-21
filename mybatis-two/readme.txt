mybatis接口注解
在上一章中，我们已经搭建了 myeclipse,mybatis,mysql 的开发环境，并且实现了 mybatis 的一个简单的查询。要注意的是，
这种方式是用 SqlSession 实例来直接执行在User.xml文件中映射的 SQL 语句：
session.selectOne("com.yiibai.mybatis.models.UserMapper.getUserByID", 1)，
但是还有比这更简单的方法，使用合理描述参数和SQL语句返回值的接口(比如：IUser.class)，
这样现在就可以不使用类似User.xml配置文件，至此更简单，代码更安全，不容易发生的字符串文字和转换的错误，
下面是项目创建的详细过程:

