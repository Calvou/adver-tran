package com.adver.tran.store.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by lgf
 */
@Component
public class RedisCacheService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 保存信息
     * @param key
     * @param value
     * @param time  秒  大于等于0生效
     */
    public void set(String key, String value,Long time){
        if(time!=null && time>0){
            stringRedisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
        }else{
            stringRedisTemplate.opsForValue().set(key,value);
        }
    }

    /**
     * 获取缓存值
     * @param key
     * @return
     */
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存
     * @param key
     */
    public void remove(String key){
        stringRedisTemplate.opsForValue().getOperations().delete(key);
    }
    

}
