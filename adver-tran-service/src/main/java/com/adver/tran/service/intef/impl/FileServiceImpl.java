package com.adver.tran.service.intef.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.utils.BaseCode;
import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.utils.CommonUtils;
import com.adver.tran.domain.req.FileReq;
import com.adver.tran.domain.req.vo.FileReqVo;
import com.adver.tran.domain.res.FileRes;
import com.adver.tran.domain.res.vo.FileVo;
import com.adver.tran.service.BaseService;
import com.adver.tran.service.intef.FileService;
import com.adver.tran.store.mongodb.entity.AdverFile;
import com.adver.tran.store.mongodb.repository.AdverFileRepository;
import com.alibaba.fastjson.JSON;

@Service
public class FileServiceImpl extends BaseService implements FileService {

	private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	@Autowired
	private AdverFileRepository fileRepository;
	

	@Override
	public FileRes fileSignUpload(FileReq fileReq) throws BusinessException {
		// 将文件存储
		// 保存附件包 --信息
		AdverFile applyfiles = new AdverFile();
		FileReqVo fcvo = fileReq.getReqData();
		applyfiles.setUserId(fcvo.getUserId());
		applyfiles.setId(CommonUtils.getUuidString());
		try {
			applyfiles = fileRepository.save(applyfiles);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("文件存储出错", e);
			throw new BusinessException(BaseCode.E_1001015006, "文件保存出错");
		}
		FileRes fres = new FileRes();
		
		List<FileVo> filesVo = new ArrayList<FileVo>();
		FileVo vo = new FileVo();
		vo.setUserId(applyfiles.getUserId());
		vo.setId(applyfiles.getId());
		filesVo.add(vo);
		fres.setFilesVo(filesVo);
		fres.setUserId(applyfiles.getUserId());
		logger.debug(" === >结束 fileSignUpload :" + JSON.toJSONString(fres) + "< === ");
		return fres;
	}

	@Override
	public FileRes getFiles(FileReq req) throws BusinessException {
		logger.debug(" === >开始 getFiles :" + JSON.toJSONString(req) + "< === ");
		// 查询文件列表
		String userId = req.getReqData().getUserId();
		String needId = req.getReqData().getNeedId();
		List<FileVo> filesList = new ArrayList<>();
		try {
			List<AdverFile> listFiles = fileRepository.findByNeedId(needId);
			if(CheckParam.isNull(listFiles)){
				listFiles = new ArrayList<>(); 
			}
			listFiles.stream().forEach(t -> {
				FileVo vo = new FileVo();
				filesList.add(vo);
			});	
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("文件列表异常", e);
			throw new BusinessException(BaseCode.E_1001015004, "文件列表异常");
		}
		FileRes res = new FileRes();
		res.setFilesVo(filesList);
		logger.debug(" === >结束 getFiles :" + JSON.toJSONString(res) + "< === ");
		return res;
	}

	@Override
	public void caseFileDown(FileReq req) throws BusinessException {

		logger.debug(" === >开始 caseFileDown :" + JSON.toJSONString(req) + "< === ");
		String fileId = req.getReqData().getId();
		try {
			//同时存储一份数据到 mongDb
			AdverFile afile = new AdverFile();
			afile = fileRepository.findById(fileId);
			if(!CheckParam.isNull(afile)){
				
			} else {
				throw new BusinessException(BaseCode.E_1001015005, "不存在附件资料！");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			logger.error(" === >caseFileDown 异常1:" + e);
			throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" === >caseFileDown 异常2:" + e);
			throw new BusinessException(BaseCode.E_1001015007, "文件生成异常");
		}
		logger.debug(" === >结束 caseFileDown < === ");
		return ;
	}

	@Override
	public FileRes fileDelete(FileReq req) throws BusinessException {
		logger.debug(" === >开始 fileDelete :" + JSON.toJSONString(req) + "< === ");
		String fileId = req.getReqData().getId();
		try {
			//同时存储一份数据到 mongDb
			AdverFile afile = new AdverFile();
			afile = fileRepository.findById(fileId);
			if(!CheckParam.isNull(afile)){
				
			} else {
				throw new BusinessException(BaseCode.E_1001015005, "不存在附件资料！");
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			logger.error(" === >caseFileDown 异常1:" + e);
			throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" === >caseFileDown 异常2:" + e);
			throw new BusinessException(BaseCode.E_1001015007, "文件生成异常");
		}
		logger.debug(" === >结束 fileDelete < === ");
		return new FileRes();
	}
	
}
