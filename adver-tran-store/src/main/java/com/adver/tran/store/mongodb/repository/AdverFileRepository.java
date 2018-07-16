package com.adver.tran.store.mongodb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.AdverFile;

@Repository
public interface AdverFileRepository extends BaseMongDBRepository<AdverFile,Long> {

	AdverFile findById(String id);

	List<AdverFile> findByNeedId(String needId);

}
