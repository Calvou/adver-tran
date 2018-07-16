package com.adver.tran.domain.req.vo;

import com.adver.tran.domain.base.ApiBaseReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class ParamCodeReqVo extends ApiBaseReq{

    @ApiModelProperty(required = true,notes = "代码类型")
	private String paramType;

    @ApiModelProperty(required = true,notes = "代码值")
	private String paramcode;

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamcode() {
		return paramcode;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}
    
}
