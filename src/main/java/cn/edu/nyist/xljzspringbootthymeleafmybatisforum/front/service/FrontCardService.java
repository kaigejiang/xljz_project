package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Type;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

public interface FrontCardService {
     @Transactional(readOnly=true)
	PageInfo<Card> findAll(int pageNum, String name);
    @Transactional(readOnly=true)//之后需要优化
	List<Card> findSecienceByTid(String name, int tid);
    @Transactional(readOnly=true)//之后需要优化  作者关联
	User findById(int id);
    @Transactional(readOnly=true)//之后需要优化   书籍类型关联
	Type findByTid(int tid);
	
   	

}
