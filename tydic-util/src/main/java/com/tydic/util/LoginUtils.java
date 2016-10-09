package com.tydic.util;


import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginUtils {


    /**
     * KEY
     */
    public static String LOGIN_CODE="loginCode";

    public static String LOGIN_ROLE="loginRole";
    public static String LOGIN_NAME="loginName";


    /**
     * 获得登录信息
     * @param login
     * @param Key
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Object getLoginInfo(String login,String Key){
        Map<String,Object> map =new HashMap<>();
        map=JSONObject.parseObject(login,map.getClass());
        return map.get(Key);
    }

}
