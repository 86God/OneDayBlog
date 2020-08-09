package com.example.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 字符串常用操作工具类
 * @author Administrator
 *
 */
public class StringUtil {

	/**
	 * 截取文件后缀名
	 * @param fileName 文件名
	 * @return 返回文件后缀
	 */
	public static  String subFileType(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}

	/**
	 * 使用当前时间作为文件名
	 * @return
	 */
	public static String createNewNameByDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * 使用UUId生成文件名
	 * @return
	 */
	public static String createNewNameByUUID(){
		UUID uid = UUID.randomUUID();
		return uid.toString().replace("-", "");
	}



}
