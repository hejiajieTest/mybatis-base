package com.yiibai.pojo;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int postId = 1;
			//Post post1 = session.selectOne("com.yiibai.userMaper.getPosts",postId);
			List<Post> list = session.selectList("com.yiibai.userMaper.getPosts");
			for(Post post :list){
				System.out.println("title: "+post.getTitle());
				System.out.println("userName: "+post.getUser().getUsername());
				
			}
		} finally {
			session.close();
		}
	}
}
