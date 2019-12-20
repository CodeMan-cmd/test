package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;
import service.UserService;

public class Seivlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		UserService dao=new UserService();
		String info = request.getParameter("info");
		if (info.equals("insertUser")) {
		
		}if (info.equals("deleteUser")) {
			
		}if (info.equals("updateUser")) {
			
		}if (info.equals("selectUser")) {
			//²éÑ¯ËùÓÐ
			List<User> list=dao.selectUser();
			request.setAttribute("list",list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
