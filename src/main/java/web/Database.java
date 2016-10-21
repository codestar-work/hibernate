package web;

import javax.sql.*;
import java.util.*;
import org.springframework.orm.hibernate5.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
@EnableTransactionManagement
public class Database {

	@Value("${db.driver}")
	private String driver;

	@Value("${db.password}")
	private String password;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String user;

	@Value("${db.dialect}")
	private String dialect;

	@Value("${db.packagesToScan}")
	private String folder;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(driver);
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		return source;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(dataSource());
		session.setPackagesToScan(folder);
		Properties hibernate = new Properties();
		hibernate.put("hibernate.dialect", dialect);
		hibernate.put("hibernate.show_sql", "false");
		hibernate.put("hibernate.hbm2ddl.auto", "false");
		session.setHibernateProperties(hibernate);

		return session;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager m = new HibernateTransactionManager();
		m.setSessionFactory(sessionFactory().getObject());
		return m;
	}

}
