package com.tydic.util.redis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
public final class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 批量删除对应的value
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     */
    public String get(final String key) {
        Object result = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return (String) result;
    }

    /**
     * 写入缓存
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     */
    public boolean set(final String key, String value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 自增
     * @param key
     * @return
     */
    public Long inrc(final String key){
        return redisTemplate.opsForValue().increment(key,1l);
    }


    /**
     * 获取分布式的锁
     * @param key
     * @return
     */
    public Boolean getDistributedKey(String key){
        try {
            Long keyValue=this.inrc(key);
            if(keyValue==1){
                return  true;
            }
            return  false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}
