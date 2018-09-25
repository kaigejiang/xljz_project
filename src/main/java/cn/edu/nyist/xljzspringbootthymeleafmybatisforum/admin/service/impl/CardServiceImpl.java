package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.CardMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.util.PageConstant;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
@Service
public class CardServiceImpl implements CardService {
	@Autowired
	private CardMapper cardMapper;
	@Override
	public Card findById(int id) {
		return cardMapper.findById(id);
	}@Override
	public PageInfo<Card> findAll(String name,int pageNum) {
		//按照praisepai
		
		//规定分页  传入当前页的第一页数据和大小
		PageHelper.offsetPage((pageNum-1)*PageConstant.PAGE_SIZE+1-1,PageConstant.PAGE_SIZE, true);	
		//查询帖子 name是动态变化的
		List<Card> ls=cardMapper.findAll(name);
		//System.out.println("1111111111"+ls);
		for (Card card : ls) {
			System.out.println("不是pagel----------"+card);
		}
		PageInfo<Card> pageInfo=new PageInfo<>(ls);
		System.out.println(pageInfo);
		return pageInfo;
		
	}
   //删除帖子
	@Override
	public int delCardById(String id) {
		
		return cardMapper.del(id);
	}
	@Override
	public int updateCol(int i) {
		
		return cardMapper.updateCol(i);
	}
	

}
