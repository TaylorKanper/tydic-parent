package com.tydic.util.redis;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

@Deprecated
public class RedisUtils{

    //登录数据放到一个库中
    public static final String BIZ_LOGN="WDOPLOGIN";

    private static JedisPool pool;
    public static interface CallBack<T>{
		public T doAction(Jedis jedis);
	}
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        if (bundle == null) {
            throw new IllegalArgumentException("[app.properties] not found");
        }
        GenericObjectPoolConfig jedisConfig = new GenericObjectPoolConfig();
        jedisConfig.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
        jedisConfig.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        jedisConfig.setMaxWaitMillis(30 * 1000);
        jedisConfig.setMinIdle(50);
        jedisConfig.setTestOnBorrow(true);
        jedisConfig.setTestOnReturn(true);
        pool = new JedisPool(jedisConfig, bundle.getString("redis.ip"),Integer.valueOf(bundle.getString("redis.port")), 2 * 60 * 1000);

    }

    /**
     * 切库操作
     * @param bizName
     * @param jedis
     */
    public static void selectDataBase(String bizName , Jedis jedis){
        int index = 0;
        if(StringUtils.isNotBlank(bizName)){
            index = Math.abs(bizName.hashCode())%8;
        }
        jedis.select(index);
    }


    public static <T> T doAction(CallBack<T> call){

    	Jedis jedis = pool.getResource();
        try {
            return call.doAction(jedis);
        } finally {
            returnResource(jedis);
        }
    }


    public static void returnResource(Jedis jedis){
        if (jedis != null) {
            jedis.close();
        }
    }

    public static void cacheObject(String key, Map<String, String> cacheMap){
        cacheObject(null, key, cacheMap);
    }

    public static void cacheObject(String bizName , String key, Map<String, String> cacheMap){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.hmset(key, cacheMap);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static List<String> getCacheObjectByKey(String key, String... propertyName){
        return getCacheObjectByKey(null, key, propertyName);
    }

    public static List<String> getCacheObjectByKey(String bizName , String key, String... propertyName){
        Jedis jedis = null;
        List<String> values = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            values = jedis.hmget(key, propertyName);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return values;
    }

    public static void hmset(String key, Map<String, String> cacheMap){
        hmset(null, key, cacheMap);
    }

    public static void hmset(String bizName , String key, Map<String, String> cacheMap){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.hmset(key, cacheMap);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static List<String> hmget(String key, String... propertyName){
        return hmget(null, key, propertyName);
    }

    public static List<String> hmget(String bizName ,String key, String... propertyName){
        Jedis jedis = null;
        List<String> values = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            values = jedis.hmget(key, propertyName);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return values;
    }

    public static void cacheList(byte[] key, List<? extends Serializable> s){
        cacheList(null, key, s);
    }

    public static void cacheList(String bizName ,byte[] key, List<? extends Serializable> s){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.set(key, SerializeUtil.serialize(s));
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static List<? extends Serializable> getCacheList(byte[] key){
        return getCacheList(null, key);
    }

    public static List<? extends Serializable> getCacheList(String bizName ,byte[] key){
        Jedis jedis = null;
        List<? extends Serializable> values = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            values = SerializeUtil.deserialize(jedis.get(key));
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return values;
    }

    public static void cacheSerializable(byte[] key, Serializable s){
        cacheSerializable(null, key, s);
    }

    public static void cacheSerializable(String bizName ,byte[] key, Serializable s){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.set(key, SerializeUtil.serializeS(s));
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static Serializable getCachedSeralizable(byte[] key){
        return getCachedSeralizable(null, key);
    }

    public static Serializable getCachedSeralizable(String bizName ,byte[] key){
        Jedis jedis = null;
        Serializable serializable = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            serializable = SerializeUtil.deserializeS(jedis.get(key));
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return serializable;
    }


    public static String getDefaultNickNameSerial(String key){
        return  getDefaultNickNameSerial(null, key);
    }

    public static String getDefaultNickNameSerial(String bizName , String key){
        Jedis jedis = null;
        String nickName = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            if (jedis.get(key) == null) {
                jedis.set(key, "1");
            }else{
                jedis.incr(key);
            }
            nickName = jedis.get(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return nickName;
    }

    public static void zadd(String key, Double score, String member){
        zadd(null, key, score, member);
    }

    public static void zadd(String bizName , String key, Double score, String member){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.zadd(key, score, member);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void sadd(String key, String member){
        sadd(null, key, member);
    }

    public static void sadd(String bizName , String key, String member){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.sadd(key, member);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void sadd(String bizName, String key, String[] members) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.sadd(key, members);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static boolean sismember(String key, String member){
        return sismember(null, key, member);
    }

    public static boolean sismember(String bizName , String key, String member){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            return jedis.sismember(key, member);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void sdiffstore(String dstkey, String... keys) {
        sdiffstore(null, dstkey, keys);
    }

    public static void sdiffstore(String bizName , String dstkey, String... keys) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.sdiffstore(dstkey, keys);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static Set<String> smembers(String key){
        return smembers(null, key);
    }

    public static Set<String> smembers(String bizName , String key){
        Jedis jedis = null;
        Set<String> members = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            members = jedis.smembers(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return members;
    }

    public static void srem(String key){
        srem(null, key, null);
    }

    public static void srem(String key, String members){
        srem(null, key, members);
    }

    public static void srem(String bizName , String key , String members){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            if(StringUtils.isBlank(members)){
                jedis.srem(key);
            }else{
                jedis.srem(key, members);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void hset(String key, String field, String value){
        hset(null, key, field, value);
    }

    public static void hset(String bizName , String key, String field, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.hset(key, field, value);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static String hget(String key, String field){
        return hget(null, key, field);
    }

    public static String hget(String bizName , String key, String field){
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            value = jedis.hget(key, field);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        if (value == null)
            return "0";
        return value;
    }

    public static Long hincrBy(String key, String field, long value) {
        return hincrBy(null, key, field, value);
    }

    public static Long hincrBy(String bizName , String key, String field, long value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            return jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static Map<String, String> hgetAll(String key){
        return hgetAll(null, key);
    }

    public static Map<String, String> hgetAll(String bizName , String key){
        Jedis jedis = null;
        Map<String, String> map = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        if (map == null) {
            return new HashMap<String, String>();
        }
        return map;
    }

    public static void hdel(String bizName , String key, String... field){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.hdel(key, field);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static double zscore(String key, String member) {
        return zscore(null, key, member);
    }

    public static double zscore(String bizName , String key, String member) {
        Jedis jedis = null;
        double score = 0d;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            if(jedis.zscore(key, member)!=null){
                score = jedis.zscore(key, member);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return score;
    }

    public static long zrank(String key, String member){
        return zrank(null, key, member);
    }

    public static long zrank(String bizName , String key, String member){
        Jedis jedis = null;
        long rankPosition = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            Long zrankIndex = jedis.zrank(key, member);
            rankPosition = zrankIndex == null ? 0 : zrankIndex;
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return rankPosition;
    }

    public static long zRevRank(String key, String member){
        return zRevRank(null, key, member);
    }

    public static long zRevRank(String bizName , String key, String member){
        Jedis jedis = null;
        long rankPosition = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            Long zrankIndex = jedis.zrevrank(key, member);
            rankPosition = zrankIndex == null ? -1 : zrankIndex;
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return rankPosition + 1;
    }

    public static void setAndExpire(String key, String value, int seconds){
        setAndExpire(null, key, value, seconds);
    }

    public static void setAndExpire(String bizName , String key, String value, int seconds){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.set(key, value);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }
    
    /**
     * 设置key对应的值为string类型的value。如果key已经存在，返回0，nx:not exist
     * @param key
     * @param value
     */
    public static Long setnx(String key,String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.setnx(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void setex(String key,int seconds, String value){
        setex(null, key, seconds, value);
    }

    public static void setex(String bizName , String key,int seconds, String value){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.setex(key, seconds, value);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void set(String key, String value){
        set(null, key, value);
    }

    public static void binarySet( byte[]  key ,  byte[] value  )
    {
        binarySet( null , key , value );
    }

    public static void set(String bizName , String key, String value){
        set(bizName, key, value, null);
    }

    public static void binarySet( String bizName , byte[] key, byte[] value )
    {
        binarySet( bizName , key  , value );
    }

    public static void set(String bizName , String key, String value , Integer seconds){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.set(key, value);
            if(seconds!=null && seconds>0){
                jedis.expire(key, seconds);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void binarySet( String bizName , byte[] key, byte[] value ,Integer seconds ){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.set(key, value);
            if(seconds!=null && seconds>0){
                jedis.expire(key, seconds);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

        public static void expire(byte[] key, int seconds){
        expire(null, key, seconds);
    }

    public static void expire(String bizName , byte[] key, int seconds){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static String get(String key){
        return get(null, key);
    }

    public static byte[] binaryGet( byte[] key )
    {
        return binaryGet( null , key );
    }

    public static String get(String bizName , String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            result = jedis.get(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public static byte[] binaryGet( String bizName , byte[] key )
    {
        Jedis jedis = null;
        byte[] result = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            result = jedis.get(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public static void zRem(String key, String field) {
        zRem(null, key, field);
    }

    public static void zRem(String bizName , String key, String field) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.zrem(key, field);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static Set<String> zrange(String key, int start, int end) {
        return zrange(null, key, start, end);
    }

    public static Set<String> zrange(String bizName , String key, int start, int end) {
        Jedis jedis = null;
        Set<String> ranges = new HashSet<String>();
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            ranges = jedis.zrange(key, start, end);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return ranges;
    }

    public static Map<Double, String> zrangeWithScore(String key, int start, int end) {
        return zrangeWithScore(null, key, start, end);
    }

    public static Map<Double, String> zrangeWithScore(String bizName ,String key, int start, int end) {
        Jedis jedis = null;
        Set<Tuple> ranges = new HashSet<Tuple>();
        Map<Double, String> result = new HashMap<Double, String>();
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            ranges = jedis.zrangeWithScores(key, start, end);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        if (ranges == null || ranges.size() == 0)
            return result;
        for (Tuple tuple : ranges) {
            result.put(tuple.getScore(), tuple.getElement());
        }
        return result;
    }

    public static Set<String> zrangeByScore(String key, Double min, Double max, int offset, int count) {
        return zrangeByScore(null, key, min, max, offset, count);
    }

    public static Set<String> zrangeByScore(String bizName , String key, Double min, Double max, int offset, int count) {
        Jedis jedis = null;
        Set<String> ranges = new HashSet<String>();
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            ranges = jedis.zrangeByScore(key, min, max, offset, count);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return ranges;
    }

    public static Set<String> zrevrangeByScore(String key, Double max, Double min, int offset, int count) {
        return zrevrangeByScore(null, key, max, min, offset, count);
    }

    public static Set<String> zrevrangeByScore(String bizName,String key, Double max, Double min, int offset, int count) {
        Jedis jedis = null;
        Set<String> ranges = new HashSet<String>();
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            ranges = jedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return ranges;
    }

    public static Set<String> zrevrange(String key, int start, int stop) {
        return zrevrange(null, key, start, stop);
    }

    public static Set<String> zrevrange(String bizName , String key, int start, int stop) {
        Jedis jedis = null;
        Set<String> ranges = new HashSet<String>();
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            ranges = jedis.zrevrange(key, start, stop);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return ranges;
    }

    public static long zcard(String key) {
        return zcard(null, key);
    }

    public static long zcard(String bizName , String key) {
        Jedis jedis = null;
        long count = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            count = jedis.zcard(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return count;
    }

    public static long lpush(String key, String value) {
        return lpush(null, key, value);
    }

    public static long lpush(String bizName , String key, String value) {
        Jedis jedis = null;
        long count = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            count = jedis.lpush(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return count;
    }

    public static long lpush(String key, String[] values) {
        return lpush(null, key, values);
    }

    public static long lpush(String bizName, String key, String[] values) {
        Jedis jedis = null;
        long count = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            count = jedis.lpush(key, values);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return count;
    }

    public static String lpop(String key) {
        return lpop(null, key);
    }

    public static String lpop(String bizName, String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            result = jedis.lpop(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public static long llen(String key) {
        return llen(null, key);
    }

    public static long llen(String bizName, String key) {
        Jedis jedis = null;
        long result = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            result = jedis.llen(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    public static long lrem(String key, String value) {
        return lrem(null, key, value);
    }

    public static long lrem(String bizName , String key, String value) {
        Jedis jedis = null;
        long count = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            count = jedis.lrem(key, 0, value);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return count;
    }

    public static List<String> lrange(String key, int start, int count) {
        return lrange(null, key, start, count);
    }

    public static List<String> lrange(String bizName , String key, int start, int count) {
        Jedis jedis = null;
        List<String> ranges = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            ranges = jedis.lrange(key, start, count);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return ranges;
    }

    public static void del(Set<String> keys) {
        del(null, keys);
    }

    public static void del(String bizName ,Set<String> keys) {
        for (String key : keys) {
            del(key);
        }
    }

    public static long del(String key) {
        return del(null, key);
    }

    public static long del(String bizName , String key) {
        Jedis jedis = null;
        long delCount = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            delCount = jedis.del(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return delCount;
    }

    public static long del(String... keys) {
        return del(null, keys);
    }

    public static long del(String bizName , String... keys) {
        Jedis jedis = null;
        long delCount = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            delCount = jedis.del(keys);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return delCount;
    }

    public static long incr(String key) {
        return incr(null, key);
    }

    public static long incr(String bizName , String key) {
        Jedis jedis = null;
        long counter = 0l;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            counter = jedis.incr(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return counter;
    }

    public static Set<String> keys(String keyPattern) {
        return keys(null, keyPattern);
    }

    public static Set<String> keys(String bizName , String keyPattern) {
        Jedis jedis = null;
        Set<String> keys = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            keys = jedis.keys(keyPattern);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return keys;
    }

    public static Set<String> hkeys(String keyPattern) {
        return hkeys(null, keyPattern);
    }

    public static Set<String> hkeys(String bizName , String keyPattern) {
        Jedis jedis = null;
        Set<String> keys = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            keys = jedis.hkeys(keyPattern);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return keys;
    }

    /**
     * 严禁使用此命令 by huangwenwen
     * @param key
     * @return
     */
// public static void flushDb() {
//    Jedis jedis = null;
//    try {
//       jedis = pool.getResource();
//       jedis.flushDB();
//    } catch (Exception e) {
//       throw e;
//    } finally {
//       returnResource(jedis);
//    }
// }

    public static boolean exists(String key) {
        return exists(null, key);
    }

    public static boolean exists(String bizName,String key) {
        Jedis jedis = null;
        Boolean exist;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            exist = jedis.exists(key);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return exist == null ? false : exist.booleanValue();
    }


    public static boolean hexists(String key, String field) {
        return hexists(null, key, field);
    }

    public static boolean hexists(String bizName ,String key, String field) {
        Jedis jedis = null;
        Boolean exist;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            exist = jedis.hexists(key, field);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
        return exist == null ? false : exist.booleanValue();
    }


    /**
     * 从队列的右边插入一条数据
     * @param key
     * @param value
     */
    public static void rpushAndExpire(String key,String value,int seconds){
        rpushAndExpire(null, key, value, seconds);
    }


    public static void rpushAndExpire(String bizName , String key,String value,int seconds){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.rpush(key,value);
            jedis.expire(key,seconds);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }


    public static void expire(String key,int seconds){
        expire(null, key, seconds);
    }

    public static void expire(String bizName , String key,int seconds){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            jedis.expire(key,seconds);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }


    public static boolean getDistributeKLock(String key){
        return getDistributeKLock(null, key);
    }

    public static boolean getDistributeKLock(String bizName ,String key){
        long value = incrBy(bizName , key, 1L);
        return value==1;
    }

    public static long incrBy(String key , Long gap){
        return incrBy(null, key, gap);
    }

    public static long incrBy(String bizName , String key , Long gap){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            selectDataBase(bizName, jedis);
            return jedis.incrBy(key, gap);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

}