package com.adver.tran.service.intef;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.domain.req.AdverCategoryReq;
import com.adver.tran.domain.req.ParamCodeReq;
import com.adver.tran.domain.res.AdverCategoryRes;
import com.adver.tran.domain.res.ParamCodeRes;

public interface ParamCodeService {

	public ParamCodeRes findParamCode(ParamCodeReq stureq) throws BusinessException;

	public AdverCategoryRes adverCategory(AdverCategoryReq req) throws BusinessException;
	
}
