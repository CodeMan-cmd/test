package com.qingniao.order.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.CookieUtils;
import com.qingniao.sso.service.UserService;

public class OrderInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private UserService userServiceImpl;
	
	@Value("${TT_TOKEN}")
	private String TT_TOKEN;
	
	@Value("${URL_LOGIN}")
	private String URL_LOGIN;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断用户是否登录
		//  用户存在redis的    用户的redis的key作为token  存到本地的cookie
		//首先去cookie中查找token（redis的key ）
		String token = CookieUtils.getCookieValue(request, TT_TOKEN);
		if(StringUtils.isBlank(token)){
			
			String url = request.getRequestURL().toString();
			response.sendRedirect(URL_LOGIN+"?redirect="+url);
			return false;
		} 
		QingNiaoResult result = userServiceImpl.getUserByToken(token);
		if(result.getData()==null){
			String url = request.getRequestURL().toString();
			response.sendRedirect(URL_LOGIN+"?redirect="+url);
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
	
}
