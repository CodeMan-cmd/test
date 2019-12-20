package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Employee;

import service.EmployeeService;

@Controller
public class IndexController {
		private EmployeeService employeeService;
		
		@RequestMapping("/ind")
		public String employeeSelect(HttpServletRequest req){
			List<Employee> employeeSelect = employeeService.employeeSelect();
			req.setAttribute("list", employeeSelect);
			return "index1.jsp";
		}
}
