package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CollectionService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CommentService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.ReplyService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.UserService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Collection;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

@Controller
public class CardContentController {
	@Autowired
	private  CardService cardService;
	@Autowired
	private  UserService useService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CollectionService collectionService;
	@RequestMapping("/toCardContent")
	//参数要通过主页面传参过来一个ID
	public String toCard(Model model, @RequestParam(defaultValue="0") int uid,@RequestParam(defaultValue="1") int cid) {
		//获得该帖子的全部
		Card card=cardService.findById(cid);
		User user=useService.findById(card.getUid());
		List<Comment> comments=commentService.findAllByCid(card.getId());
		//收藏
		Collection collection= collectionService.findBy(uid,cid);
		System.out.println(collection+"22222222222222");
		//解析帖子内容
		//String docName=card.getContent();
		String docName="poi.docx";
		String outPutName=docName.substring(0, docName.lastIndexOf("."))+".html";
		
	
		model.addAttribute("outPut", outPutName);
		model.addAttribute("collection", collection);
		model.addAttribute("card", card);
		model.addAttribute("user", user);
		model.addAttribute("comments", comments);
		return "cardContent";
	}
	@RequestMapping("/commentAdd")
	@ResponseBody
	public Map<String, Object> commentAdd(@RequestParam("cuid") int uid,@RequestParam("ccontent") String content,@RequestParam("ccid") int cid) {
		Date date=new Date();
		int ret=commentService.insert(uid,content,cid,date);
		System.out.println(ret+"---------------------------------------");
		Map<String, Object> map=new HashMap<>();
		if(ret>0) {
			map.put("url", "/toCardContent?uid="+uid+"&cid="+cid);
		}else {
			map.put("url", "/err");
		}
		return map;
	}
	
	@RequestMapping("/replyAdd")
	public String replyAdd(@RequestParam("ruid") int uid,@RequestParam("rcontent") String content,@RequestParam("rcomid") int comid, @RequestParam("rcid") int cid) {
		Date date=new Date();
		int ret=replyService.insert(uid,content,comid,date);
		System.out.println(ret+"---------------------------------------");
		
		if(ret>0) {
			return "redirect:/toCardContent?uid="+uid+"&cid="+cid;
		}else {
		return "err";
		}
		
	}
	
	@RequestMapping("commentDel")
	public String commentDel(@RequestParam() int comid) {
		Comment comment=commentService.findAllByComid(comid);
		replyService.delByComid(comid);
		int ret=commentService.delById(comid);
		int cid=comment.getCid();
		return "redirect:/toCardContent?"+"cid="+cid;
		
	}
	
}

