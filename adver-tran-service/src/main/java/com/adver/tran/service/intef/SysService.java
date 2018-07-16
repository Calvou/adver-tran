package com.adver.tran.service.intef;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.domain.req.ChangePWDReq;
import com.adver.tran.domain.req.LoginReq;
import com.adver.tran.domain.req.RegisterReq;
import com.adver.tran.domain.res.AuthTokenRes;
import com.adver.tran.domain.res.BaseRes;

public interface SysService {

	AuthTokenRes oauthToken(LoginReq req) throws BusinessException;

	BaseRes changePassword(ChangePWDReq changePWDReq) throws BusinessException;

	AuthTokenRes register(RegisterReq register) throws BusinessException;

}
