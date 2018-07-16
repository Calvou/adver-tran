package com.adver.tran.service.intef;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.domain.req.FileReq;
import com.adver.tran.domain.res.FileRes;

public interface FileService {

	public FileRes fileSignUpload(FileReq fileReq) throws BusinessException;
	public FileRes getFiles(FileReq req) throws BusinessException;
	public void caseFileDown(FileReq req) throws BusinessException;
	public FileRes fileDelete(FileReq fileReq) throws BusinessException;
	
}
