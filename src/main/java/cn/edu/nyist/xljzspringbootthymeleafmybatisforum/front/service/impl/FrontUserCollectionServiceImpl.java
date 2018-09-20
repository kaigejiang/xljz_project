package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontCollectionMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCollectionService;
@Service
public class FrontUserCollectionServiceImpl implements FrontUserCollectionService {
	@Autowired
	private FrontCollectionMapper collectionMapper;
	@Override
	public List<Card> findAllCollectionById(int id) {
		return collectionMapper.getMyCollection(id);
	}
	@Override
	public int deleteByCid(int id) {
		return collectionMapper.deleteByCid(id);
	}
}
