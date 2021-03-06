package com.bdqn.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.entity.User;

@Controller
//@Scope(value="prototype")
public class UserController {   //设计模式   单例     一个类只有一个对象
	
	//线程不安全？？?  多个线程操作一个对象（变量）  这个变量的值出现未知的一个异常  加锁
	/*private String username;
	public void setUsername(String username) {
		this.username = username;
	}*/
	
	private List<User> users = new ArrayList<User>();
	 
	public UserController(){
		users.add(new User(1,"虎大","111",new Date(),1,"ddadsda@qq.com","湖北"));
		users.add(new User(2,"熊二","222",new Date(),0,"ddadsda@qq.com","山东"));
		users.add(new User(3,"张三","333",new Date(),1,"ddadsda@qq.com","湖南"));
		users.add(new User(4,"李四","444",new Date(),0,"ddadsda@qq.com","山西"));
		users.add(new User(5,"王五","555",new Date(),1,"ddadsda@qq.com","山东"));
		users.add(new User(6,"马六","666",new Date(),0,"ddadsda@qq.com","湖南"));
		users.add(new User(7,"田七","777",new Date(),1,"ddadsda@qq.com","湖北"));

	
	
	}

	// 结论：地址匹配： value 和 method 两个共同决定 / 或者value确定 method不写
	// @RequestParam value 用来和参数匹配 defaultValue 默认值 required该参数 是否必须
	// 适配器 如何调方法？？？ 通过反射 调 login方法 方法里面的参数 就是通过反射来注值

	// request和model 都是容器，他们的作用域 相同 它们的生命周期相同
	@RequestMapping(value = { "/login" })
	public String login(
			@RequestParam(value = "username", defaultValue = "zhangsanfeng", required = false) String uname,
			@RequestParam(value = "password") String pass,
			HttpServletRequest request, Model model, Map<String, Object> map1) {
		/*
		 * HttpServletRequest request String username =
		 * request.getParameter("username"); String password =
		 * request.getParameter("password");
		 */
		// request.setAttribute("username",uname);
		// model.addAttribute(uname); //把值得类型 作为key 首字母小写 string
		// model.addAttribute("张三丰"); // string

		/*
		 * System.out.println(map1); System.out.println(model);
		 */
		model.addAttribute("username", uname);
		model.addAttribute("users", users);
		//return "../../list";
		return "list";
		//return "forward:/WEB-INF/jsp/list.jsp"; // 这是一个逻辑视图名 默认转发到这个逻辑视图名
	}

	@RequestMapping("/add.do")
	public String add() {
		// 返回值：就是返回一个逻辑视图名
		return "add";
	}
	
	
	//用户名的验证
	/*@RequestMapping("/vertifyUserName.do")
	@ResponseBody
	public String vertifyUserName(String username){
	
		for(User user : users){
			if(user.getUsername().equals(username)){
				return "<font color='red'>用户名已经存在</font>";
			}
		}
		return "<font color='green'>用户名可以使用</font>";
	}*/
	
	@RequestMapping("/vertifyUserName.do")
	@ResponseBody
	public Object vertifyUserName2(String username){
		//一般的来说   返回object  都是 json对象
		Map<String,Object> maps = new HashMap<String,Object>();
		User user1 = new User();
		user1.setUsername("刘备");
		user1.setBirthday(new Date());
		
		//豫州牧  46  26     诸葛亮  
		
		
		boolean flag = false;
		for(User user : users){
			if(user.getUsername().equals(username)){
				maps.put("data", "<font color='red'>用户名已经存在</font>");
				flag = true;
				break;
			}
		}
		if(!flag){
			maps.put("data", "<font color='red'>用户名可以使用</font>");
		}
		Object result = JSONArray.toJSON(maps);
		System.out.println(result);
		
		return result;
	}

	// 在添加的时候 不小心报了一个错 ？

	// 在springmvc中 如果请求 提交的 日期字符串的格是 xxxx/xx/xx 斜杠的话 它会自动转成 Date类型
	// 如果不是 斜杠 怎么办？？ @DateTimeFormat 注明转换格式，交给springmvc默认注册的日期类转换
	@RequestMapping("/toadd.do")
	public String addUser(User user, Model model,HttpServletRequest request) {
		 user.setId(users.size()+1);
		
		users.add(user);
		
	/*	System.out.println(user.getUpload().getOriginalFilename());
		String exetion = user.getUpload().getOriginalFilename().substring(
				user.getUpload().getOriginalFilename().lastIndexOf(".")+1);
		System.out.println(user.getUpload().getName());
		System.out.println(exetion);
		*/
		
		MultipartFile[] upload = user.getUpload();
		
		//文件要存起来  要存到    tomcat的  springmvc-8101/webapp/   upload文件夹
		//获取项目的根目录
		String path = request.getSession().getServletContext().getRealPath("/upload");
		for(int i = 0;i<upload.length;i++){
			
			String exetion = upload[i].getOriginalFilename().substring(
					upload[i].getOriginalFilename().lastIndexOf("."));
			
			File destFile = new File(path+File.separator+UUID.randomUUID()+exetion);
			try {
				FileUtils.copyInputStreamToFile(upload[i].getInputStream(), destFile);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		
		
		
		
		//model.addAttribute("users", user);
		//throw new UserException("你的代码有误");
		 
		model.addAttribute("users", users);
		
		return "list";
	} 
	
	//文件下载
	@RequestMapping(value="download.do")
	public String download(HttpServletRequest request,HttpServletResponse response){
		//根据id 去查询该用户  的简历文件名     youkai.docx
		//
		String fileName = "study.docx";
		if (fileName != null) {
			String realPath = request.getSession().getServletContext()
					.getRealPath("/upload/");
			File file = new File(realPath, fileName);// 要下载的文件
			if (file.exists()) {
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition",
						"attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;

				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer); // 初始读取 1024 byte 到buffer数组
					while (i != -1) {
						os.write(buffer, 0, i); // 把buffer数组 从 0 开始 到1024 结束
						// 这些字节写到 os里面去 依次类推
						i = bis.read(buffer);
					}
				} catch (Exception e) {
				} finally {

					if (bis != null || fis != null) {
						try {
							bis.close();
							fis.close();
						} catch (Exception e) {
						}
					}
				}

			}
		}
		return null;
	} 
	
	
	@RequestMapping("/list.do")
	public String list(Model model){
		model.addAttribute("users", users);
		return "list";
	}
	
	
	
	@RequestMapping("/deleteuser.do/{xx}/{yy}")
	public String deleteUserById(@PathVariable int xx,@PathVariable String yy,Model model){
		System.out.println(yy+xx);
		for(User user : users){
			if(user.getId() == xx){
				
				users.remove(user);
				break;
			}
		}
		model.addAttribute("users",users);
		//return "list";
		return "redirect:/list.do";
		//return "../../list";  //？如果是重定向   ？如果我的list不在WEB-INF/jsp 又怎么办
		//return "redirect:/list.jsp"; //不对的， 如果接上了指示符的话，那么再也不会去渲染这个视图了
	}
	
	
	//局部异常处理
/*	@ExceptionHandler(value={UserException.class})
	public ModelAndView handlerException(UserException ex){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex",ex);
		mv.setViewName("error");
		return mv;
	}*/
}
