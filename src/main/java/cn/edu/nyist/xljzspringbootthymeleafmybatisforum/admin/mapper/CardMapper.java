package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
@Mapper
public interface CardMapper {

	@Select("select * from t_card where id=#{id}")
	Card findById(int id);
	//动态sql
    @SelectProvider(type=CardSqlProvider.class,method="createCardFindAll")
	List<Card> findAll(@Param(value="name") String name);
    //删除
    @Delete("delete from t_card where id=#{id}")
	int del(String id);
    @Update("update t_card set praise=#{i} where id=#{cid}")
	int updateCol(int i,int cid);
    @Update("update t_card set name=#{bt},content=#{content} where id=#{cid}")
	int updateById(int cid, String bt, String content);

}
