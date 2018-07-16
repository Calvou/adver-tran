package com.adver.tran.domain.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class ParamCodeRes {
	
	@ApiModelProperty(required = true,notes = "代码参数类型	")
	private String paramType     ;
	
	@ApiModelProperty(required = true,notes = "代码参数名称")
	private String paramName ;
	
	@ApiModelProperty(required = true,notes = "代码参数信息")
	private String paramResult ;

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamResult() {
		return paramResult;
	}

	public void setParamResult(String paramResult) {
		this.paramResult = paramResult;
	}

	
	
}
