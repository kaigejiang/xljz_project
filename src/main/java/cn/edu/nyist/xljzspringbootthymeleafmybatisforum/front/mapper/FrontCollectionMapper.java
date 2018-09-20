package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

@Mapper
public interface FrontCollectionMapper {
	@Select("select * from t_card,t_collection where t_card.Id=t_collection.cid and t_collection.uid=#{id}")
	List<Card> getMyCollection(int id);
	@Delete("delete from t_collection where cid=#{id}")
	int deleteByCid(int id);

}
