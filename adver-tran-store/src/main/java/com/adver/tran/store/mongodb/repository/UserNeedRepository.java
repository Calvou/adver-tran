package com.adver.tran.store.mongodb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.UserNeed;

@Repository
public interface UserNeedRepository extends BaseMongDBRepository<UserNeed,Long> {

	UserNeed findById(String id);
	List<UserNeed> findByUserId(String userId);
	List<UserNeed> findByType(String type);
		
}
