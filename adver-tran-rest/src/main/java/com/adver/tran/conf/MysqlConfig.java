package com.adver.tran.conf;

/**
 * Created by lgf on 2017/5/18.
 */
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary", 
//	basePackages = "com.domi.ifs.store.jpa.repository", 
//	transactionManagerRef = "transactionManagerPrimary")
//@EnableTransactionManagement(proxyTargetClass = true)
public class MysqlConfig {/*

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Primary
	@Bean(name = "entityManagerPrimary")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) throws Exception{
		return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactoryPrimary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) throws Exception{
		return builder.dataSource(primaryDataSource).properties(getVendorProperties(primaryDataSource))
				.packages("com.domi.ifs.store.jpa.entity") // 实体包路径
				.persistenceUnit("primaryPersistenceUnit").build();
	}

	@Autowired
	private JpaProperties jpaProperties;

	private Map<String, String> getVendorProperties(DataSource dataSource) throws Exception{
		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Primary
	@Bean(name = "transactionManagerPrimary")
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) throws Exception{
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}

*/}
