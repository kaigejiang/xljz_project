package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CollectionService;

@Controller
public class CollectionController {
	@Autowired
	private CollectionService collectionService;
	@RequestMapping("/collectionAdd")
	public String collectAdd(@RequestParam int cid,@RequestParam int uid) {
		int ret= collectionService.insert(uid, cid);
		if(ret>0)
		{return "redirect:/toCardContent?uid="+uid+"&cid="+cid;}
		else
			return "err";
	}
	
	@RequestMapping("/collectionDel")
	public String collectDel(@RequestParam int cid,@RequestParam int uid) {
		int ret= collectionService.delete(uid, cid);
		if(ret>0)
		{return "redirect:/toCardContent?uid="+uid+"&cid="+cid;}
		else
			return "err";
	}
}
