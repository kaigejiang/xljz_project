package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Html2StringUtil {
public static String H2S(String fileName) {
	String filePath = System.getProperty("user.dir")
			+ "\\src\\main\\webapp\\WEB-INF\\upload\\word\\word\\"+fileName;
	File file = new File(filePath);
	InputStream input = null;
	try {
		input = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	StringBuffer buffer = new StringBuffer();
	byte[] bytes = new byte[256];
	try {
		for (int n; (n = input.read(bytes)) != -1;) {
			buffer.append(new String(bytes, 0, n, "utf-8"));
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	String val = buffer.toString();
	String start = "<p>";
	String end = "</p>";
	int startIndex=val.indexOf(start)+ start.length();
	int endIndex=val.indexOf(end);
	String body="";
	
	while(startIndex!=2&&endIndex!=-1) {
		body=body+val.substring(startIndex,endIndex);
		val=val.substring(endIndex+4);
		startIndex=val.indexOf(start)+ start.length();
		endIndex=val.indexOf(end);
	}
	return body;
}

}
