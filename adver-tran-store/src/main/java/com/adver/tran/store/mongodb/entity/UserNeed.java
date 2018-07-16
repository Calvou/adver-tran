package com.adver.tran.store.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_adver")
public class UserNeed {

	//用户推广需求 - 记录用户的需求 - 包括媒体 和 广告方 需求	
	//用户媒体信息-记录用户拥有的媒体平台
	
	@Id
	private String id; //ID
	//@Field("user_id")
	private String userId; //用户
	//@Field("type")
	private String type; //需求类型
	//@Field("topic")
	private String topic; //推广主题
	//@Field("keys")
	private String keys; //推广关键字
	//@Field("platform")
	private String platform; //目标平台
	//@Field("fans")
	private String fans; //目标粉丝数
	//@Field("keys")
	private String mediaKeys; //媒体关键词
	//@Field("headpic")
	private String headpic; //可推广类型
	//@Field("desc")
	private String desc; //推广描述
	//@Field("click_num")
	private String clicknum; //点击数
	//@Field("view_num")
	private String viewnum; //查看数
	//@Field("url")
	private String url; //媒体连接
	//@Field("imgs")
	private String imgs; //图片
	//@Field("leval")
	private String leval; //等级
	//@Field("flush_time")
	private String flushTime; //刷新时间
	//@Field("cr_time")
	private String crTime; //创建时间
	//@Field("up_time")
	private String upTime; //最后更新时间
	//@Field("sta")
	private String sta; //状态		
		
	public String getFans() {
		return fans;
	}
	public void setFans(String fans) {
		this.fans = fans;
	}
	public String getMediaKeys() {
		return mediaKeys;
	}
	public void setMediaKeys(String mediaKeys) {
		this.mediaKeys = mediaKeys;
	}
	public String getHeadpic() {
		return headpic;
	}
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getLeval() {
		return leval;
	}
	public void setLeval(String leval) {
		this.leval = leval;
	}
	public String getFlushTime() {
		return flushTime;
	}
	public void setFlushTime(String flushTime) {
		this.flushTime = flushTime;
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
	public String getClicknum() {
		return clicknum;
	}
	public void setClicknum(String clicknum) {
		this.clicknum = clicknum;
	}
	public String getViewnum() {
		return viewnum;
	}
	public void setViewnum(String viewnum) {
		this.viewnum = viewnum;
	}
	
}
