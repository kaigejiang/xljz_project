package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.CardMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardMapper cardMapper;
	@Override
	public Card findById(int id) {
		return cardMapper.findById(id);
	}

}
