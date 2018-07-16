package com.adver.tran.service.intef.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adver.tran.common.consts.RedisCachePreKeyEnum;
import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.utils.BaseCode;
import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.common.utils.CommonUtils;
import com.adver.tran.common.utils.DateUtil;
import com.adver.tran.common.utils.MD5Utils;
import com.adver.tran.domain.SessionData;
import com.adver.tran.domain.req.ChangePWDReq;
import com.adver.tran.domain.req.LoginReq;
import com.adver.tran.domain.req.RegisterReq;
import com.adver.tran.domain.res.AuthTokenRes;
import com.adver.tran.domain.res.BaseRes;
import com.adver.tran.domain.res.vo.SysUserResVo;
import com.adver.tran.service.intef.SysService;
import com.adver.tran.store.mongodb.entity.User;
import com.adver.tran.store.mongodb.repository.UserRepository;
import com.adver.tran.store.redis.RedisCacheService;
import com.alibaba.fastjson.JSON;

@Service
public class SysServiceImpl implements SysService{

	private static Logger logger = LoggerFactory.getLogger(SysServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RedisCacheService redisService;

	@Override
	public AuthTokenRes oauthToken(LoginReq req) throws BusinessException {
		logger.debug(" === >开始 oauthToken :" + JSON.toJSONString(req) + "< === ");		
		AuthTokenRes res = new AuthTokenRes();
		try {
			String account = req.getReqData().getAccount();
	    	String password = req.getReqData().getPassword();
			logger.debug("登录验证开始 ： "+ account + "  "+ password );
			User user = userRepository.findByAccount(account);
			if(CheckParam.isNull(user)){
				throw new BusinessException(BaseCode.E_1001009999,"用户名或密码错误");
			}
			String strPass = user.getPasswd();
			logger.debug("登录验证中 ： "+ MD5Utils.MD5(password) + "  原："+ strPass +"   "+ strPass.equals(MD5Utils.MD5(password)));
			if(!strPass.equals(MD5Utils.MD5(password))){
				throw new BusinessException(BaseCode.E_1001009999,"用户名或密码错误");
			}
			
			res.setAuthToken(CommonUtils.getUuidString());
			SysUserResVo vo = new SysUserResVo();
			vo.setId(user.getId());
			vo.setName(user.getNickName());
			vo.setType(user.getType());
			res.setUserInfo(vo);
			
			//登录验证成功将数据存入Redis缓存
			SessionData sesData = new SessionData();
			sesData.setAccount(res.getUserInfo().getAccount());
			sesData.setUserName(res.getUserInfo().getName());
			sesData.setUserOrg(res.getUserInfo().getOrgId());
			sesData.setUserId(res.getUserInfo().getId());
			sesData.setType(res.getUserInfo().getType());
			
			redisService.set(RedisCachePreKeyEnum.adverUserToken.getKey()+""+res.getAuthToken(), JSON.toJSONString(sesData), new Long(1*60*60));
			
		} catch (BusinessException e) {
			e.printStackTrace();
			logger.error(e.getErrorCode(),e.getErrorMessage());
			throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户登录认证", e);
			throw new BusinessException(BaseCode.E_1001009999, "用户登录认证异常");
		}
		logger.debug(" === >结束 oauthToken :" + JSON.toJSONString(res) + "< === ");
		return res;
	}

	@Override
	public BaseRes changePassword(ChangePWDReq req) throws BusinessException {
		logger.debug(" === >开始 changePassword :" + JSON.toJSONString(req) + "< === ");
		BaseRes res = new BaseRes();
		try {
			User su = userRepository.findById(req.getReqData().getUserId());
			if(CheckParam.isNull(su)){
				throw new BusinessException(BaseCode.E_1001009999,"用户不存在！");
			}
			if(!su.getPasswd().equals(MD5Utils.MD5(req.getReqData().getPassword()))){
				throw new BusinessException(BaseCode.E_1001009999,"旧密码错误！");
			}
			logger.debug("密码修改前："+su.getPasswd());
			su.setPasswd(MD5Utils.MD5(req.getReqData().getRepassword()));
			logger.debug("密码修改中："+su.getPasswd());
			su.setUpTime(DateUtil.formatYh24ms(new Date()));
			su = userRepository.save(su);
			logger.debug("密码修改后："+su.getPasswd());		
		} catch (BusinessException e) {
			e.printStackTrace();
			logger.error(e.getErrorCode(),e.getErrorMessage());
			throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改密码",e);
		}
		logger.debug(" === >结束 changePassword :" + JSON.toJSONString(res) + "< === ");
		return res;
	}

	@Override
	public AuthTokenRes register(RegisterReq req) throws BusinessException {
		logger.debug(" === >开始register :" + JSON.toJSONString(req) + "< === ");		
		AuthTokenRes res = new AuthTokenRes();
		try {
			String nickname = req.getReqData().getNickname().trim();
			String account = req.getReqData().getAccount().trim();
	    	String password = req.getReqData().getPassword().trim();
			User user = userRepository.findByAccount(account);
			if(!CheckParam.isNull(user)){
				throw new BusinessException(BaseCode.E_1001009999,"账号已被注册");
			}
			
			user = new User();
			user.setId(CommonUtils.getUuidString());
			user.setAccount(account);
			user.setNickName(nickname);
			user.setPasswd(MD5Utils.MD5(password));
			
			user = userRepository.save(user);
						
			res.setAuthToken(CommonUtils.getUuidString());
			SysUserResVo vo = new SysUserResVo();
			vo.setId(user.getId());
			vo.setName(user.getNickName());
			res.setUserInfo(vo);
			
			//登录验证成功将数据存入Redis缓存
			SessionData sesData = new SessionData();
			sesData.setAccount(res.getUserInfo().getAccount());
			sesData.setUserName(res.getUserInfo().getName());
			sesData.setUserOrg(res.getUserInfo().getOrgId());
			sesData.setUserId(res.getUserInfo().getId());
			
			redisService.set(RedisCachePreKeyEnum.adverUserToken.getKey()+""+res.getAuthToken(), JSON.toJSONString(sesData), new Long(1*60*60));
			
		} catch (BusinessException e) {
			e.printStackTrace();
			logger.error(e.getErrorCode(),e.getErrorMessage());
			throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户登录认证", e);
			throw new BusinessException(BaseCode.E_1001009999, "用户登录认证异常");
		}
		logger.debug(" === >结束 register :" + JSON.toJSONString(res) + "< === ");
		return res;
	}
	
}
