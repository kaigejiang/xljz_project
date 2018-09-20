package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Collection;

@Mapper
public interface CollectionMapper {

	@Select("select * from t_collection where uid=#{uid} and cid=#{cid}")
	Collection find(int uid, int cid);

	@Insert("insert into t_collection values(#{uid},#{cid})")
	int insert(int uid, int cid);

	@Delete("delete from t_collection where uid=#{uid} and cid=#{cid}")
	int delete(int uid, int cid);

}
