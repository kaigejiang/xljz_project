package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {

	}
	
	// 跳转到注册界面
		@RequestMapping(path = "/toReg")
		public String toReg() {
			return "reg";
		}
		
	//注册
		@RequestMapping("/reg")
		public String reg(@ModelAttribute User user,@RequestParam String vcode,@RequestParam MultipartFile photop,HttpServletRequest request,Model model,HttpSession session) throws Exception, IOException {
			// 先进行验证码验证，验证通过才能访问数据库
			// 获取服务器端验证码
			String servserCode = (String) session.getAttribute(ValidVController.serverVcodeName);
			if (!servserCode.equalsIgnoreCase(vcode)) {
				model.addAttribute("msg", "验证码错误");
				return "/reg";
			}
			String userName=user.getName();
			// 如果数据库中没有该用户，可以注册，否则跳转页面
			if(userService.findByUserName(userName)==null) {
				System.out.println("=====================");
				String fileName = photop.getOriginalFilename();
				// 解决IE下路径问题
				fileName = fileName.lastIndexOf("\\") == -1 ? fileName :fileName.substring(fileName.lastIndexOf("\\") + 1);
				// 解决名字重复问题
				String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
				String newFileName = UUID.randomUUID().toString() + "." + ext;
				photop.transferTo(new File(request.getServletContext().getRealPath("WEB-INF/upload/" + newFileName)));
				user.setPhoto(newFileName);
				
				//注册
				userService.addUser(user);
				return "redirect:/home";
			}
			else {
				// 注册失败跳转到错误页面
				model.addAttribute("msg", "该用户名已存在");
				return "reg";
			}			
		}
		

	//跳转到登录
	@RequestMapping(path = "/toLogin")
	public String toLogin() {
		return "login";
	}

	//登录
	@RequestMapping(path = "/login")
	public String login(@RequestParam String name, @RequestParam String pwd, @RequestParam String vcode, Model model,HttpSession session) {
		// 先进行验证码验证，验证通过才能访问数据库
		// 获取服务器端验证码
		String servserCode = (String) session.getAttribute(ValidVController.serverVcodeName);
		if (!servserCode.equalsIgnoreCase(vcode)) {
			model.addAttribute("msg", "验证码错误");
			return "/login";
		}

		User user = userService.find(name, pwd);
		System.out.println("========="+user);
		if (user == null) {
			model.addAttribute("msg", "用户名或密码错误");
			return "login";// 登录失败
		}
		// 存下来，以便后面根据us的值判断是否登录
		session.setAttribute("user", user);
		//return "redirect:/main";
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String toHome() {
		return "main";
	}
	
	
}
