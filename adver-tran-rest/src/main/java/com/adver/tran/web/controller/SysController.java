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
import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.utils.MD5Utils;
import com.adver.tran.domain.base.ApiResponse;
import com.adver.tran.domain.req.ChangePWDReq;
import com.adver.tran.domain.req.LoginReq;
import com.adver.tran.domain.req.RegisterReq;
import com.adver.tran.domain.res.AuthTokenRes;
import com.adver.tran.domain.res.BaseRes;
import com.adver.tran.service.intef.SysService;
import com.adver.tran.web.base.BaseController;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "sys")
@Api(description = "系统管理")
public class SysController extends BaseController{

	@Autowired
	private SysService sysService;

	@Value(value="${yunzhi.crt.key}")
	private String crtKey;
	
	/**
	 * 登录功能
	 * @param req
	 * @return
	 * @throws BusinessException
	 */
	@ApiOperation(value = "登录功能", notes = "登录功能", httpMethod ="POST")
    @ApiImplicitParam(dataType = "LoginReq", name="req",value = "登录功能", required = true)
    @RequestMapping(value = "oauth2/token",method = RequestMethod.POST)
    public ApiResponse<AuthTokenRes> oauthToken(@Valid @RequestBody LoginReq req) throws BusinessException{
    	
    	ApiResponse<AuthTokenRes> apiResponse = getApiResponse(req);    	
    	AuthTokenRes vo = null;
		try {			
			//秘钥验证 - bussSeqNo - channelId - reqTime - data - key			
			String srcKey = req.getReqSign();
			if(srcKey.equals(MD5Utils.MD5(req.getBussSeqNo()+"-"+req.getChannelId()+"-"+req.getReqTime()
					+"-"+JSON.toJSONString(req.getReqData()) +"-"+this.crtKey))){
				throw new BusinessException(BaseCode.E_1001009999, "签名验证错误");
			}
			
			String account = req.getReqData().getAccount();
	    	String password = req.getReqData().getPassword();
	    	if(CheckParam.isNull(account)||CheckParam.isNull(password)){
	    		throw new BusinessException(BaseCode.E_1001009999, "用户名或密码错误");
	    	}
	    	vo = sysService.oauthToken(req);
		} catch (Exception e) {
			return handleBaseException(apiResponse,e);
		}
	    apiResponse.setResData(vo);    	
    	return apiResponse;
    }
    
	@ApiOperation(value = "修改密码", notes = "修改密码", httpMethod ="POST")
    @ApiImplicitParam(dataType = "ChangePWDReq", name="changePWDReq",value = "修改密码", required = true)
    @RequestMapping(value = "user/changePassword",method = RequestMethod.POST)
    public ApiResponse<BaseRes> changePassword(@Valid @RequestBody ChangePWDReq changePWDReq) throws BusinessException{
    	
    	ApiResponse<BaseRes> apiResponse = getApiResponse(changePWDReq);
    	BaseRes vo = null;
		try {
			//秘钥验证 - bussSeqNo - channelId - reqTime - data - key			
			String srcKey = changePWDReq.getReqSign();
			if(srcKey.equals(MD5Utils.MD5(changePWDReq.getBussSeqNo()+"-"+changePWDReq.getChannelId()+"-"+changePWDReq.getReqTime()
					+"-"+JSON.toJSONString(changePWDReq.getReqData())+"-"+this.crtKey))){
				throw new BusinessException(BaseCode.E_1001009999, "签名验证错误");
			}
			
			String uid = changePWDReq.getReqData().getUserId();
	    	String repwd = changePWDReq.getReqData().getRepassword();
	    	if(CheckParam.isNull(uid)||CheckParam.isNull(repwd)){
	    		throw new BusinessException(BaseCode.E_1001009999, "用户信息未上送");
	    	}
	    	vo = sysService.changePassword(changePWDReq);
		} catch (Exception e) {
			return handleBaseException(apiResponse,e);
		}
	    apiResponse.setResData(vo);    	
    	return apiResponse;    
    }
    
    @ApiOperation(value = "注册功能", notes = "注册功能", httpMethod ="POST")
    @ApiImplicitParam(dataType = "RegisterReq", name="req",value = "注册功能", required = true)
    @RequestMapping(value = "user/register",method = RequestMethod.POST)
    public ApiResponse<AuthTokenRes> register(@Valid @RequestBody RegisterReq register) throws BusinessException{    	
    	ApiResponse<AuthTokenRes> apiResponse = getApiResponse(register);
    	AuthTokenRes vo = null;
		try {
			//秘钥验证 - bussSeqNo - channelId - reqTime - data - key			
			String srcKey = register.getReqSign();
			if(srcKey.equals(MD5Utils.MD5(register.getBussSeqNo()+"-"+register.getChannelId()+"-"+register.getReqTime()
				+"-"+JSON.toJSONString(register.getReqData())+"-"+this.crtKey))){
				throw new BusinessException(BaseCode.E_1001009999, "签名验证错误");
			}
			vo = sysService.register(register);
		} catch (Exception e) {
			return handleBaseException(apiResponse,e);
		}
	    apiResponse.setResData(vo);    	
    	return apiResponse;    
    }    
    
}
