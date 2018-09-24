package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
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
		System.out.println("111111111111111111111111111"+ls);
		PageInfo<Card> pageInfo=new PageInfo<>(ls);	
		return pageInfo;
	}

}
