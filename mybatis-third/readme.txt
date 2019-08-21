mybatis增删改查
前面的小节我们已经讲到用接口的方式编程。使用这种方式，需要注意的一个地方就是，在User.xml  
配置文件中，mapper namespace="com.yiibai.mybatis.inter.IUser" ，命名空间对应非常重要，名称不能有错，
必须与我们定义的 package 和 接口一致。如果不一致就会出错，这一章主要在上一讲基于接口编程的基础上完成如下操作:
使用 mybatis 查询用户数据(读取用户列表)使用 mybatis 增加用户数据使用 mybatis 更新用户数据使用 mybatis 删除用户数据
查询数据，前面已经讲过简单的查询单个用户数据，在这里将查询出用户列表，要查询出列表，也就是返回 List, 
在我们这个例子中也就是List<User> , 要以这种方式返回数据，需要在User.xml里面配置返回的类型 resultMap, 
注意不是 resultType, 而这个resultMap 所对应的应该是我们自己配置。