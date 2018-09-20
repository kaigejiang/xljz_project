package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Collection;

public interface CollectionService {

	@Transactional(readOnly=true)
	Collection findBy(int uid, int cid);

	int insert(int uid, int cid);
	
	int delete(int uid, int cid);

}
