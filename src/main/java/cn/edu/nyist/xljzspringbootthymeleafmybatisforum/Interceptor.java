package cn.edu.nyist.xljzspringbootthymeleafmybatisforum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
		if (request.getSession().getAttribute("user") == null) {
			if (requestUri.endsWith("/toLogin") || requestUri.endsWith("/vcode.png")) {
				return true;
			} else if (requestUri.endsWith("/login") || requestUri.endsWith("/home") || requestUri.endsWith("/toHome")
					|| requestUri.endsWith("/toCardContent") || requestUri.endsWith("/cardContent")
					|| requestUri.endsWith(".html") || requestUri.endsWith(".js") || requestUri.endsWith(".jpeg")
					|| requestUri.endsWith(".jpg") || requestUri.endsWith(".png") || requestUri.endsWith("/toErr")
					|| requestUri.endsWith(".css")
					|| requestUri.endsWith("eg")
					|| requestUri.endsWith("sendEmail")
					) {
				return true;
			} else if (requestUri.endsWith("/error")) {
				response.sendRedirect("/toErr");
				return false;
			} else {
				response.sendRedirect("/toLogin");
				return true;
			}
		} else {
			if (requestUri.endsWith("/login")) {
				response.sendRedirect("/home");
				return false;
			}
			return true;
		}
	}
}
