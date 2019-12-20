package controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.User;

import service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService service;

	// 查询用户信息
	@RequestMapping("/index")
	public String selectAllUser(HttpServletRequest request) {
		User user = new User();
		List<User> list = service.selectAllUser(user);
		request.setAttribute("list", list);
		return "index";
	}

	// 新增页面
	@RequestMapping("/add")
	public String addUser() {
		return "addUser";
	}

	// 判断新增是否成功
	@RequestMapping("/addSuccess")
	public String addSuccess(User user) {
		int addUser = service.addUser(user);
		if (addUser > 0) {
			return "redirect:/index";
		} else {
			return "addUser";
		}
	}

	// 根据id查询信息
	@RequestMapping("/ById")
	public String ByIdUser(
			@RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
			HttpServletRequest request) {
		User userById = service.getUserById(id);
		request.setAttribute("user", userById);
		return "ByIdView";
	}

	// 修改页面
	@RequestMapping("/modify")
	public String modifyUser(
			@RequestParam(value = "id", required = false) Integer id,
			HttpServletRequest request) {
		User userById = service.getUserById(id);
		request.setAttribute("user", userById);
		return "modifyUser";
	}

	// 判断修改是否成功
	@RequestMapping("/modifySuccess")
	public String moSuccess(User user,@RequestParam(value="id",required=false)int id) {
		user.setId(id);
		int updateUser = service.updateUser(user);
		if (updateUser > 0) {
			return "redirect:/index";
		} else {
			return "modifyUser";
		}
	}
	//根据id删除用户
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam(value="id",required=false)int id){
		service.deleteUser(id);
		return "redirect:/index";
	}
}
