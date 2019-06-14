package com.gzg.config;

import com.gzg.annotation.CustomizeMapperScan;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author guozengguang
 * @date 2019-06-12 11:46
 */
@Configuration
@ComponentScan("com.gzg")
//@ImportResource("classpath:spring.xml")
//@MapperScan("com.gzg.dao")
//@Import(SpringImportBeanDefinitionRegistrar.class)
@CustomizeMapperScan
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setUrl("jdbc:mysql://10.211.55.3:3307/xc_course?useUnicode=true&useSSL=false");
		return driverManagerDataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}
}
