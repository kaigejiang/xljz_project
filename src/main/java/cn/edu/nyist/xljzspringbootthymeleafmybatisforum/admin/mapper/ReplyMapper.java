package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Reply;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

@Mapper
public interface ReplyMapper {

	@Results(value={

			@Result(column="uid",property="uid"),
			@Result(one=@One(select="cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.UserMapper.findById"),
			column="uid",property="user",javaType=User.class
					)
	})
	@Select("select * from t_reply where comid=#{id}")
	List<Reply> findAllByComid(int id);

	@Insert("insert into t_reply(uid,content,comid,rdate) values(#{uid},#{content},#{comid},#{date})")
	int insert(int uid, String content, int comid, Date date);
}
