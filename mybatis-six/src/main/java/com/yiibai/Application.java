package com.yiibai;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mapper.GroupMaper;
import com.yiibai.mapper.UserGroupMaper;
import com.yiibai.mapper.UserMaper;
import com.yiibai.pojo.Group;
import com.yiibai.pojo.User;
import com.yiibai.pojo.UserGroup;

public class Application {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testAddGroup();
		// testAddUser();
		// testAddUserGroup();
		testGetGroupAndUsers();
		
	}
	
	public static void testGetGroupAndUsers() {
		UserGroup userGroup = new UserGroup();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			GroupMaper groupMaper = session.getMapper(GroupMaper.class);
			Group group = groupMaper.getGroup(1);
			System.out.println("Group => " + group.getGroupName());
			List<User> users = group.getUsers();
			for (User user : users) {
				System.out.println("\t:" + user.getId() + "\t"
						+ user.getUsername());
			}
		} finally {
			session.close();
		}
	}

	public static void testGetUserAndGroup() {
		UserGroup userGroup = new UserGroup();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			GroupMaper groupMaper = session.getMapper(GroupMaper.class);
			Group group = groupMaper.getGroup(1);
			System.out.println("Group => " + group.getGroupName());
			List<User> users = group.getUsers();
			for (User user : users) {
				System.out.println("\t:" + user.getId() + "\t"
						+ user.getUsername());
			}
		} finally {
			session.close();
		}
	}
	public static void testAddUserGroup() {
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupId(1);
		userGroup.setUserId(2);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserGroupMaper userGroupMaper = session
					.getMapper(UserGroupMaper.class);
			userGroupMaper.insertUserGroup(userGroup);

			session.commit();
		} finally {
			session.close();
		}

	}

	public static void testAddUser() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = new User();
			user.setUsername("User-name-1");
			user.setMobile("13838009988");
			UserMaper userMaper = session.getMapper(UserMaper.class);
			userMaper.insertUser(user);
			session.commit();
			// System.out.println(user.getGroupId());
		} finally {
			session.close();
		}
	}

	public static void testAddGroup() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Group group = new Group();
			group.setGroupName("用户组-1");
			GroupMaper groupMapper = session.getMapper(GroupMaper.class);
			groupMapper.insertGroup(group);
			session.commit();
			System.out.println(group.getGroupId());
		} finally {
			session.close();
		}
	}
}
