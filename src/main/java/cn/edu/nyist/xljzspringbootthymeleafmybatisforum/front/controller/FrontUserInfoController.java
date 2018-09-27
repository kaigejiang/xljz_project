package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;

@Controller
@RequestMapping("/front")
public class FrontUserInfoController {
	@RequestMapping("/getUserInfo")
	public String fingUserInfo(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user.getId());
		model.addAttribute("user",user);
		return "front/userinfo";
	}
}
