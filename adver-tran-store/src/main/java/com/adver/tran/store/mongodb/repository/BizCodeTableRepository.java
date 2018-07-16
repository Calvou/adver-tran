package com.adver.tran.store.mongodb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.adver.tran.store.base.BaseMongDBRepository;
import com.adver.tran.store.mongodb.entity.BizCodeTable;

@Repository
public interface BizCodeTableRepository extends BaseMongDBRepository<BizCodeTable,Long> {

	BizCodeTable findById(String id);
	List<BizCodeTable> findByTypeIdAndDm(String typeId, String dm);
	List<BizCodeTable> findByTypeIdAndPdm(String typeId, String dm);
	List<BizCodeTable> findByTypeId(String typeId);
	List<BizCodeTable> findByTypeIdAndPdmIsNull(String typeId);
	
}
