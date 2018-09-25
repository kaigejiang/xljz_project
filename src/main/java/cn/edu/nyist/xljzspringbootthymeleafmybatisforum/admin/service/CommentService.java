package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;

public interface CommentService {
	@Transactional(readOnly=true)
	List<Comment> findAllByCid(int id);

	int insert(int uid, String content, int cid, Date date);

	Comment findAllByComid(int comid);

	int delById(int comid);

}
