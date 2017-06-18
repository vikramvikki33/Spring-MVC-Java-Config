/**
 *
 */
package com.sounds.bvs.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Vikram
 *
 */
@Configuration
@ComponentScan("com.sounds")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

	private static final String PROP_DB_DRIVER_CLASS = "db.driverclass";
	private static final String PROPR_DB_URL = "db.url";
	private static final String PROP_DB_USER_NAME = "db.username";
	private static final String PROP_DB_PASSWORD = "db.password";

	private static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROP_HIBERNATE_THREAD_CONTEXT = "hibernate.current_session_context_class";
	private static final String PROP_HIBERNATE_DDL_GENERATION = "hibernate.hbm2ddl.auto";
	private static final String PROP_HIBERNATE_LASZY_INTIALIAZATION = "hibernate.enable_lazy_load_no_trans";

	private static final String PROP_ENTITY_LOCATION = "entity.location";


	@Resource
	Environment env;

	@Bean(name="dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROP_DB_DRIVER_CLASS));
		dataSource.setUrl(env.getRequiredProperty(PROPR_DB_URL));
		dataSource.setUsername(env.getRequiredProperty(PROP_DB_USER_NAME));
		dataSource.setPassword(env.getRequiredProperty(PROP_DB_PASSWORD));
		return dataSource;
	}

	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROP_ENTITY_LOCATION));
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager tanscationManager() {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory().getObject());
		return tx;

	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	private Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.setProperty(PROP_HIBERNATE_DIALECT, env.getRequiredProperty(PROP_HIBERNATE_DIALECT));
		prop.setProperty(PROP_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROP_HIBERNATE_SHOW_SQL));
		prop.setProperty(PROP_HIBERNATE_DDL_GENERATION, env.getRequiredProperty(PROP_HIBERNATE_DDL_GENERATION));
		prop.setProperty(PROP_HIBERNATE_THREAD_CONTEXT, env.getRequiredProperty(PROP_HIBERNATE_THREAD_CONTEXT));
		prop.setProperty(PROP_HIBERNATE_LASZY_INTIALIAZATION, env.getRequiredProperty(PROP_HIBERNATE_LASZY_INTIALIAZATION));
		return prop;
	}
}
