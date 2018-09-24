package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserInfoSerive;

@Controller
@RequestMapping("/front")
public class FrontUserInfoController {
	@Autowired
	private FrontUserInfoSerive frontUserInfoSerive;
	@RequestMapping("/getUserInfo")
	public String fingUserInfo(Model model) {
		User user = frontUserInfoSerive.findUserById(1);
		model.addAttribute("user",user);
		return "front/userinfo";
	}
}
