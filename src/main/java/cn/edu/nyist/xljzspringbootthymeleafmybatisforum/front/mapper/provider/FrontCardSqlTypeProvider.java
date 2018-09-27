package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;


public class FrontCardSqlTypeProvider {
  public String findAllTypePageInfo(@Param(value="name") String name,@Param(value="tid")int tid ) {
	  return new SQL() {
		  
		  {
			  
			  SELECT("*");
			  FROM("t_card");
			  if (name!=null&&!name.equals("")) {
				WHERE("name like concat('%',#{name},'%')");
			}
			  if(tid!=-1) {
				  WHERE("tid=#{tid}");
				  
				  
			  }
		  }
		  
		  
		  
	  }.toString(); 
	  
	  
  }
}
