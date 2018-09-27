package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;

public interface FrontUserCommentService {
	@Transactional(readOnly = true)
	List<Comment> findAllCommentById(int id);

	@Transactional
	int deleteByCid(int i);

	@Transactional(readOnly = true)
	List<Comment> findAllCommentByCId(int id);

	@Transactional(readOnly = true)
	Comment findCommentByName(String commentName);
	@Transactional
	int deleteById(int id);
	@Transactional(readOnly = true)
	Comment findCommentById(int commentId);

}
