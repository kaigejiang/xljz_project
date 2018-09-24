package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
@Mapper
public interface FrontCardMapper {
	@Select("select * from t_card where uid=#{id}")
	List<Card> findCard(int id);
	@Delete("delete from t_card where name=#{cardName}")
	void deleteByName(String cardName);
	@Select("select * from t_card where name=#{cardName}")
	Card findCardByName(String cardName);

}
