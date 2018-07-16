package com.adver.tran.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.domain.base.ApiResponse;
import com.adver.tran.domain.req.FileReq;
import com.adver.tran.domain.res.FileRes;
import com.adver.tran.service.intef.FileService;
import com.adver.tran.web.base.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "file")
@Api(description = "代码参数相关接口")
public class FileController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileService fileService;

	@Value(value="${yunzhi.crt.key}")
	private String crtKey;
	
	/**
	 * 文件上传
	 * 
	 * @param FileReq
	 * @return ApiResponse<StudentReq>
	 * @throws Exception
	 */
	@ApiOperation(value = "文件上传", notes = "文件上传", httpMethod = "POST")
	@ApiImplicitParam(dataType = "FileReq", name = "fileReq", value = "文件上传", required = true)
	@PostMapping("fileSignUpload")
	public ApiResponse<FileRes> fileSignUpload(@Valid @RequestBody FileReq fileReq, BindingResult errors) throws BusinessException {
		ApiResponse<FileRes> response = getApiResponse(fileReq);
		FileRes vo;
		try {
			vo = fileService.fileSignUpload(fileReq);
		} catch (Exception e) {
			return handleBaseException(response, e);
		}
		response.setResData(vo);
		return response;
	}
	
	/**
	 * 文件上传
	 * 
	 * @param FileReq
	 * @return ApiResponse<FileReq>
	 * @throws Exception
	 */
	@ApiOperation(value = "文件删除", notes = "文件删除", httpMethod = "POST")
	@ApiImplicitParam(dataType = "FileReq", name = "fileReq", value = "文件上传", required = true)
	@PostMapping("fileDelete")
	public ApiResponse<FileRes> fileDelete(@Valid @RequestBody FileReq fileReq, BindingResult errors) throws BusinessException {
		ApiResponse<FileRes> response = getApiResponse(fileReq);
		FileRes vo;
		try {
			vo = fileService.fileDelete(fileReq);
		} catch (Exception e) {
			return handleBaseException(response, e);
		}
		response.setResData(vo);
		return response;
	}
	
	/**
	 * 附件资料列表
	 * 
	 * @param FileReq
	 * @return ApiResponse<FileReq>
	 * @throws Exception
	 */
	@ApiOperation(value = "附件资料列表-根据用户ID 或 文件类型查", notes = "附件资料列表-根据用户ID 或 文件类型查", httpMethod = "POST")
	@ApiImplicitParam(dataType = "FileListReq", name = "fileListReq", value = "附件资料上传", required = true)
	@PostMapping("getFiles")
	public ApiResponse<FileRes> getFiles(@Valid @RequestBody FileReq fileListReq , BindingResult errors) throws BusinessException {

		ApiResponse<FileRes> response = getApiResponse(fileListReq);
		FileRes vo;
		try {
			vo = fileService.getFiles(fileListReq);
		} catch (Exception e) {
			return handleBaseException(response, e);
		}
		response.setResData(vo);
		return response;
	}
    
    /**
     * 单个文件下载 --根据mongdb存储下载
     * @param CaseFileDownReq
     * @return ApiResponse<CaseFileDownRes>
     * @throws Exception
     */
    @ApiOperation(value = "单个文件下载,mongdb存储下载", notes = "单个文件下载,mongdb存储下载", httpMethod ="POST")
    @ApiImplicitParam(dataType = "CaseFileDataReq", name="caseFileDown",value = "单个文件下载,mongdb存储下载", required = true)
    @RequestMapping(value = "caseFileDown",method = RequestMethod.POST)
    public void caseFileDownFromMongDb(@Valid @RequestBody FileReq req) throws BusinessException{
		try {
			fileService.caseFileDown(req);
		} catch (Exception e) {
			return ;
		}
    	return ;
    }
	
}
