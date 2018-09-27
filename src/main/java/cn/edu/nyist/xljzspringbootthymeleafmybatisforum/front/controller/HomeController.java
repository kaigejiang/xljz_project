package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontCardService;

@Controller
@RequestMapping("/front")
public class HomeController {
	
	//注入service
	@Autowired
	private FrontCardService cardService;
    //转发到主页面 得到模板
	@RequestMapping("/toHome")
	public String toHome() {
		
		return "/front/main";
	}
	//ajax请求得到数据去填充
		@RequestMapping("/home")
		@ResponseBody
		public Map<String, Object> home(@RequestParam(defaultValue="",required=false)String name,
			   @RequestParam(defaultValue="1",required=false) int pageNum
			   
			  
			   ){//pageNum默认值是1
			System.out.println("nnnnnnnnnnnnnnnnnnn"+pageNum);
			
			  PageInfo<Card> pageInfo=cardService.findAll(pageNum,name);
			  System.out.println(pageInfo);
			  Map<String, Object> map=new HashMap<>();
			  map.put("pageInfo", pageInfo);
			  map.put("name", name);
			 
			  return map;//返回json的数据
			
			
		
	}
}
