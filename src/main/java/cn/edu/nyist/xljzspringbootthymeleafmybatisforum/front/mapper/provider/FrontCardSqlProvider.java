package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;


public class FrontCardSqlProvider {
  public String findAllPageInfo(@Param(value="name") String name) {
	  return new SQL() {
		  
		  {
			  
			  SELECT("*");
			  FROM("t_card");
			  if (name!=null&&!name.equals("")) {
				WHERE("name like concat('%',#{name},'%')");
			}			  
		  }
		  
		  
		  
	  }.toString(); 
	  
	  
  }
}
