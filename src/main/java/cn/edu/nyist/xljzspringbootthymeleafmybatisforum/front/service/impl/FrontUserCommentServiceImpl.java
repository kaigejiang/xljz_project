package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontCommentMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCommentService;
@Service
public class FrontUserCommentServiceImpl implements FrontUserCommentService{
	@Autowired
	private FrontCommentMapper commentMapper;
	@Override
	public List<Comment> findAllCommentById(int id) {
		return commentMapper.findCommentById(id);
	}
	@Override
	public int deleteByCid(int i) {
		return commentMapper.deleteByCid(i);
	}
	@Override
	public List<Comment> findAllCommentByCId(int id) {
		return commentMapper.findAllByCid(id);
	}
	@Override
	public Comment findCommentByName(String commentName) {
		return commentMapper.findByName(commentName);
	}
	@Override
	public int deleteById(int id) {
		return commentMapper.deleteById(id);
	}

}
