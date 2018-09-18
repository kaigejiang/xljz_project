package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper.CommentMapper;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CommentService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.ReplyService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.UserService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Reply;
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
	
	@RequestMapping("/toCardContent")
	//参数要通过主页面传参过来一个ID
	public String toCard(Model model) {
		//获得该帖子的全部
		Card card=cardService.findById(1);
		User user=useService.findById(card.getUid());
		List<Comment> comments=commentService.findAllByCid(card.getId());
		/*for (Comment comment : comments) {
			User user1=useService.findById(comment.getUid());
			comment.setUser(user1);
			List<Reply> replys=replyService.findAllByComid(comment.getId());
			
			model.addAttribute("replys", replys);
		}*/
		
		model.addAttribute("card", card);
		model.addAttribute("user", user);
		model.addAttribute("comments", comments);
		return "cardContent";
	}
	@RequestMapping("/commentAdd")
	public String commentAdd(@RequestParam("cuid") int uid,@RequestParam("ccontent") String content,@RequestParam("ccid") int cid) {
		int ret=commentService.insert(uid,content,cid);
		System.out.println(ret+"---------------------------------------");
		return "redirect:/toCardContent";
	}
	
	@RequestMapping("/replyAdd")
	public String replyAdd(@RequestParam("ruid") int uid,@RequestParam("rcontent") String content,@RequestParam("rcomid") int comid) {
		int ret=replyService.insert(uid,content,comid);
		System.out.println(ret+"---------------------------------------");
		
		return "redirect:/toCardContent";
	}
}
