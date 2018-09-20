package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.util;

public class SplitTest {
public static void main(String[] args) {
	String fullname="poi.....doc";
	String name=fullname.substring(0, fullname.lastIndexOf("."));
	System.out.println(name);
}
}
