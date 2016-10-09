package com.tydic.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


/**
 * @Description: Excel 生成通用类，为了兼容，所有 Excel 统一生成 Excel2003 即：xx.xls
 * @Project：javaUtils
 * @Author : 
 */
@Slf4j
public class ExcelExportHelper {
	
	/** 时间格式：默认为yyyy-MM-dd hh:mm:ss */
	private static String DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";
	
	/** 图片宽度，默认为：100 */
	private static int IMAGE_WIDTH = 30;
	 
	/** 图片高度，默认为：50 */
	private static int IMAGE_HEIGHT = 50;
	
	
	/**
	 * 
	 * 通用方法，使用 java 反射机制，根据提供表头 header ，数据列 excelList 生成 Excel,如有图片请转换为byte[]<br>
	 * header、properties需要一一对应：<Br>
	 * header = ["学号","年龄","性别","班级"]
	 * properties = ["id","age","sex","class"],其对应的excelList中javaBean的属性值
	 * 
	 * @author  
	 * 
	 * @param header  
	 * 				Excel表头
	 * @param properties  
	 * 				表头对应javaBean中的属性
	 * @param excelList  
	 * 				需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的 
	 * 				javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param sheetTitle  
	 * 				表格标题名
	 * 
	 * @return 生成的HSSFWorkbook
	 * @version 1.0
	 */
	private static HSSFWorkbook exportExcel(String[] header,String[] properties,List<Object> excelList,
			String sheetTitle){
		//生成一个Excel
		HSSFWorkbook book = new HSSFWorkbook();
		// 生成一个表格
		sheetTitle = getSheetTitle(sheetTitle); // 判断、设置sheetTitle
		HSSFSheet sheet = book.createSheet(sheetTitle);

		// 设置Excel里面数据
		setExcelContentData(book, sheet, header, properties ,excelList);
		return book;
	}
	
	/**
	 * 设置sheet的title，若为空则为yyyyMMddHH24mmss
	 * @author  
	 * @param sheetTitle 
	 * @return
	 * @version 1.0
	 */
	private static String getSheetTitle(String sheetTitle) {
		String title = null;
		if(sheetTitle != null && !"".equals(sheetTitle)){
			title = sheetTitle;
		}
		else{
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
			title = sdf.format(date);
		}
		return title;
	}
	
	

