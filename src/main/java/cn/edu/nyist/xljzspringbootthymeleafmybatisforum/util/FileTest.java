package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.util;

import java.io.File;

public class FileTest {
	
	    public static void main(String[] args) throws Exception {      

	  System.out.println(Thread.currentThread().getContextClassLoader().getResource("")+"111");     

	  System.out.println(FileTest.class.getClassLoader().getResource("")+"2222");        

	  System.out.println(ClassLoader.getSystemResource(""));        
	  System.out.println(FileTest.class.getResource(""));        
	  System.out.println(FileTest.class.getResource("/")); //Class文件所在路径  
	  System.out.println(new File("/").getAbsolutePath());        
	  System.out.println(System.getProperty("user.dir"));    
	 }
	
}
