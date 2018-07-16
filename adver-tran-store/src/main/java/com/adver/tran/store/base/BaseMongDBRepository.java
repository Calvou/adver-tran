package com.adver.tran.store.base;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 基础的Repository，所有Repositpory都需要继承
 * @author lgf
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseMongDBRepository<T,ID extends Serializable> extends MongoRepository<T, ID>{

}
