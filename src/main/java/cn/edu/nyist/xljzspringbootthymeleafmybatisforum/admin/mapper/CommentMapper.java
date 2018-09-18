package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
@Mapper
public interface CommentMapper {

	
	@Select("select * from t_comment where cid=#{id}")
	@Results({
		//关联回复信息
		@Result(column="id",property="id"),
		@Result(many=@Many(select="cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.ReplyMapper.findAllByComid"),property="replys",column="id"),
	
		//关联作者信息
		@Result(column="uid",property="uid"),
		@Result(one=@One(select="cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.UserMapper.findById"),
		column="uid",property="user",javaType=User.class
				)
	})
	List<Comment> findAllByCid(int id);

	@Insert("insert into t_comment(uid,content,cid) values(#{uid},#{content},#{cid})")
	int insert(int uid, String content, int cid);
}
