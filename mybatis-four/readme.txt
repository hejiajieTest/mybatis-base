mybatis表关联一对多
有了前面几章的基础，对一些简单的应用是可以处理的，但在实际项目中，经常是关联表的查询，
比如：最常见到的多对一，一对多等。这些查询是如何处理的呢，这一讲就讲这个问题。
前面几篇教程中介绍的都是单表映射的一些操作，然而在我们的实际项目中往往是用到多表映射。在Java实体对象对中，
一对多可以根据List和Set来实现，两者在mybitis中都是通过collection标签来配合来加以实现。
这篇介绍的是多表中的多对一表关联查询。
应用场景：首先根据用户 ID 读取一个用户信息，然后再读取这个用户所发布贴子(post)。
1、先做一些准备工作
我们首先在创建一个 java 工程，工程名称为：mybatis04-one2many(下载)，还需要创建两张表，它们分别是用户表 user，和帖子表 post，一个户用户可以有多个帖子。
user表的结构和数据： 
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '',
  `mobile` int(10) unsigned NOT NULL DEFAULT '0',
  `created` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yiibai', '100', '2015-09-23 20:11:23');原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/mybatis/mybatis-one2many.html

帖子表 post 的结构和数据： 

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
CREATE TABLE `post` (
  `post_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `title` varchar(254) NOT NULL DEFAULT '',
  `content` text,
  `created` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', 'MyBatis关联数据查询', '在实际项目中，经常使用关联表的查询，比如：多对一，一对多等。这些查询是如何处理的呢，这一讲就讲这个问题。我们首先创建一个 post 表，并初始化数据.', '2015-09-23 21:40:17');
INSERT INTO `post` VALUES ('2', '1', 'MyBatis开发环境搭建', '为了方便学习，这里直接建立java 工程，但一般都是开发 Web 项目。', '2015-09-23 21:42:14');
INSERT INTO `post` VALUES ('3', '2', '这个是别人发的', 'content,内容...', '0000-00-00 00:00:00');
从上面应该看出，这几个帖子对应的 userid 都是1，所以需要用户表 user 里面有 id=1 的数据。可以修改成满足自己条件的数据，按照orm的规则，表肯定需要一个对象与之对应，所以我们增加一个 Post 类。