package com.adver.tran.store.mongodb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.UserTranRecord;

@Repository
public interface UserTranRecordRepository extends BaseMongDBRepository<UserTranRecord,Long> {

	UserTranRecord findById(String id);
	List<UserTranRecord> findByUserId(String userId);
	
		
}
