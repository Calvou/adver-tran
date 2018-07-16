package com.adver.tran.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoURI;

@Configuration
@EnableMongoRepositories(basePackages = "com.adver.tran.store.mongodb",
        mongoTemplateRef = MongoConfig.MONGO_TEMPLATE)
public class MongoConfig {

	protected static final String MONGO_TEMPLATE = "mongoTemplate";
	
	@Value("${spring.mongodb.host}")
    private String host;
	@Value("${spring.mongodb.port}")
	private int port;
	@Value("${spring.mongodb.database}")
	private String db;
	@Value("${spring.mongodb.username}")
	private String username;
	@Value("${spring.mongodb.password}")
	private String passwd;

    @Bean(name = MongoConfig.MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory(host,port,username,passwd,db));
    }

    @Bean
    public MongoDbFactory primaryFactory(String host, int port, String username, String password, String dbBase) throws Exception {
        //return new SimpleMongoDbFactory(new MongoClient(host, port),dbBase);
    	//return new SimpleMongoDbFactory(new MongoClient(host, port),dbBase,userCredentials(username,password));
    	//mongodb://user:pwd@ip1:port1,ip2:port2/database
    	return new SimpleMongoDbFactory(new MongoURI("mongodb://"+username+":"+password+"@"+host+":"+port+"/"+dbBase));
    }	
    
}
