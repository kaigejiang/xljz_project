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
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.commen.PageCont;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCollectionService;

@Controller
@RequestMapping("/front")
public class FrontUserCollectionController {
	@Autowired
	private FrontUserCollectionService frontUsercollectionService;
	@Autowired
	private FrontUserCardService frontUserCardService;
	@RequestMapping("/toUserCollection")
	public String toUserCollection() {
		return "front/usercollection";
	}

	@RequestMapping("/userCollection")
	@ResponseBody
	public Map<String, Object> userCollection(HttpSession session,
			@RequestParam(defaultValue = "1", required = false) int pageNo) {
		// 获取user
		User user = (User) session.getAttribute("user");
		// 分页
		PageHelper.startPage(pageNo, PageCont.PAGE_SIZE);
		// 取得用户帖子
		List<Card> cards= frontUsercollectionService.findAllCollectionById(user.getId());
		PageInfo<Card> pageInfo = new PageInfo<Card>(cards);
		Map<String, Object> result = new HashMap<>();
		result.put("cards", cards);
		result.put("pageInfo", pageInfo);
		return result;
	}
	
	@RequestMapping("/collectionDelete")
	@ResponseBody
	private Map<String, Object> deleteCard(@RequestParam Integer collectionId) {
		Card card = frontUserCardService.findCardById(collectionId);
		try {
			frontUsercollectionService.deleteByCid(card.getId());
		} catch (Exception e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}
		return null;
	}
}
