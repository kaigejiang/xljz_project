package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

public interface FrontUserCardService {
	@Transactional(readOnly=true)
	List<Card> findAllCardById(int id);
	@Transactional
	void deleteByName(String cardName);
	@Transactional(readOnly=true)
	Card findCardByName(String cardName);

}
