package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.util;

import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
 

public class Word2HtmlUtil {
 
	public static void docx2html(String sourceName,String outPutName) {
		String path=System.getProperty("user.dir")+"\\src\\main\\webapp\\WEB-INF\\upload\\word\\";
		
		String file = path+sourceName;
		
		  String file2 =path+outPutName;
		 File f = new File(file);  
		  if (!f.exists()) {  
	            System.out.println("Sorry File does not Exists!");  
	        } else {  
	            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {  
	                try {
						//读取文档内容  
						InputStream in = new FileInputStream(f);  
						XWPFDocument document = new XWPFDocument(in);  
						
						File imageFolderFile = new File(path);  
						//加载html页面时图片路径
						XHTMLOptions options = XHTMLOptions.create().URIResolver( new BasicURIResolver("")); 
						//图片保存文件夹路径
						options.setExtractor(new FileImageExtractor(imageFolderFile));  
						OutputStream out = new FileOutputStream(new File(file2));  
						XHTMLConverter.getInstance().convert(document, out, options);  
						out.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (XWPFConverterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	            } else {  
	                System.out.println("Enter only MS Office 2007+ files");  
	            }  
	        }   
	}
	
}
