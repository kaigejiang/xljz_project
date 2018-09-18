package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;



@Mapper
public interface UserMapper {
	
	@Select("select * from t_user where name=#{name} and pwd=#{pwd}")
	User findByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
	
	
	@Select("select * from t_user where name=#{name}")
	User findByName(String name);
	
	//增加用户
	@Insert("insert into t_user values(default,#{name},#{pwd},#{descri},#{photo})")
	int add(User user); 
	

}
