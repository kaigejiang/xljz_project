package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.CollectionMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CollectionService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Collection;

@Service
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	private CollectionMapper collectionMapper;

	@Override
	public Collection findBy(int uid, int cid) {
		
		return collectionMapper.find(uid,cid);
	}

	@Override
	public int insert(int uid, int cid) {
		
		return collectionMapper.insert(uid,cid);
	}

	@Override
	public int delete(int uid, int cid) {
		
		return collectionMapper.delete(uid,cid);
	}

}
