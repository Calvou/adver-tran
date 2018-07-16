package com.adver.tran.common.consts;

/**
 * Created by lgf
 */
public enum RedisCachePreKeyEnum {
	
	/**
	 * 用户信息，缓存
	 * */
	userInfo("1000_userInfo_", 1 * 60 * 60l),
	
	/**
	 * 用户服务密码状态
	 * */
	adverUserToken("1000_userLoginToken_", 1 * 60 * 60l);
	
	
    private String key;
    private long time;

    RedisCachePreKeyEnum(String key, long time){
        this.key = key;
        this.time=time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
