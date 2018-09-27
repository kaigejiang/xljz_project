package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

public interface CardService {
	@Transactional(readOnly = true)
	public Card findById(int id);
	@Transactional(readOnly=true)
	PageInfo<Card> findAll(String name, int pageNum);
    @Transactional
	int delCardById(String id);
    @Transactional
	int  updateCol(int i, int cid);
    @Transactional
	public int updateById(int cid, String bt, String content);
}