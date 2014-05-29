package tom.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import tom.dao.IUser;
import tom.po.UserEntity;

/**
 * @author cuipeijun
 * 
 */
public class Test {
	private static SqlSessionFactory getSessionFactory() throws Exception {
		SqlSessionFactory sessionFactory = null;
		String resource = "src/tom/config/mybatis-config.xml";
		
		File file=new File(resource);
		System.out.println(file.getAbsolutePath());
		InputStream inputStream = new FileInputStream(file);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		inputStream.close();
		return sessionFactory;
	}

	public static void main(String arg[]) throws Exception {
		
		SqlSession session = getSessionFactory().openSession();
		IUser iUser = session.getMapper(IUser.class);
		UserEntity userEntity = iUser.findById(1);
		System.out.println(userEntity.getUsername());
		System.out.println(userEntity.getPassword());
	}
}
