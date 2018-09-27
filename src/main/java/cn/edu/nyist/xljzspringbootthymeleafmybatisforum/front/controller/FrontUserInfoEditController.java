package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common.model.User;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserEditService;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.service.FrontUserInfoSerive;
import cn.edu.nyist.xljzspringbootthymeleafmybatisforum.front.util.PhotoUtil;

@Controller
@RequestMapping("/front")
public class FrontUserInfoEditController {
	@Autowired
	private FrontUserEditService userEditService;
	@Autowired
	private FrontUserInfoSerive frontUserInfoSerive;
	@RequestMapping("/userEdit")
public String editUser(@ModelAttribute User user,Model model,@RequestParam MultipartFile photox,
		HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException {
	
	String fileName = photox.getOriginalFilename();
	String photoName = frontUserInfoSerive.findUserById(user.getId()).getPhoto();
	String photoPath = request.getServletContext().getRealPath("WEB-INF/upload/" + photoName);
	System.out.println(fileName);
	if (fileName != null && !fileName.equals("")) {
		// 解决IE下路径问题
		fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);
		// 解决名字重复问题
		String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		String newFileName = UUID.randomUUID().toString() + "." + ext;
		String	realPath = request.getServletContext().getRealPath("WEB-INF/upload/" + newFileName);
		photox.transferTo(new File(realPath));
		user.setPhoto(newFileName);
	}
	int ret = userEditService.editUserInfo(user);
	System.out.println(ret);
	if (ret > 0) {
		if (photoPath!=null) {
			PhotoUtil.delFile(photoPath);
		}
		User user2 = frontUserInfoSerive.findUserById(user.getId());
		session.setAttribute("user", user2);
		return "redirect:/front/getUserInfo";
	} else {
		return "redirect:/front/getUserInfo";
	}
}
}
