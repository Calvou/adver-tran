package com.adver.tran.store.mongodb.repository;

import org.springframework.stereotype.Repository;
import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.User;

@Repository
public interface UserRepository extends BaseMongDBRepository<User,Long> {

	User findById(String id);
	User findByAccount(String account);

}
