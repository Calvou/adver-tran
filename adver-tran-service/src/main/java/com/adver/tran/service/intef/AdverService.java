package com.adver.tran.service.intef;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.domain.req.AdverNeedReq;
import com.adver.tran.domain.res.AdverNeedRes;

public interface AdverService {

	AdverNeedRes adverNeed(AdverNeedReq req) throws BusinessException;


	
}
