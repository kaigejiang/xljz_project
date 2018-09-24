package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider.Provider;

@Mapper
public interface FrontUserMapper {
	@Select("select * from t_user where id = #{id}")
	User findById(int id);
	@UpdateProvider(type=Provider.class,method="userEdit")
	int update(User user);
}
