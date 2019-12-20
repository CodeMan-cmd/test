package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Audio;

import service.AudioService;

public class AudioServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		AudioService dao = new AudioService();
		String info = request.getParameter("info");
		if (info.equals("Landing")) {
			String user = request.getParameter("user");
			String pwd = request.getParameter("pwd");
			if (dao.isExists(user, pwd)) {
				response.sendRedirect("AudioServlet?info=getAllPerson");
			}else {
				request.getSession().setAttribute("msg", "用户名密码不匹配");
				response.sendRedirect("index.jsp");
			}
		} else if (info.equals("getAllPerson")) {
			//查询所有
			List<Audio> list=dao.getAllPerson();
			request.setAttribute("list",list);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else if (info.equals("add")) {
			//添加
			String name=request.getParameter("name");
			String music=request.getParameter("music");
			String video=request.getParameter("video");
			String image=request.getParameter("image");
			Audio p=new Audio(name, music, video, image);
			int num2=dao.addProduct(p);
			if (num2>0) {
				response.sendRedirect("AudioServlet?info=getAllPerson");
			}
			}else if (info.equals("deletePerson")) {
				int id=Integer.parseInt(request.getParameter("id"));
				int num=dao.deletePerson(id);
				if (num>0) {
					request.getRequestDispatcher("AudioServlet?info=getAllPerson").forward(request, response);
				}
		}else if (info.equals("selectAllid")) {
			//根据id查询
			int id=Integer.parseInt(request.getParameter("id"));
			Audio p=dao.getByuserId(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("update.jsp").forward(request,response);
		}else if (info.equals("updateAudio")) {
			//修改
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String music=request.getParameter("music");
			String video=request.getParameter("video");
			String image=request.getParameter("image");
			System.out.println(123);
			Audio p=new Audio(id, name, music, video, image);
			int num = dao.updatePerson(p);
			if (num > 0) {
				System.out.println(123123);
				response.sendRedirect("AudioServlet?info=getAllPerson");
			}
		}
	}
}
