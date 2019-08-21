mybatis环境配置及入门
下面是对这几个配置文件一点解释说明：
1、配置文件 Configure.xml 是 mybatis 用来建立 sessionFactory，里面主要包含了数据库连接相关内容，
还有 java 类所对应的别名，比如：<typeAlias alias="User" type="com.yiibai.mybatis.models.User"/> 这个别名非常重要，在具体的类的映射中，比如：User.xml 中 resultType 就是对应这个。要保持一致，这里的 resultType 还有另外单独的定义方式，后面学习到我们再详细介绍说明。
2、Configure.xml 里面 的<mapper resource="com/yiibai/mybatis/models/User.xml"/>
是包含要映射的类的 xml 配置文件。
3、在User.xml 文件里面主要是定义各种 SQL 语句，以及这些语句的参数，以及要返回的类型等等。