	/**
	 * 填充Excel内容
	 * @author  
	 * @param book
	 * @param sheet
	 * @param header
	 * @param properties
	 * @param excelList
	 * @version 1.0
	 */
	@SuppressWarnings("rawtypes")
	private static void setExcelContentData(HSSFWorkbook book, HSSFSheet sheet, String[] header, String[] properties,
			List<Object> excelList) {
		//设置列头样式(居中、变粗、蓝色)
		HSSFCellStyle headerStyle = book.createCellStyle();
		setHeaderStyle(headerStyle, book);

		// 设置单元格样式
		HSSFCellStyle cellStyle = book.createCellStyle();
		setCellStyle(cellStyle, book);

		// 创建头部
		HSSFRow row = createHeader(sheet, headerStyle, header);

		// 画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

		/* 为了避免迭代过程中产生过多的新对象，这里将循环内部变量全部移出来 */
		int index = 0;
		Object t = null;
		HSSFCell cell = null;
		Object o = null;
		Class clazz = null;
		PropertyDescriptor pd = null;
		Method getMethod = null;
		// 遍历集合数据，产生数据行
		Iterator<Object> it = excelList.iterator();
		int[] maxWidth = new int[header.length];   //初始化单元格宽度
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			// 设置数据列
			t = it.next();
			for(int i = 0 ; i < header.length ; i++){
				cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				o = null;    //每一个单元格都需要将O设置为null
				try {
					clazz = t.getClass();
					pd = new PropertyDescriptor(properties[i],clazz);
					getMethod = pd.getReadMethod();   // 获得get方法
					if (pd != null) {  
			           o  = getMethod.invoke(t);   //执行get方法返回一个Object  
			        }  
					setCellData(maxWidth,row, index, i, o, cell, sheet, patriarch, book);
				} catch (IntrospectionException e) {
					log.error("创建Excel数据列表时出错。method:setDataRow,message："+e.getMessage());
				} catch (IllegalAccessException e) {
					log.error("创建Excel数据列表时出错。method:setDataRow,message："+e.getMessage());
				} catch (IllegalArgumentException e) {
					log.error("创建Excel数据列表时出错。method:setDataRow,message："+e.getMessage());
				} catch (InvocationTargetException e) {
					log.error("创建Excel数据列表时出错。method:setDataRow,message："+e.getMessage());
				}
			}
		}
	}
	
	/**
	 * 设置Excel图片的格式：字体居中、变粗、蓝色、12号
	 * @author  
	 * @param headerStyle
	 * 				头部样式
	 * @param book
	 * 		  		生产的excel book 	 HSSFWorkbook对象	
	 * @version 1.0
	 */
	private static void setHeaderStyle(HSSFCellStyle headerStyle,HSSFWorkbook book) {
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //水平居中
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 
		//设置字体
		HSSFFont font = book.createFont();
		font.setFontHeightInPoints((short) 12);     //字号：12号
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);   //变粗
		font.setColor(HSSFColor.BLUE.index);   //蓝色
		
		headerStyle.setFont(font);
	}
	
	/**
	 * 设置单元格样式
	 * @author  
	 * @param cellStyle
	 * 			单元格样式
	 * @param book
	 * 			book HSSFWorkbook对象
	 * @version 1.0
	 */
	private static void setCellStyle(HSSFCellStyle cellStyle, HSSFWorkbook book) {
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);   //水平居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中 	
		HSSFFont font = book.createFont();
		font.setFontHeightInPoints((short)12);
		cellStyle.setFont(font);
	}
	
	/**
	 * 根据头部样式、头部数据创建Excel头部
	 * @author  
	 * @param sheet 
	 * 				sheet
	 * @param headerStyle 
	 * 				头部样式
	 * @param header 
	 * 				头部数据
	 * @return 设置完成的头部Row
	 * @version 1.0
	 */
	private static HSSFRow createHeader(HSSFSheet sheet,HSSFCellStyle headerStyle,
			String[] header) {
		HSSFRow headRow = sheet.createRow(0);
		headRow.setHeightInPoints((short)(20));   //设置头部高度
		//添加数据
		HSSFCell cell = null;
		for(int i = 0 ; i < header.length ; i++){
			cell = headRow.createCell(i);
			cell.setCellStyle(headerStyle);
			HSSFRichTextString text = new HSSFRichTextString(header[i]);
			cell.setCellValue(text);
		}
		
		return headRow;
	}
	
	/**
	 * 设置单元格数据
	 * @author  
	 * @param row  
	 * 				指定行
	 * @param index 
	 * @param i 
	 * 				行数
	 * @param value 
	 * 				单元格值 cellValue
	 * @param cell 
	 * 				单元格 HSSFCell对象
	 * @param sheet 
	 * 				sheet HSSFSheet对象
	 * @param patriarch  
	 * 				顶级画板 用于实现突破
	 * @param book 
	 * 			Excel HSSFWorkbook对象
	 * @version 1.0
	 */
	private static void setCellData(int[] maxWidth,HSSFRow row, int index ,int i ,Object value,HSSFCell cell,HSSFSheet sheet,HSSFPatriarch patriarch,HSSFWorkbook book) {
		String textValue = null; 
		if (value instanceof Date) {    //为日期设置时间格式
			Date date = (Date) value;
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
			textValue = sdf.format(date);  
		}
		else if(value instanceof byte[]){   //byte为图片
			//设置图片单元格宽度、高度
			row.setHeightInPoints((short)(IMAGE_HEIGHT * 10));
			sheet.setColumnWidth(i, IMAGE_WIDTH * 256);
		    HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255,(short) i, index, (short) i, index);   
	        anchor.setAnchorType(3);   
	        //插入图片  
	        byte[] bsValue = (byte[]) value;
	        patriarch.createPicture(anchor, book.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG)); 
		}
		else{   
			//其余全部当做字符处理
			if(value != null){
				textValue = String.valueOf(value);
			}
		}
		// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
		if (textValue != null) {
			Pattern p = Pattern.compile("^//d+(//.//d+)?$");
			Matcher matcher = p.matcher(textValue);
			
			//设置单元格宽度，是文字能够全部显示
			setCellMaxWidth(maxWidth,textValue,i);
			sheet.setColumnWidth(i, maxWidth[i]);    //设置单元格宽度
			row.setHeightInPoints((short)(20));   //设置单元格高度
			if (matcher.matches()) {
				// 是数字当作double处理
				cell.setCellValue(Double.parseDouble(textValue));
			} else {
				cell.setCellValue(textValue);
			}
		}
	}
	
	
	/**
	 * 根据字数来获取单元格大小,并更新当前列的最大宽度
	 * @author  
	 * @param textValue 
	 * @param 指定列
	 * @return
	 * @version 1.0
	 */
	private static void setCellMaxWidth(int[] maxWidth,String textValue,int i ) {
		int size = textValue.length();
		int width = (size + 6) * 256;
		if(maxWidth[i] <= width){
			maxWidth[i] = width;
		}
	}
	
	
	/**
	 * 
	 * 通用方法，使用 java 反射机制，根据提供表头 header ，数据列 excelList 生成 Excel,如有图片请转换为byte[]<br>
	 * header、properties需要一一对应：<Br>
	 * header = ["学号","年龄","性别","班级"]
	 * properties = ["id","age","sex","class"],其对应的excelList中javaBean的属性值
	 * javaBean 必须符合java规范
	 * 
	 * @author  
	 * 
	 * @param response
	 * 				HttpServletResponse
	 * 
	 * @param fileName
	 * 				导出文件名  
	 * 
	 * @param header  
	 * 				Excel表头
	 * 
	 * @param properties  
	 * 				表头对应javaBean中的属性
	 * 
	 * @param excelList  
	 * 				需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的 
	 * 				javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * 
	 * @param sheetTitle  
	 * 				表格标题名
	 * 
	 * @return 
	 * @version 1.0
	 */
	public static void exportExcel(HttpServletResponse response,String fileName,String[] header,String[] properties,List<Object> excelList,
			String sheetTitle){
		HSSFWorkbook workbook = ExcelExportHelper.exportExcel(header,properties,excelList,sheetTitle);
		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			OutputStream os = response.getOutputStream();
			workbook.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			log.error("导出Excel数据列表时出错。method:exportExcel,message："+e.getMessage());
		}
	}
}
