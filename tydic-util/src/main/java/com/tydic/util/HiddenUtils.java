package com.tydic.util;

/**
 * 隐藏字符串的工具类
 * 
 * @ClassName: HiddenUtils
 * @author kangpeng1
 * @date 2016年8月30日 下午4:13:28
 */
public class HiddenUtils {
  
    public static String hiddenPhone(String str) {
        return str.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
    public static String hiddenEmail(String str) {
        return str.replaceAll("(\\w{1})(\\w+)(\\w{1})(@\\w+)", "$1***$3$4");
    }
    
}
