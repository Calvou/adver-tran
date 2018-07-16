package com.adver.tran.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.utils.BaseCode;
import com.adver.tran.common.utils.MD5Utils;
import com.adver.tran.domain.base.ApiResponse;
import com.adver.tran.domain.req.AdverCategoryReq;
import com.adver.tran.domain.req.AdverNeedReq;
import com.adver.tran.domain.res.AdverCategoryRes;
import com.adver.tran.domain.res.AdverNeedRes;
import com.adver.tran.service.intef.AdverService;
import com.adver.tran.service.intef.ParamCodeService;
import com.adver.tran.web.base.BaseController;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "adver")
@Api(description = "代码参数相关接口")
public class AdverController extends BaseController{

	@Autowired
	private ParamCodeService paramCodeService;
	@Autowired
	private AdverService adverService;
	
	@Value(value="${yunzhi.crt.key}")
	private String crtKey;
	
	/**
     * 代码参数信息查询
     * @param ParamCodeReq
     * @return ApiResponse<StudentReq>
     * @throws Exception 
     */
    @ApiOperation(value = "代码参数信息查询", notes = "代码参数信息查询", httpMethod ="POST")
    @ApiImplicitParam(dataType = "ParamCodeReq", name="req",value = "代码参数信息查询", required = true)
    @RequestMapping(value = "adverCategory",method = RequestMethod.POST)
    public ApiResponse<AdverCategoryRes> adverCategory(@Valid @RequestBody AdverCategoryReq req) throws BusinessException{
        ApiResponse<AdverCategoryRes> micResponse = getApiResponse(req);
        AdverCategoryRes vo;
		try {
			//秘钥验证 - bussSeqNo - channelId - reqTime - data - key			
			String srcKey = req.getReqSign();
			if(srcKey.equals(MD5Utils.MD5(req.getBussSeqNo()+"-"+req.getChannelId()+"-"+req.getReqTime()
					+"-"+JSON.toJSONString(req.getReqData())+"-"+this.crtKey))){
				throw new BusinessException(BaseCode.E_1001009999, "签名验证错误");
			}
			vo = paramCodeService.adverCategory(req);
		} catch (Exception e) {
			return handleBaseException(micResponse,e);
		}
		micResponse.setResData(vo);
    	return micResponse;
    }
	
    /**
     * 需求查询
     * @param AdverNeedReq
     * @return ApiResponse<AdverNeedReq>
     * @throws Exception 
     */
    @ApiOperation(value = "需求查询", notes = "需求查询", httpMethod ="POST")
    @ApiImplicitParam(dataType = "AdverNeedReq", name="req",value = "需求查询", required = true)
    @RequestMapping(value = "adverNeed",method = RequestMethod.POST)
    public ApiResponse<AdverNeedRes> adverNeed(@Valid @RequestBody AdverNeedReq req) throws BusinessException{
        ApiResponse<AdverNeedRes> micResponse = getApiResponse(req);
        AdverNeedRes vo;
		try {
			//秘钥验证 - bussSeqNo - channelId - reqTime - data - key			
			String srcKey = req.getReqSign();
			if(srcKey.equals(MD5Utils.MD5(req.getBussSeqNo()+"-"+req.getChannelId()+"-"+req.getReqTime()
					+"-"+JSON.toJSONString(req.getReqData())+"-"+this.crtKey))){
				throw new BusinessException(BaseCode.E_1001009999, "签名验证错误");
			}
			vo = adverService.adverNeed(req);
		} catch (Exception e) {
			return handleBaseException(micResponse,e);
		}
		micResponse.setResData(vo);
    	return micResponse;
    }
}
