package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import org.springframework.transaction.annotation.Transactional;

public interface FrontUserReplyService {
	@Transactional
	int deleteByCid(int i);

}
