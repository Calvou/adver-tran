package com.adver.tran.store.mongodb.entity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "biz_code_type")
public class BizCodeType {
	//业务代码类型
	
	@Id
	private String id; //ID
	//@Field("type_id")
	private String typeId; //类型ID
	//@Field("type_name")
	private String typeName; //类型名
	//@Field("sort")
	private String sort; //排序
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}

}
