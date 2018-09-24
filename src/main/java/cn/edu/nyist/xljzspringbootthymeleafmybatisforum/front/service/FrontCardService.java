package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

public interface FrontCardService {
     @Transactional(readOnly=true)
	PageInfo<Card> findAll(int pageNum, String name);

}
