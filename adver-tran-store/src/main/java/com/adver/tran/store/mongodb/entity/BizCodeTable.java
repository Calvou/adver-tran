package com.adver.tran.store.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "biz_code_table")
public class BizCodeTable {
	//业务代码表
	
	@Id
	private String id; //ID
	//@Field("type_id")
	private String typeId; //代码类型
	//@Field("dm")
	private String dm; //代码
	//@Field("mc")
	private String mc; //名称
	//@Field("pdm")
	private String pdm; //父级代码
	//@Field("desc")
	private String desc; //描述
	//@Field("order")
	private String order; //排序
	//@Field("cr_time")
	private String crTime; //创建时间
	//@Field("up_time")
	private String upTime; //最后更新时间
	//@Field("sta")
	private String sta; //状态
	
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
	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public String getPdm() {
		return pdm;
	}
	public void setPdm(String pdm) {
		this.pdm = pdm;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getCrTime() {
		return crTime;
	}
	public void setCrTime(String crTime) {
		this.crTime = crTime;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	
}
