package com.tydic.util;

import java.util.regex.Pattern;

public class ItemImageUtil {

	public static final Integer IMAGE_SIZE = 512000; // 商品发布商品图片上传大小限制 500k
	public static final String IMAGE_REG = "(?i).+?\\.(JPEG|jpeg|JPG|jpg|GIF|gif|BMP|bmp|PNG|png)";// 图片格式正则表达式
	public static final Pattern imagePattern = Pattern.compile(IMAGE_REG); // 图片正则表达式

}
