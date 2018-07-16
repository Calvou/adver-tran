package com.adver.tran.service.intef.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adver.tran.common.exception.BusinessException;
import com.adver.tran.common.utils.CheckParam;
import com.adver.tran.domain.req.AdverCategoryReq;
import com.adver.tran.domain.req.ParamCodeReq;
import com.adver.tran.domain.res.AdverCategoryRes;
import com.adver.tran.domain.res.ParamCodeRes;
import com.adver.tran.domain.vo.CategoryVo;
import com.adver.tran.service.BaseService;
import com.adver.tran.service.intef.ParamCodeService;
import com.adver.tran.store.mongodb.entity.BizCodeTable;
import com.adver.tran.store.mongodb.repository.BizCodeTableRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Service
public class ParamCodeServiceImpl extends BaseService implements ParamCodeService {

	private static Logger logger = LoggerFactory.getLogger(ParamCodeServiceImpl.class);
	@Autowired
	private BizCodeTableRepository codeTableRepository;
	
	/**
	 * 根据代码类型 和 代码值进行查询
	 */
	@Override
	public ParamCodeRes findParamCode(ParamCodeReq req) throws BusinessException {
		logger.debug(" === >开始 findParamCode :"+JSON.toJSONString(req)+"< === ");
		List<BizCodeTable> list = new ArrayList<BizCodeTable>();
		if(!CheckParam.isNull(req.getReqData().getParamcode())&&!CheckParam.isNull(req.getReqData().getParamType())){
			List<BizCodeTable> pc = codeTableRepository.findByTypeIdAndDm(req.getReqData().getParamType(), req.getReqData().getParamcode());
			list.add(pc.get(0));
		}else if(!CheckParam.isNull(req.getReqData().getParamType())){
			list = codeTableRepository.findByTypeId(req.getReqData().getParamType());
		}else {
			list = codeTableRepository.findAll();
		}
		ParamCodeRes pvo = new ParamCodeRes();
		pvo.setParamType(req.getReqData().getParamType());
		pvo.setParamResult(JSONArray.toJSONString(list));
		logger.debug(" === >结束findParamCode :"+list.size()+"< === ");
		return pvo;
	}

	@Override
	public AdverCategoryRes adverCategory(AdverCategoryReq req) throws BusinessException {
		logger.debug(" === >开始 adverCategory :"+JSON.toJSONString(req)+"< === ");
		List<CategoryVo> category = new ArrayList<CategoryVo>();
		if(!CheckParam.isNull(req.getReqData().getCode())){
			List<BizCodeTable> codeList = codeTableRepository.findByTypeIdAndDm("adv_cate", req.getReqData().getCode());
			codeList.stream().forEach(t -> {
				CategoryVo vo = new CategoryVo();
				vo.setCode(t.getDm());
				vo.setName(t.getMc());
				
				List<BizCodeTable> codeListnew = codeTableRepository.findByTypeIdAndPdm("adv_cate", t.getDm());
				List<CategoryVo> childs = new ArrayList<CategoryVo>();
				codeListnew.stream().forEach(k -> {
					CategoryVo vok = new CategoryVo();
					vok.setCode(t.getDm());
					vok.setName(t.getMc());
					childs.add(vok);
				});
				vo.setChilds(childs);
				category.add(vo);
			});			
		}else {
			List<BizCodeTable> codeList = codeTableRepository.findByTypeIdAndPdmIsNull("adv_cate");
			codeList.stream().forEach(t -> {
				CategoryVo vo = new CategoryVo();
				vo.setCode(t.getDm());
				vo.setName(t.getMc());
				
				List<BizCodeTable> codeListnew = codeTableRepository.findByTypeIdAndPdm("adv_cate", t.getDm());
				List<CategoryVo> childs = new ArrayList<CategoryVo>();
				codeListnew.stream().forEach(k -> {
					CategoryVo vok = new CategoryVo();
					vok.setCode(t.getDm());
					vok.setName(t.getMc());
					childs.add(vok);
				});
				vo.setChilds(childs);
				category.add(vo);
			});			
		}
		AdverCategoryRes pvo = new AdverCategoryRes();
		pvo.setCategory(category);
		logger.debug(" === >结束adverCategory :"+pvo.getCategory().size()+"< === ");
		return pvo;
	
	}

	
	
}
