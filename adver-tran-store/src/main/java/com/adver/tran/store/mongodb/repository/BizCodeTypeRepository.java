package com.adver.tran.store.mongodb.repository;

import org.springframework.stereotype.Repository;

import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.BizCodeType;

@Repository
public interface BizCodeTypeRepository extends BaseMongDBRepository<BizCodeType,Long> {

	BizCodeType findById(String id);
	
		
}
