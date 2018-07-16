package com.adver.tran.domain.vo;

import java.util.List;

import com.adver.tran.domain.base.ApiBaseReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class CategoryVo extends ApiBaseReq{

    @ApiModelProperty(required = true,notes = "名称")
	private String name;

    @ApiModelProperty(required = true,notes = "代码值")
	private String code;
    
    @ApiModelProperty(required = true,notes = "子代码")
	private List<CategoryVo> childs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<CategoryVo> getChilds() {
		return childs;
	}

	public void setChilds(List<CategoryVo> childs) {
		this.childs = childs;
	}
    
}
