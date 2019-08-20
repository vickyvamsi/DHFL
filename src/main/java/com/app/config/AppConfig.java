package com.app.config;


import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Student;
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.app")
@PropertySource("classpath:app.properties")

public class AppConfig implements WebMvcConfigurer{
	@Autowired
	private Environment env;
	@Bean
	BasicDataSource dsObj() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		
		ds.setInitialSize(3);
		ds.setMaxIdle(5);
		ds.setMinIdle(5);
		ds.setMaxTotal(10);
		return ds;
	}
	
	@Bean
	LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean ls=new LocalSessionFactoryBean();
	//	ls.setPackagesToScan("com.app");
		ls.setAnnotatedClasses(Student.class);
		ls.setDataSource(dsObj());
		ls.setHibernateProperties(props());
		return ls;
	}
	
	private Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql",env.getProperty( "showsql"));
		p.put("hibernate.formate_sql",env.getProperty("frmtsql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("ddl"));
		return p;
	}
	
	
	@Bean
	HibernateTemplate htObj() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}
	
	@Bean
	HibernateTransactionManager htmObj() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sfObj().getObject());
		return htm;
	}
	
	@Bean
	InternalResourceViewResolver vrObj() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix(env.getProperty("mvc.prefix"));
		vr.setSuffix(env.getProperty("mvc.suffix"));
		return vr;
	}
	
	@Bean
	JavaMailSenderImpl mail() {
		JavaMailSenderImpl mail=new JavaMailSenderImpl();
		mail.setHost(env.getProperty("host"));
		mail.setPort(587);
		mail.setUsername(env.getProperty("mailUn"));
		mail.setPassword(env.getProperty("mailPwd"));
		
		mail.setJavaMailProperties(mprops());
		return mail;
	}
	
	Properties mprops() {
	Properties p=new Properties();
	p.put("mail.smtp.auth", env.getProperty("auth"));
	p.put("mail.smtp.starttls.enable", env.getProperty("enable"));
		return p;
	}
	
	@Bean
	CommonsMultipartResolver cmrObj() {
		CommonsMultipartResolver cmr=new CommonsMultipartResolver();
		cmr.setMaxUploadSize(20170500);
		cmr.setMaxInMemorySize(20170500);
		return cmr;
	}
}
