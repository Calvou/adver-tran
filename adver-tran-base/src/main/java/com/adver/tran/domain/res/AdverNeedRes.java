package com.adver.tran.domain.res;

import java.util.List;

import com.adver.tran.domain.vo.NeedVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AdverNeedRes {
	
	@ApiModelProperty(required = true,notes = "需求列表")
	private List<NeedVo> need;

	public List<NeedVo> getNeed() {
		return need;
	}

	public void setNeed(List<NeedVo> need) {
		this.need = need;
	}
	
}
