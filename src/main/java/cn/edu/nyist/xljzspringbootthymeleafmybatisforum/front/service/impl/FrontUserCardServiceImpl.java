package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontCardMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCardService;
@Service
public class FrontUserCardServiceImpl implements FrontUserCardService {
	@Autowired
	private FrontCardMapper cardMapper;
	@Override
	public List<Card> findAllCardById(int id) {
		return cardMapper.findCard(id);
	}
	@Override
	public int save(Card card) {
		return cardMapper.save(card);
	}
	@Override
	public Card findCardById(Integer cardId) {
		return cardMapper.findCardById(cardId);
	}
	@Override
	public void deleteById(Integer cardId) {
		cardMapper.deleteById(cardId);
		
	}

}
