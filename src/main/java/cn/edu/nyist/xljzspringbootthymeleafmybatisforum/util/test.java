package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class test {
	public static void main(String[] args) {
		try {
			Doc2HtmlUtil.convert2Html("poi.doc", "poi.html");
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
