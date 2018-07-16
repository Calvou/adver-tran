package com.adver.tran.service.intef.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.domain.req.AdverNeedReq;
import com.adver.tran.domain.res.AdverNeedRes;
import com.adver.tran.domain.vo.NeedVo;
import com.adver.tran.service.BaseService;
import com.adver.tran.service.intef.AdverService;
import com.adver.tran.store.mongodb.entity.UserNeed;
import com.adver.tran.store.mongodb.repository.UserNeedRepository;

@Service
public class AdverServiceImpl extends BaseService implements AdverService {

	private static Logger logger = LoggerFactory.getLogger(AdverServiceImpl.class);
	
	@Resource
	private UserNeedRepository needRepository;
	
	@Override
	public AdverNeedRes adverNeed(AdverNeedReq req) throws BusinessException {
		
		//媒体需求 广告需求 前几条 - 分页
		//分类目查询 - 分页
		//按用户 / 类目 查询
		
		//默认情况下各个 分类查询前10+条记录
		
		//如果需求ID不为空则直接查询
		List<UserNeed> listdata = new ArrayList<UserNeed>();
		if(!CheckParam.isNull(req.getReqData().getNeedId())){
			UserNeed uneed = needRepository.findById(req.getReqData().getNeedId());
			listdata.add(uneed);
		}else if(!CheckParam.isNull(req.getReqData().getUserId())) {
			//请求包含用户ID时根据用户查询  - 用户+类目   / 用户	一个用户只属于一个类型所以不存在 用户 + 类型		
			if(!CheckParam.isNull(req.getReqData().getKeys())){
				//用户+类目 查询
				
			}else{
				//直接按照用户查询
				listdata = needRepository.findByUserId(req.getReqData().getUserId());
			}
		}else {
			//根据关键字 + 需求类型查询
			//按需求类型查询 - 查询媒体需求  或者 广告需求
			listdata = needRepository.findByType(req.getReqData().getType());
		}
		
		List<NeedVo> need = new ArrayList<>();
		for(UserNeed un : listdata){
			NeedVo vo = new NeedVo();
			vo.setId(un.getId());
			vo.setUserId(un.getUserId());
			vo.setType(un.getType());
			vo.setTopic(un.getTopic());
			vo.setPlatform(un.getPlatform());
			vo.setUrl(un.getUrl());
			need.add(vo);
		}
		
		AdverNeedRes res = new AdverNeedRes();
		res.setNeed(need);		
		return res;
	}

}
