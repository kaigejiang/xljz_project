package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;

@Controller
@RequestMapping("/admin")
public class CardMainController {
	@Autowired
	private CardService cardService;
	//转发到主页面 模板前移
	@RequestMapping("/toHome")
	public String toHome() {
		return "/admin/main";
		
	} 
	
	//后端拿数据
	@RequestMapping("/home")
	@ResponseBody
	public Map<String, Object> getCard(Model model,@RequestParam(defaultValue="",required=false) String name,
			@RequestParam(defaultValue="1",required=false)int pageNum
			) {
	PageInfo<Card> pageInfo=cardService.findAll(name,pageNum);//获取所有的帖子 使用分页插件
	System.out.println("222222"+pageInfo);
	Map<String, Object> map=new HashMap<>();
	map.put("pageInfo", pageInfo);
	map.put("name", name);
	model.addAttribute("pageInfo", pageInfo);
	return map;//json格式数据 内容协商视图解析器
		
		
	}
	//删除帖子
	@RequestMapping("/delCard")
	public  String delCard(String id) {
		
		int ret=cardService.delCardById(id);
		return "redirect:/admin/toHome";
		
	}

}
