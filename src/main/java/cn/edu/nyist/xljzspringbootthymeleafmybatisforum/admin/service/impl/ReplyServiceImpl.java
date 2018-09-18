package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.ReplyMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.ReplyService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<Reply> findAllByComid(int id) {
		
		return replyMapper.findAllByComid(id);
	}

	@Override
	public int insert(int uid, String content, int comid) {
		
		return replyMapper.insert(uid,content,comid);
	}

}
