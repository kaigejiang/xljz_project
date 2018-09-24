package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

public interface FrontUserEditService {
	@Transactional(readOnly=false)
	int editUserInfo(User user);

}
