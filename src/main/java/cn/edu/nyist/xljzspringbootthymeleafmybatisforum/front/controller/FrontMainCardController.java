package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.proxy.jdbc.JdbcParameter.TYPE;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.util.PageConstant;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Type;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontCardService;

@Controller
@RequestMapping("/front")
public class FrontMainCardController {
	@Autowired
	private FrontCardService cardService;
	
	//到主页面  science
	@RequestMapping("/toCardScience")
	public String toCardScience(@RequestParam(defaultValue="1",required=false) int tid,Model model) {
		model.addAttribute("tid",tid);
		return "/front/cardScience";
		
	}
	 
	@RequestMapping("/cardScience")
	@ResponseBody
	public Map<String, Object> home(@RequestParam(defaultValue="",required=false)String name,
		   @RequestParam(defaultValue="1",required=false) int pageNum,
		   @RequestParam(defaultValue="1",required=false) int tid){//pageNum默认值是1
		  //分页
	       //int tid=1;//暂时写个确定值
		System.out.println("ttttttttttttttttttttttttt"+tid);
		   PageHelper.startPage(pageNum, PageConstant.PAGE_SIZE);
		   List<Card> ls=cardService.findSecienceByTid(name,tid);
		    //动态不好配置关联  用card的Id来放置
		   for (Card card : ls) {
			    User user=cardService.findById(card.getUid());
			    card.setUser(user);
		}
		   //关联书籍类型
		   for (Card card : ls) {
			Type type=cardService.findByTid(card.getTid());
			card.setType(type);
		}
		   //把得到的cards放在pageinfo里面返回json
		   PageInfo<Card> pageInfo=new PageInfo<>(ls);
		   System.out.println(pageInfo);
		   Map<String, Object> map=new HashMap<>();
		   map.put("pageInfo", pageInfo);
		   map.put("name", name);
		 
		   return map;//返回json的数据
		
		
	
}

	

}
