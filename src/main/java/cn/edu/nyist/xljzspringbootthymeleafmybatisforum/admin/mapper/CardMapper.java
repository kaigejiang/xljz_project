package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
@Mapper
public interface CardMapper {

	@Select("select * from t_card where id=#{id}")
	Card findById(int id);

}
