package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

public interface FrontUserCollectionService {
	@Transactional(readOnly=false)
	List<Card> findAllCollectionById(int id);
	@Transactional
	int deleteByCid(int id);

}
