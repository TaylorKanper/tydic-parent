package com.tydic.util.redis;

public class RedisServiceUtil {

    /**
     * 判断一个操作是否达到一个是简单次数限制
     * @param operationName
     * @param OperationLimit
     * @param second
     * @return
     */
    @SuppressWarnings("deprecation")
	public static  boolean isOperationTimesReachLimit( String operationName , String userName , int OperationLimit , int second ) {
        long operationTimes  = RedisUtils.incr( operationName + userName );
        if( operationTimes  > operationTimes  )
            return  true;
        else{
            if( operationTimes == 1 )
                RedisUtils.expire( operationName + userName , second);
            return false;
        }
    }

}
