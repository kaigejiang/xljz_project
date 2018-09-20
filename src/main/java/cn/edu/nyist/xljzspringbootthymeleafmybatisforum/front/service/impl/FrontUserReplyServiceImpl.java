package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontReplyMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserReplyService;

@Service
public class FrontUserReplyServiceImpl implements FrontUserReplyService{
	@Autowired
	private FrontReplyMapper replyMapper;
	@Override
	public int deleteByCid(int i) {
		return replyMapper.deleteByCid(i);
	}

}
