package test;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yss.entity.User;
import cn.yss.service.UserService;

public class Test {
	public static void main(String[] args) throws ParseException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		User user = new User();
		/*
		 * List<User> selectAllUser = userService.selectAllUser(user); for (User
		 * user2 : selectAllUser) { System.out.println(user2); }
		 */

		/*
		 * user.setUserName("sa"); user.setUserPassword("123456");
		 * user.setPhone("1361111111"); user.setGender("男");
		 * user.setAddress("武汉市"); user.setBirthday(new
		 * SimpleDateFormat("yy-MM-dd").parse("2018-01-01")); int addUser =
		 * userService.addUser(user); if (addUser > 0) {
		 * System.out.println("新增成功！！"); }
		 */

		User userById = userService.getUserById(3);
		System.out.println(userById);

	}
}
