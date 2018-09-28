package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToError {
	@RequestMapping("/toErr")
public String name() {
	return "err";
}
}
