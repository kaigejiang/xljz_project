package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;

@Mapper
public interface FrontCommentMapper {
	@Select("select * from t_comment where uid=#{id}")
	List<Comment> findCommentById(int id);

	@Delete("delete from t_comment where cid=#{i}")
	int deleteByCid(int i);

	@Select("select * from t_comment where cid=#{id}")
	List<Comment> findAllByCid(int id);

	@Select("select * from t_comment where content=#{commentName}")
	Comment findByName(String commentName);

	@Delete("delete from t_comment where id=#{id}")
	int deleteById(int id);
	@Select("select * from t_comment where id=#{commentId}")
	Comment findById(int commentId);

}
