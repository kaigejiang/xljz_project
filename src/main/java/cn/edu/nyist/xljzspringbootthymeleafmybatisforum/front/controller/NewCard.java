package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.Card;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserCardService;
//发帖
@Controller
@RequestMapping("/front")
public class NewCard {
	@Autowired
	private FrontUserCardService frontUserCardService;
	
	@RequestMapping("/toNewCard")
	public String toNewCard() {
		return "/front/newpost";
	}

	@RequestMapping("/newCard")
	public String newCard(@RequestParam(required = false) String content, @RequestParam String bt,
			HttpServletRequest request, Model model, HttpSession session,@RequestParam String type) {
		User user = (User) session.getAttribute("user");
		System.out.println(content);
		System.out.println(bt);
		System.out.println(user.getId());
		if (content == null||user == null) {
			return "/front/userCard";
		}
		content = "<!DOCTYPE html>\r\n" + "<html xmlns:th=\"http://www.thymeleaf.org\">\r\n" + "<head>\r\n"
				+ "<meta charset=\"UTF-8\"/>\r\n" + "<title>页面</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "<div th:fragment=\"commen\">" + content + "</div>\r\n" + "</body>\r\n" + "</html>";
		String newFileName = UUID.randomUUID().toString() + ".html";
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
			Card card = new Card();
			card.setContent(newFileName);
			card.setName(bt);
			card.setPraise(0);
			Date d = new Date();
			card.setPubDate(d);
			card.setUid(user.getId());
			card.setTid(Integer.parseInt(type));
			int ret = frontUserCardService.save(card);
			if (ret==0) {
				return "/front/newpost";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/front/userCard";
	}

}
