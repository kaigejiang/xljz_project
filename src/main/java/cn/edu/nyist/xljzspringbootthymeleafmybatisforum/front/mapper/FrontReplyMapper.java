package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Reply;
@Mapper
public interface FrontReplyMapper {
	@Select("select * from t_reply where uid=#{id}")
	List<Reply> findByUid(int id);
	@Delete("delete from t_reply where comid=#{i}")
	int deleteByCid(int i);
}
