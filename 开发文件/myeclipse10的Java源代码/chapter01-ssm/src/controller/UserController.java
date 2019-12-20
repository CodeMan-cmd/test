package controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jboss.logging.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import pojo.User;

import service.UserService;
import util.Page;
@Controller
public class UserController extends BaseController  {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("sc")
	public String addSave(@RequestParam(value="a_idPicPath",required=false) MultipartFile mf,@Valid User user ,BindingResult br) throws IOException{
		/*if(br.hasErrors()){
			return "res";///注册页面
		}*/
		/*int addUser = userService.addUser(user);
		if(addUser>0){
			return "index";
		}else{
		}*/
		
		System.out.println(mf.getOriginalFilename());
		
		///判断文件是否存在,,
		//声明一个入径存储图片
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(date);
		
		String newPicUrl=format+"---"+mf.getOriginalFilename();
		File f=new File("C:\\Users\\Administrator\\Desktop\\myeclipse10的Java源代码\\spring-batis\\WebRoot\\imgae\\"+newPicUrl);
		byte[] bytes = mf.getBytes();
		
		//FileInputStream fis=new FileInputStream(file);
		FileOutputStream fos=new FileOutputStream(f);//创建字节输出流
		DataOutputStream dos=new DataOutputStream(fos);//创建数据输出流
		
		dos.write(bytes);
		dos.close();
		fos.close();
		
		return "add";
	}
	
	
	/**
	 * 
	 * @param userCode 用户编码参数		非必须
	 * @param userName 用户名参数			非必须
	 * @param dangqianyeshu 当前页数参数	非必须
	 * @param req   
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/cc")
	public String showUserPR(@RequestParam(value="userCode",required=false)String userCode,@RequestParam(value="userName",required=false)String userName,@RequestParam(value="dangqianyeshu",required=false) String dangqianyeshu,HttpServletRequest req) throws UnsupportedEncodingException{
		
		Page p=new Page();
		User u=new User();
		if(!"".equals(dangqianyeshu)&&null!=dangqianyeshu){
			p.setDangqianyeshu(Integer.parseInt(dangqianyeshu));//////String 类型转换int类型    强类型转换
			
		}
		if(!"".equals(userCode)&&null!=userCode){
			u.setUserCode(userCode);
			req.setAttribute("userCode",userCode);
		}
		if(!"".equals(userName)&&null!=userName){
			String userNameNew=new String(userName.getBytes("iso-8859-1"),"utf-8");
			System.out.println(userNameNew);
			u.setUserName(userNameNew);
			req.setAttribute("userName", userNameNew);
		}
		List<User> selectByPR = userService.selectByPR(u, p);
		req.setAttribute("list",selectByPR);
		if(p.getDangqianyeshu()>p.getZongyeshu()){
			p.setDangqianyeshu(p.getZongyeshu());
		}
		if(p.getDangqianyeshu()<=0){
			p.setDangqianyeshu(1);
		}
		
		req.setAttribute("p", p);
		return "index";
	}
	
	
	
	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return  当返回值是String类型的时候  默认返回视图  view
	 * @throws Exception
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String afsadfasd(HttpServletRequest arg0,
			HttpServletResponse arg1,
			@RequestParam(value="username",required=false) String username,
			@RequestParam(value="password",required=false) String password) 
					throws Exception {
		ModelAndView m=new ModelAndView();
		m.setViewName("cc");
		arg0.setAttribute("a", username);
		arg0.setAttribute("b",password);
		return "cc";
	}
	
	@RequestMapping("loginIndex")
	public String loginIndex(){
		//System.out.println(5/0);
		return "Login";
	}
	
	@RequestMapping("form1User")
	public String form1User(String userName,String password,HttpServletRequest req,HttpSession session,HttpServletResponse res) throws Exception{
		System.out.println(userName);
		if(null!=userName&&userName!=""){
			User u=new User();
			u.setUserName(userName);
			int addUser = userService.addUser(u);
			System.out.println(addUser);
			return"Login";
		}else{
			//返回成功页面
			throw new RuntimeException("用户名不能为null.");
			//return "cc";//
		}
	}
	
	
	@ExceptionHandler(value=RuntimeException.class)
	public String handlerException(RuntimeException e,HttpServletRequest req){
		req.setAttribute("e",e.getMessage());
		return "error";
	}
	
	@RequestMapping("res")
	public String Show(@ModelAttribute("user") User user){
		return "res";
	}
	
	@RequestMapping(value="/getUserById/{id}")
	public String getUserById(@PathVariable String id,HttpServletRequest req){
		List<User> selectById = userService.selectById(Integer.parseInt(id));
		req.setAttribute("user",selectById.get(0));
		return "usermodify";
	}
	
	@RequestMapping("modifyUserSave")
	public String modifyUserSave(User u) throws UnsupportedEncodingException{
		String name=new String(u.getUserName().getBytes("iso-8859-1"),"utf-8");
		u.setUserName(name);
		int modifyUserSave = userService.modifyUserSave(u);
		if(modifyUserSave>0){
			return "index";
		}else
		{
			return "usermodify";
		}
	}
	
	@RequestMapping("resCode")
	@ResponseBody
	public String resCode(String userCode) throws UnsupportedEncodingException{
		String name=new String(userCode.getBytes("iso-8859-1"),"utf-8");
		List<User> resUserCode = userService.resUserCode(name);
		
		if(resUserCode.size()>0){
			return "{\"name\":\"用户已经存在!\"}";
		}else{
			return "{\"name\":\"✔\"}";
		}
	}
	
}
