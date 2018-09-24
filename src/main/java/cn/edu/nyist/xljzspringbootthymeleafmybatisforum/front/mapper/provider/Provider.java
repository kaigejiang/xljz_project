package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

public class Provider {
	public String userEdit(@Param("book") final User user) {
		return new SQL() {
			{
				UPDATE("t_user");
				SET("name=#{name}");
				SET("descri=#{descri}");
				if (user.getPhoto()!=null) {
					SET("photo=#{photo}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
		
	}
}
