package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.commen.PageCont;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCollectionService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCommentService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserReplyService;

@Controller
@RequestMapping("/front")
public class FrontUserCardController {
	@Autowired
	private FrontUserCardService frontUserCardService;
	@Autowired
	private FrontUserCollectionService frontUserCollectionService;
	@Autowired
	private FrontUserReplyService frontUserReplyService;
	@Autowired
	private FrontUserCommentService frontUserCommentService;

	@RequestMapping("/toUserCard")
	public String toUserCard() {
		return "front/usercard";
	}

	@RequestMapping("/userCard")
	@ResponseBody
	public Map<String, Object> userCard(HttpSession session,
			@RequestParam(defaultValue = "1", required = false) int pageNo) {
		// 给session添加user，后面要替换
		User user1 = new User();
		user1.setId(1);
		session.setAttribute("user", user1);

		// 获取user
		User user = (User) session.getAttribute("user");
		// 分页
		PageHelper.startPage(pageNo, PageCont.PAGE_SIZE);
		// 取得用户帖子
		List<Card> cards = frontUserCardService.findAllCardById(user.getId());
		PageInfo<Card> pageInfo = new PageInfo<Card>(cards);
		Map<String, Object> result = new HashMap<>();
		// 把用户的cards放到model
		result.put("cards", cards);
		result.put("pageInfo", pageInfo);
		return result;
	}
	@RequestMapping("/carddelete")
	@ResponseBody
	private Map<String, Object> deleteCard(@RequestParam Integer cardId) {
		Card card = frontUserCardService.findCardById(cardId);
		List<Comment> comments = frontUserCommentService.findAllCommentByCId(card.getId());
		try {
			frontUserCollectionService.deleteByCid(card.getId());
			for (Comment comment : comments) {
				frontUserReplyService.deleteByCid(comment.getId());
			}
			frontUserCommentService.deleteByCid(card.getId());
			frontUserCardService.deleteById(cardId);
		} catch (Exception e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}
		return null;
	}
}
