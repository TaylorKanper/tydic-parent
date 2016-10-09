package com.tydic.util;

import java.util.Random;


public class RandomUtil {
    /**
     * 随机码集合
     */
    private static final String[] randCode = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    /**
     * @Description: 产生指定长度的随机码
     * @param codeLength
     * @return
     * @Title: RandomCodeUtil.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-5-28 上午11:11:55
     * @version V2.0
     */
    public static String randomCode(Integer codeLength) {
        try {
            StringBuffer code = new StringBuffer();
            if (null == codeLength || 0 == codeLength) {
                codeLength = 4;
            }
            for (int i = 0; i < codeLength; i++) {
                code.append(randCode[(int) Math.floor(Math.random() * 10)]);
            }
            return code.toString();
        } catch (Exception e) {
            throw new RuntimeException("Random Code Error");
        }
    }

    /**
     * @Description: 生成长度为4的随机码
     * @return
     * @throws Exception
     * @Title: RandomCodeUtil.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-5-28 下午01:19:33
     * @version V2.0
     */
    public static String randomCode() {
        return randomCode(null);
    }

    public static String randomMixedCode(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();// 随机用以下三个随机生成器
        Random randdata = new Random();
        int data = 0;
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(3);
            // 目的是随机选择生成数字，大小写字母
            switch (index) {
            case 0:
                data = randdata.nextInt(10);// 仅仅会生成0~9
                sb.append(data);
                break;
            case 1:
                data = randdata.nextInt(26) + 65;// 保证只会产生65~90之间的整数
                sb.append((char) data);
                break;
            case 2:
                data = randdata.nextInt(26) + 97;// 保证只会产生97~122之间的整数
                sb.append((char) data);
                break;
            }
        }
       return sb.toString();
    }
}