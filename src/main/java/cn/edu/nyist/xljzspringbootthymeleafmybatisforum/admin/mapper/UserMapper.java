package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

@Mapper
public interface UserMapper {

	@Select("select * from t_user where id=#{id}")
	User findById(int id);
}
