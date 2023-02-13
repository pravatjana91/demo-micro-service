package com.td.mybatismicroservice.config;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


@Configuration
@MapperScan(basePackages = "com.td.mybatismicroservice.mapper.primary", sqlSessionFactoryRef=MyBatisConfiguration.ONE_SESSION_FACTORY)
@MapperScan(basePackages = "com.td.mybatismicroservice.mapper.secondary", sqlSessionFactoryRef=MyBatisConfiguration.ANOTHER_SESSION_FACTORY)

public class MyBatisConfiguration {
	public static final String ONE_SESSION_FACTORY = "oneSessionFactory";
	public static final String ANOTHER_SESSION_FACTORY = "anotherSessionFactory";

	private static final String MYBATIS_CONFIG_LOCATION = "mybatis-details.config-location";
	private static final String MYBATIS_MAPPER_LOCATIONS = "mybatis-details.mapper-locations";
	private static final String MYBATIS_TYPE_ALIASES_PACKAGE = "mybatis-details.type-aliases-package";

	
	public static final String secondarySqlSessionTemplate = "secondarySqlSessionTemplate";
    
	public static final String primarySqlSessionTemplate = "primarySqlSessionTemplate";
	
	
	@Autowired
	private Environment env;

	@Bean(name = ONE_SESSION_FACTORY, destroyMethod = "")
	@Primary
	public SqlSessionFactoryBean sqlSessionFactory(@Named(DatabaseConfiguration.ONE_DATASOURCE) final DataSource oneDataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(oneDataSource);

		sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty(MYBATIS_TYPE_ALIASES_PACKAGE));
		sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(env.getProperty(MYBATIS_CONFIG_LOCATION)));
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty(MYBATIS_MAPPER_LOCATIONS)));

		SqlSessionFactory sqlSessionFactory;
		sqlSessionFactory = sqlSessionFactoryBean.getObject();
		//sqlSessionFactory.getConfiguration().addMapper(OneMapper.class);
		// Various other SqlSessionFactory settings
		return sqlSessionFactoryBean;
	}


	@Primary
	@Bean(name = primarySqlSessionTemplate)
	public SqlSessionTemplate sqlSessionTemplatePrimary(@Named(ONE_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/****************************************************/

	@Bean(name = ANOTHER_SESSION_FACTORY, destroyMethod = "")
	public SqlSessionFactoryBean censoSqlSessionFactory(@Named(DatabaseConfiguration.ANOTHER_DATASOURCE) final DataSource anotherDataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(anotherDataSource);

		sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty(MYBATIS_TYPE_ALIASES_PACKAGE));
		sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(env.getProperty(MYBATIS_CONFIG_LOCATION)));
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty(MYBATIS_MAPPER_LOCATIONS)));

		final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		//sqlSessionFactory.getConfiguration().addMapper(AnotherMapper.class);
		// Various other SqlSessionFactory settings

		return sqlSessionFactoryBean;
	}

	
	@Bean(name = secondarySqlSessionTemplate)
	public SqlSessionTemplate sqlSessionTemplateSecondary(@Named(ANOTHER_SESSION_FACTORY) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}