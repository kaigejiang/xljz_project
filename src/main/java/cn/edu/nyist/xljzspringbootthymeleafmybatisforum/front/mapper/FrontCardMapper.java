package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Type;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider.FrontCardSqlProvider;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider.FrontCardSqlTypeProvider;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.provider.Provider;

@Mapper
public interface FrontCardMapper {
	@Select("select * from t_card where uid=#{id}")
	List<Card> findCard(int id);

	@SelectProvider(method = "findAllPageInfo", type = FrontCardSqlProvider.class)
	List<Card> find(String name);

	@InsertProvider(type = Provider.class, method = "saveCard")
	int save(Card card);

	@Select("select * from t_card where id=#{cardId}")
	Card findCardById(Integer cardId);
	@Delete("delete from t_card where id=#{cardId}")
	void deleteById(Integer cardId);
	@Select("select * from t_user where id=#{id}")
	User findById(int id);
	//找到science
	@SelectProvider(method = "findAllTypePageInfo", type = FrontCardSqlTypeProvider.class)
	List<Card> findScience(String name, int tid);
	@Select("select * from t_type where id=#{id}")
	Type findTid(int tid);	

}
