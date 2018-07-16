package com.adver.tran.store.mongodb.repository;

import org.springframework.stereotype.Repository;

import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.AdverPlatform;

@Repository
public interface AdverPlatformRepository extends BaseMongDBRepository<AdverPlatform,Long> {

	AdverPlatform findById(String id);

}
