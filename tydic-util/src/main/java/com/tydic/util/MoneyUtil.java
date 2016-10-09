package com.tydic.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MoneyUtil {

    /**
     * 货币本地化，默认为中国
     */
    private static Locale locale=Locale.CHINA;

    /**
     * 精度，精确到小数点后多少位，默认是2位
     */
    private static Integer scale=2;

    /**
     * 分转换为元表示,包括符号，默认精度为小数点后2位,默认货币单位为人民币。如：234324分转化为人民币表示：￥2,343.24<br/>
     * 如果输入参数为空，返回￥0.00值<br/>
     * 如果输入参数为负数，返回类似￥-*.**值
     * @param cent the cent
     * @return the string
     */
    public static String fen2yuan(Long cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        if(cent!=null && cent<0L){
            NumberFormat numberFormat=NumberFormat.getInstance();
            Currency currency = Currency.getInstance(locale);
            return currency.getSymbol()+numberFormat.format(yuan);
        }

        NumberFormat numberFormat=NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(yuan);
    }

    public static String fen2yuan(Double cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        if(cent!=null && cent<0L){
            NumberFormat numberFormat=NumberFormat.getInstance();
            Currency currency = Currency.getInstance(locale);
            return currency.getSymbol()+numberFormat.format(yuan);
        }

        NumberFormat numberFormat=NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(yuan);
    }

    public static String fen2yuan(Integer cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        if(cent!=null && cent<0L){
            NumberFormat numberFormat=NumberFormat.getInstance();
            Currency currency = Currency.getInstance(locale);
            return currency.getSymbol()+numberFormat.format(yuan);
        }

        NumberFormat numberFormat=NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(yuan);
    }


    public static float fen2YuanNoSymbol(Integer cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        return yuan.floatValue();
    }

    public static float fen2YuanNoSymbol(Double cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        return yuan.floatValue();
    }

    public static float fen2YuanNoSymbol(Long cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        return yuan.floatValue();
    }

    /**
     * 分转化成元，固定两位小数
     * @param cent
     * @return
     */
    public static String fen2YuanForSap(Long cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        DecimalFormat df = new DecimalFormat("#0.00");

        return df.format(yuan);
    }

    /**
     * 分转化成元，固定两位小数
     * @param cent
     * @return
     */
    public static String fen2YuanForSap(Integer cent){

        BigDecimal yuan=point2ten(cent);
        if(null==yuan){
            yuan=new BigDecimal(0L);
        }
        DecimalFormat df = new DecimalFormat("#0.00");

        return df.format(yuan);
    }

    /**
     * 元转化为分.
     *
     * @param yuan the yuan
     * @return the long
     */
    public Long yuan2Fen(Long yuan){
        return ten2Point(yuan);
    }
    /**
     * 元转化为分.
     *
     * @param yuan the yuan
     * @return the long
     */
    public static Long yuan2Fen(Float yuan){
    	return ten2Point(yuan);
    }

    /**
     * 元转化为分.
     *
     * @param yuan the yuan
     * @return the long
     */
    public static Long yuan2Fen(Double yuan){
        return ten2Point(yuan);
    }

    /**
     * 元转化为分.
     *
     * @param yuan the yuan
     * @return the long
     */
    public Long yuan2Fen(Integer yuan){
        return ten2Point(yuan);
    }

    private static BigDecimal point2ten(Integer point){
        if(null==point){
            point=0;
        }
        BigDecimal centBigDecimal=new BigDecimal(point);
        if(null==scale){
            scale=2;
        }
        BigInteger divisor= BigInteger.valueOf(1L);
        for(int i=0;i<scale;i++){
            divisor=divisor.multiply(BigInteger.valueOf(10L));
        }
        return centBigDecimal.divide(new BigDecimal(divisor)).setScale(scale);
    }

    private static BigDecimal point2ten(Double point){
        if(null==point){
            point=0.00d;
        }
        BigDecimal centBigDecimal=new BigDecimal(point);
        if(null==scale){
            scale=2;
        }
        BigInteger divisor=BigInteger.valueOf(1L);
        for(int i=0;i<scale;i++){
            divisor=divisor.multiply(BigInteger.valueOf(10L));
        }
        return centBigDecimal.divide(new BigDecimal(divisor)).setScale(scale);
    }

    /**
     * Point2ten.
     *
     * @param point the point
     * @return the big decimal
     */
    private static BigDecimal point2ten(Long point){
        if(null==point){
            point=0L;
        }
        BigDecimal centBigDecimal=new BigDecimal(point);
        if(null==scale){
            scale=2;
        }
        BigInteger divisor=BigInteger.valueOf(1L);
        for(int i=0;i<scale;i++){
            divisor=divisor.multiply(BigInteger.valueOf(10L));
        }
        return centBigDecimal.divide(new BigDecimal(divisor)).setScale(scale);
    }

    /**
     * ten2Point.
     *
     * @param ten the ten
     * @return the long
     */
    private static Long ten2Point(Long ten){
        if(null==ten){
            return null;
        }
        if(null==scale){
            scale=2;
        }
        BigInteger multiplier=BigInteger.valueOf(1L);
        for(int i=0;i<scale;i++){
            multiplier=multiplier.multiply(BigInteger.valueOf(10L));
        }
        BigInteger tenBigInteger= BigInteger.valueOf(ten);
        return tenBigInteger.multiply(multiplier).longValue();
    }

    /**
     * ten2Point.
     *
     * @param ten the ten
     * @return the long
     */
    private static Long ten2Point(Integer ten){
        if(null==ten){
            return null;
        }
        if(null==scale){
            scale=2;
        }
        BigInteger multiplier=BigInteger.valueOf(1L);
        for(int i=0;i<scale;i++){
            multiplier=multiplier.multiply(BigInteger.valueOf(10L));
        }
        BigInteger tenBigInteger= BigInteger.valueOf(ten);
        return tenBigInteger.multiply(multiplier).longValue();
    }

    /**
     * ten2Point.
     *
     * @param ten the ten
     * @return the long
     */
    private static Long ten2Point(Double ten){
        if(null==ten){
            return null;
        }
        if(null==scale){
            scale=2;
        }
        BigDecimal multiplier=BigDecimal.valueOf(1L);
        for(int i=0;i<scale;i++){
            multiplier=multiplier.multiply(BigDecimal.valueOf(10L));
        }
        BigDecimal tenBigDecimal=BigDecimal.valueOf(ten.doubleValue());
        return tenBigDecimal.setScale(scale, RoundingMode.HALF_UP).multiply(multiplier).longValue();
    }
    /**
     * ten2Point.
     *
     * @param ten the ten
     * @return the long
     */
    private static Long ten2Point(Float ten){
    	if(null==ten){
    		return null;
    	}
    	if(null==scale){
    		scale=2;
    	}
    	BigDecimal multiplier=BigDecimal.valueOf(1L);
    	for(int i=0;i<scale;i++){
    		multiplier=multiplier.multiply(BigDecimal.valueOf(10L));
    	}
    	BigDecimal tenBigDecimal=BigDecimal.valueOf(ten.floatValue());
    	return tenBigDecimal.setScale(scale, RoundingMode.HALF_UP).multiply(multiplier).longValue();
    }
}

