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

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Comment;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.commen.PageCont;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCommentService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserReplyService;

@Controller
@RequestMapping("/front")
public class FrontUserCommentController {
	@Autowired
	private FrontUserCommentService frontUserCommentService;
	@Autowired
	private FrontUserReplyService frontUserReplyService;
	@RequestMapping("/toUserComment")
	public String toUserComment() {
		return "front/usercomment";
	}

	@RequestMapping("/userComment")
	@ResponseBody
	public Map<String, Object> userComment(HttpSession session,
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
		List<Comment> comments = frontUserCommentService.findAllCommentById(user.getId());
		PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);
		Map<String, Object> result = new HashMap<>();
		// 把用户的cards放到model
		result.put("comments", comments);
		result.put("pageInfo", pageInfo);
		return result;
	}
	
	@RequestMapping("/commentDelete")
	@ResponseBody
	private Map<String, Object> deleteCard(@RequestParam String commentName) {
		Comment comment = frontUserCommentService.findCommentByName(commentName);
		try {
			frontUserReplyService.deleteByCid(comment.getId());
			frontUserCommentService.deleteById(comment.getId());
		} catch (Exception e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}
		return null;
	}
}
