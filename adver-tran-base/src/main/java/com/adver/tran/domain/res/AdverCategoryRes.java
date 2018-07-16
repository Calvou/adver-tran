package com.adver.tran.domain.res;

import java.util.List;

import com.adver.tran.domain.vo.CategoryVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AdverCategoryRes {
	
	@ApiModelProperty(required = true,notes = "类目列表")
	private List<CategoryVo> category;

	public List<CategoryVo> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryVo> category) {
		this.category = category;
	}	
	
}
