package com.adver.tran.domain.req.vo;

import com.adver.tran.domain.base.ApiBaseReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdverNeedReqVo extends ApiBaseReq{

	@ApiModelProperty(required = true,notes = "需求ID")
	private String needId ;
	@ApiModelProperty(required = true,notes = "需求类型-广告需求 和 媒体需求")
	private String type ;
	@ApiModelProperty(required = true,notes = "按照具体类目查询")
	private String keys ;
	
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public String getNeedId() {
		return needId;
	}
	public void setNeedId(String needId) {
		this.needId = needId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
