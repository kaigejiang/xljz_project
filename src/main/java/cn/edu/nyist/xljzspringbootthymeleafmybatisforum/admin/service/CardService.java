package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

public interface CardService {
	@Transactional(readOnly = true)
	public Card findById(int id);
}