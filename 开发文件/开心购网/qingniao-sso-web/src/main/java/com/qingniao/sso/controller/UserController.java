package com.qingniao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.CookieUtils;
import com.qingniao.common.utils.JsonUtils;
import com.qingniao.pojo.TbUser;
import com.qingniao.sso.service.UserService;

@Controller
public class UserController {

	@Value("${TT_TOKEN}")
	private String TT_TOKEN;

	@Autowired
	private UserService userServiceImpl;
	@RequestMapping("/page/login")
	public String loginPage(String redirect, Model model) {
		model.addAttribute("redirect", redirect);
		return "login";
	}
 
	@RequestMapping("/page/register")
	public String registerPage() {
		return "register";
	}

	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public QingNiaoResult checkParam(@PathVariable String param, @PathVariable int type) {
		QingNiaoResult result = userServiceImpl.checkParam(param, type);
		return result;
	}

	@RequestMapping("/user/register")
	@ResponseBody
	public QingNiaoResult registor(TbUser user) {
		QingNiaoResult result = userServiceImpl.registor(user);
		return result;
	}

	@RequestMapping("/user/login")
	@ResponseBody
	public QingNiaoResult login(TbUser user, HttpServletRequest request, HttpServletResponse response) {
		QingNiaoResult result = userServiceImpl.login(user);
		String token = result.getData().toString();
		CookieUtils.setCookie(request, response, TT_TOKEN, token);

		return result;
	}

	// 判断用户是否登录 根据cookie的key 得到redis的key 然后查用户

	@RequestMapping("/user/token/{ticket}")
	@ResponseBody
	public String getUserByToken(@PathVariable String ticket, String callback) {
		QingNiaoResult result = userServiceImpl.getUserByToken(ticket);
		//如果是跨域请求
		if (StringUtils.isNotBlank(callback)) {
			String str = callback + "(" + JsonUtils.objectToJson(result.getData()) + ");";
			return str;
		}
		return JsonUtils.objectToJson(result.getData());
	}

}
