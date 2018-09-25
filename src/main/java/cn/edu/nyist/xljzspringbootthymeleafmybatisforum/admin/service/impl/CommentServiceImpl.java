package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.CommentMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CommentService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	@Override
	public List<Comment> findAllByCid(int id) {
		
		return commentMapper.findAllByCid(id);
	}
	@Override
	public int insert(int uid, String content, int cid,Date date) {
		
		return commentMapper.insert(uid,content,cid,date);
	}
	
	@Override
	public int delById(int comid) {
		
		return commentMapper.deleteById(comid);
	}
	
	@Override
	public Comment findAllByComid(int comid) {
		return commentMapper.findByComid(comid);
	}

	
}
