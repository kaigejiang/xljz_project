package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

public interface UserService {

	@Transactional(readOnly=true)
	User findById(int id);
}
