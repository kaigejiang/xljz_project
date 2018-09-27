package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Type;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.mapper.FrontCardMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontCardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.util.PageContant;
@Service(value="frontService")
public class FrontCardServiceImpl implements FrontCardService {
	//注入mapper 
	@Autowired

	private FrontCardMapper cardMapper;

	@Override
	public PageInfo<Card> findAll(int pageNum, String name) {
		//定义分页的标准
		PageHelper.offsetPage((pageNum-1)*PageContant.PAGE_CONTANT+1-1, PageContant.PAGE_CONTANT, true);
		List<Card> ls=cardMapper.find(name);//查询表单需要的数据
		//根据ID把对应的user信息放到list中
		for (Card card : ls) {
			User user=cardMapper.findById(card.getTid());
			card.setUser(user);
		}
		for (Card card : ls) {
			Type type=cardMapper.findTid(card.getTid());
			card.setType(type);
		}
		System.out.println("111111111111111111111111111"+ls);
		PageInfo<Card> pageInfo=new PageInfo<>(ls);	
		return pageInfo;
	}

	@Override
	public List<Card> findSecienceByTid(String name, int tid) {
		
		return cardMapper.findScience(name,tid);
	}

	@Override
	public User findById(int id) {
		
		return cardMapper.findById(id);
	}

	@Override
	public Type findByTid(int tid) {
		
		return cardMapper.findTid(tid);
	}


  

}
