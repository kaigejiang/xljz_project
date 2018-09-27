package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.service.CardService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.util.Html2StringUtil;

//修改帖子
@Controller
@RequestMapping("/front")
public class UpdateCardController {
	@Autowired
	private CardService cardService;

	@RequestMapping("/updateCard")
	@ResponseBody
	public Map<String, Object> updateCard(HttpSession session, @RequestParam int cid) {
		User user = (User) session.getAttribute("user");
		Card card = cardService.findById(cid);
		Map<String, Object> map = new HashMap<>();
		if (user.getId() != card.getUid()) {
			map.put("url", "/front/userCard");
			return map;
		}
		map.put("url", "/front/updatepost?cid=" + cid);
		return map;
	}

	@RequestMapping("/updatepost")
	public String updatepost(Model model, HttpSession session, @RequestParam int cid) {
		User user = (User) session.getAttribute("user");
		Card card = cardService.findById(cid);

		if (user.getId() != card.getUid()) {
			return "/front/userCard";

		}
		String content = card.getContent();
		String realContent = Html2StringUtil.H2S(content);

		model.addAttribute("card", card);
		model.addAttribute("content", realContent);

		return "/front/updatepost";
	}

	@RequestMapping("/editCard")
	public String editCard(HttpServletRequest request,@RequestParam int cid,@RequestParam String bt,@RequestParam(required = false) String content) {
		content = "<!DOCTYPE html>\r\n" + "<html xmlns:th=\"http://www.thymeleaf.org\">\r\n" + "<head>\r\n"
				+ "<meta charset=\"UTF-8\"/>\r\n" + "<title>页面</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "<div th:fragment=\"commen\">" + content + "</div>\r\n" + "</body>\r\n" + "</html>";
		String newFileName = UUID.randomUUID().toString() + ".html";
		System.out.println(newFileName);
		String realPath = request.getServletContext().getRealPath("WEB-INF/upload/word/word/" + newFileName);
		File file = new File(realPath);
		
			try {
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		int ret= cardService.updateById(cid,bt,newFileName);
		System.out.println(ret+"更新--------------------");
		
		return "redirect:/front/toUserCard";
	}

}
