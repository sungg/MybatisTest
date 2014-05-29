package tom.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author cuipeijun
 * 
 */
public class DB {
	private static SqlSessionFactory getSessionFactory() throws Exception {
		SqlSessionFactory sessionFactory = null;
		String resource = "src/tom/config/mybatis-config.xml";

		File file = new File(resource);
		System.out.println(file.getAbsolutePath());
		InputStream inputStream = new FileInputStream(file);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		inputStream.close();
		return sessionFactory;
	}
}
