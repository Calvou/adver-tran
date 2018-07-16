package com.adver.tran.conf;

//@Configuration
public class DataSourceConf {/*

	@Bean(name="primaryDataSource", destroyMethod = "close")
	@Qualifier("primaryDataSource")
	public DataSource druidDataSource(@Value("${spring.datasource.url}") String url,
			@Value("${spring.datasource.driver-class-name}") String driver,
			@Value("${spring.datasource.username}") String username,
			@Value("${spring.datasource.password}") String passwd) throws Exception{
		DruidDataSource drds = new DruidDataSource();
		drds.setUrl(url);
		drds.setDriverClassName(driver);
		drds.setUsername(username);
		drds.setPassword(passwd);
		drds.setMaxActive(300);
		drds.setInitialSize(6);
		drds.setMaxWait(60000);
		drds.setTimeBetweenEvictionRunsMillis(60000);
		drds.setMinEvictableIdleTimeMillis(300000);
		drds.setValidationQuery("SELECT '*' ");
		drds.setMaxOpenPreparedStatements(20);
		drds.setRemoveAbandoned(true);
		drds.setRemoveAbandonedTimeout(1800);
		drds.setLogAbandoned(false);
		try {
			drds.setFilters("stat");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return drds;
	}
	
*/}
