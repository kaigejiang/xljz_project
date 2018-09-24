package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.util;

import java.io.File;

public class PhotoUtil {
	/**
	 * 删除文件
	 * */
	public static void delFile (String path) {
		  File file=new File(path);
		  if(file.exists() && file.isFile())
		    file.delete();
		}
}
